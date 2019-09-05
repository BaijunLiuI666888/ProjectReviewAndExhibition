/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Category;
import Dtos.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danielhua
 */
public class CategoryDao extends Dao implements CategoryDaoInterface{
    
      public CategoryDao(String databaseName) {
        super(databaseName);
      }
      
      @Override
       public int addCategory(String CategoryName, String Description)
       {
             Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();

            String query = "INSERT into category (CategoryName,cDescription) VALUES (?,?)"; 
           
            ps = con.prepareStatement(query);
            ps.setString(1, CategoryName);
            ps.setString(2, Description);
         

            rowsAffected = ps.executeUpdate();
              } catch (SQLException e) {
            System.out.println("Exception occured in the AddBook() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the AddBook() method");
                e.getMessage();
            }
        }

        return rowsAffected;
    }
       
      @Override
        public List<Category> getAllCategory()
        {
         Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Category> Categories = new ArrayList();

        try {
            con = getConnection();

            String query = "Select * from category ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
             Category c = new Category(rs.getInt("CategoryID"), rs.getString("CategoryName"),rs.getString("cDescription"));
                Categories.add(c);
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

        return Categories;
    }   
           public List<Product> getAllProductsByCID(int pid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Product> Products = new ArrayList();

        try {
            con = getConnection();

            String query = "Select * from Product where categoryid=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, pid);
            rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product(rs.getInt("ProductID"), rs.getInt("CategoryID"), rs.getString("ProductName"), rs.getString("Brand"), rs.getDouble("Weight"), rs.getString("Description"), rs.getInt("Stock"), rs.getDate("Date"), rs.getBytes("image1"), rs.getBytes("image2"), rs.getDouble("Price"));
                Products.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllProductsByCID() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getAllProductsByCID() method: " + e.getMessage());
            }
        }

        return Products;
    }   
            
        }          
                
                
                
                
                
                
                
       
      
      
      
        
        
    

