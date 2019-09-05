/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.CategoryProduct;

import Dtos.Product;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Danielhua
 */
public class ProductDao extends Dao implements ProductDaoInterface{
private final int MAX_SIZE = 2;
    public ProductDao(String databaseName) {
        super(databaseName);
    }
    
    
     public int newProduct(String ProdcutName ,String Brand ,double Weight ,String Description  ,int Stock, String Date,byte[] image1,byte[] image2 ,double price )
             
     {
          Connection con = null;
           int rowsAffected = 0;
           PreparedStatement ps = null; 

           
       try {
            con = getConnection();
            String query =  " insert into product (ProductName,Brand,Weight, Description, Stock, Date,image1, image2,price)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1,ProdcutName);
            ps.setString(2,Brand);
            ps.setDouble(3, Weight);
            ps.setString(4,Description );
            ps.setInt(5, Stock);
            ps.setString(6, Date);
            ps.setBytes(7, image1);
            ps.setBytes(8, image2);
            ps.setDouble(9, price);
            rowsAffected = ps.executeUpdate();
            
   } catch (SQLException e) {
            System.out.println("Exception occured in the newProduct method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the newProduct) method");
                e.getMessage();
            }
        }
return rowsAffected;
    }
  @Override
    public List<Product> getAllProducts() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Product> Products = new ArrayList();

        try {
            con = getConnection();

            String query = "Select * from Product ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
              Product p = new Product(rs.getInt("ProductID"), rs.getInt("CategoryID"), rs.getString("ProductName"), rs.getString("Brand"), rs.getDouble("Weight"), rs.getString("Description"),rs.getInt("Stock"),rs.getDate("Date"),rs.getBytes("image1"),rs.getBytes("image2"),rs.getDouble("Price"));
                Products.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllProducts() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getAllProducts() method: " + e.getMessage());
            }
        }

        return Products;
    }
    @Override
        public List<CategoryProduct> getFullProductInfoByPid(int pid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CategoryProduct> cproducts = new ArrayList();

        try {
            con = getConnection();

            String query = "SELECT * FROM product INNER JOIN category ON product.categoryID = category.categoryID WHERE productID = ? ";
            ps = con.prepareStatement(query);

            ps.setInt(1, pid);

            rs = ps.executeQuery();

            while (rs.next()) {
                CategoryProduct p = new CategoryProduct(rs.getInt("ProductID"), rs.getInt("CategoryID"), rs.getString("ProductName"),rs.getString("CategoryName"), rs.getString("Brand"), rs.getDouble("Weight"), rs.getString("Description"),rs.getString("cDescription"),
                        rs.getInt("Stock"),rs.getString("Date"),rs.getBytes("image1"),rs.getBytes("image2"),rs.getDouble("Price"));
                cproducts.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getFullProductInfoByPid() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getFullProductInfoByPid() method: " + e.getMessage());
            }
        }

        return cproducts;
    }
    @Override
             public boolean DeleteProduct (int id)
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean deleteOk = false;
        try{
            con = getConnection();
            //delete from users table
            String query = "DELETE FROM product WHERE ProductID=?";
            
            ps = con.prepareStatement(query);
            ps.setInt(1,id);
            
            ps.executeUpdate(); 
            deleteOk = true;
        }
        catch (SQLException e) {
            System.out.println("Exception occured in the DeleteProduct() method");
            e.getMessage();
        } 
        finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (con != null)
                    freeConnection(con);
            } 
            catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the DeleteProduct() method");
                e.getMessage();
            }
        }
        return deleteOk;
    }

    @Override
        public List<CategoryProduct> getFullProductInfoByPName(String pName) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CategoryProduct> cproducts = new ArrayList();
        

        try {
            con = getConnection();

            String query = "SELECT * FROM product INNER JOIN category ON product.categoryID = category.categoryID WHERE productName = ? ";
            ps = con.prepareStatement(query);
 
            ps.setString(1, pName);

            rs = ps.executeQuery();

            while (rs.next()) {
                CategoryProduct p = new CategoryProduct(rs.getInt("ProductID"), rs.getInt("CategoryID"), rs.getString("ProductName"),rs.getString("CategoryName"), rs.getString("Brand"), rs.getDouble("Weight"), rs.getString("Description"),rs.getString("cDescription"),
                        rs.getInt("Stock"),rs.getString("Date"),rs.getBytes("image1"),rs.getBytes("image2"),rs.getDouble("Price"));
                cproducts.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getFullProductInfoByPid() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getFullProductInfoByPid() method: " + e.getMessage());
            }
        }

        return cproducts;
    }
 
    public int getCountPage()  {  
           Connection con = null;
            con = getConnection();
        PreparedStatement ps = null;  
        ResultSet rs = null;  
        int countPage = 0;  
        int total = 0;  
        String sql = "SELECT COUNT(*) AS num FROM message";   //查询记录条数，然后把查询结果另外起一个别名，叫做num  
  
        try {  
            ps = con.prepareStatement(sql);  
            rs = ps.executeQuery();  
  
            if (rs.next()) {  
                total = rs.getInt("num");   //total为留言的总条数  
            }  
              
             //    总页数=总条数/每页显示最大留言数，能除尽时直接取结果，不能除尽时，结果加1，多加一页来显示  
            countPage = (total % MAX_SIZE == 0 ? total / MAX_SIZE : total  
                    / MAX_SIZE + 1);    
              
            if (countPage != 0)  
                return countPage;  
            return countPage + 1;   //没有第0页，所以加1  
        } catch (SQLException e) {  
            throw new RuntimeException(e.getMessage(), e);  
        } finally {
              try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getCountPage() method: " + e.getMessage());
            }
    
        }
    }
    public List<Product> getProduct(int currentPage) throws SQLException {   //currentPage为当前页数  
          Connection con = null;
            con = getConnection();  
        List<Product> Products = new ArrayList();  
        PreparedStatement ps = null;  
        ResultSet rs = null;  
          String query = "Select * from Product ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

         
        /* 
         * order by id desc --按id列大小降序排列，不加desc就是升序排列 
         * LIMIT 100,15--从查询的结果中第100条开始取出15条数据 
         */  
          
        try {  
            ps = con.prepareStatement(query);  
            ps.setInt(1, (currentPage - 1) * MAX_SIZE);  
            ps.setInt(2, MAX_SIZE);  
            rs = ps.executeQuery();  
  
             while (rs.next()) {
              Product p = new Product(rs.getInt("ProductID"), rs.getInt("CategoryID"), rs.getString("ProductName"), rs.getString("Brand"), rs.getDouble("Weight"), rs.getString("Description"),rs.getInt("Stock"),rs.getDate("Date"),rs.getBytes("image1"),rs.getBytes("image2"),rs.getDouble("Price"));
                Products.add(p);
            } 
        } catch (SQLException e) {  
            throw new RuntimeException(e.getMessage(), e);  
        } finally {
              try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getCountPage() method: " + e.getMessage());
            }
    
        }
        return Products;  
    }  
    
}

    
    
    

