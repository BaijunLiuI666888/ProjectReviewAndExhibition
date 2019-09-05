/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Cart;
import Dtos.Order;
import Dtos.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author d00172193
 */
public class OrderDao extends Dao implements OrderDaoInterface {

    public OrderDao(String databaseName) {
        super(databaseName);
    }

    @Override
    public int orderInitialize(int userId) {
        Connection con = null;
        int rowsAffected = 0;
        PreparedStatement ps = null;
       Calendar calendar = Calendar.getInstance();
      java.sql.Date date1 = new java.sql.Date(calendar.getTime().getTime());
        

        try {
            con = getConnection();

            String query = " insert into salesorder (UserID)"
                    + " values (?)";

            ps = con.prepareStatement(query);
            ps.setInt(1, userId);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the OrderInitialize() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the OrderInitialize() method");
                e.getMessage();
            }
        }
        return rowsAffected;
    }
       
    public int confirmOrderPriceDate(double price,int orderid) {
        Connection con = null;
        int rowsAffected = 0;
        PreparedStatement ps = null;
       Calendar calendar = Calendar.getInstance();
      java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
        

        try {
            con = getConnection();

            String query = " UPDATE salesorder SET orderdate=?, total = ? WHERE  orderid=? ";

            ps = con.prepareStatement(query);
            ps.setDate(1, date);
            ps.setDouble(2, price);
            ps.setDouble(3, orderid);


            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the confirmOrderPriceDate() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the confirmOrderPriceDate() method");
                e.getMessage();
            }
        }
        return rowsAffected;
    }
//    @Override
//      public List<CartProduct> AllInCartByUserId(int id) {
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        ArrayList<CartProduct> itemList = new ArrayList();
//
//        try {
//            con = getConnection();
//
//            String query = "SELECT * FROM cart INNER JOIN product ON cart.productID = product.productID WHERE userID = ?";
//            ps = con.prepareStatement(query);
//
//            ps.setInt(1, id);
//
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                CartProduct c = new CartProduct(rs.getInt("CartID"), rs.getInt("UserID"), rs.getInt("ProductID"),  rs.getInt("CategoryID"), rs.getString("ProductName"),rs.getString("Brand"),rs.getDouble("Weight"),rs.getString("Description"),
//                        rs.getInt("Stock"),rs.getDate("Date"),rs.getBytes("image1"),rs.getBytes("image2"),rs.getDouble("Price"),rs.getInt("quantity"));
//                itemList.add(c);
//
//            }
//        } catch (SQLException e) {
//            System.out.println("Exception occured in the getProductByCode() method: " + e.getMessage());
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (ps != null) {
//                    ps.close();
//                }
//                if (con != null) {
//                    freeConnection(con);
//                }
//            } catch (SQLException e) {
//                System.out.println("Exception occured in the finally section of the getProductByCode() method: " + e.getMessage());
//            }
//        }
//        return itemList;
//    }

    public int getOrderIdByUid(int uid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int u = 0;

        try {
            con = getConnection();

            String query = "SELECT orderid from salesorder WHERE userid = ? and total is null ";
            ps = con.prepareStatement(query);

            ps.setInt(1, uid);

            rs = ps.executeQuery();

            if (rs.next()) {
                u = rs.getInt("orderid");
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getOrderIdByUid() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getOrderIdByUid() method: " + e.getMessage());
            }
        }

        return u;
    }
    //SELECT * from orderproductdetail inner join salesorder on orderproductdetail.OrderID=salesorder.OrderID where UserID=9 
    
//        public List<OrderProduct> getFullOrderDetailsByUid(int userid) {
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        List<OrderProduct> cproducts = new ArrayList();
//
//        try {
//            con = getConnection();
//
//            String query = "SELECT * from orderproductdetail inner join salesorder on orderproductdetail.OrderID=salesorder.OrderID where UserID=?";
//            ps = con.prepareStatement(query);
//
//            ps.setInt(1, userid);
//
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                OrderProduct p = new OrderProduct(rs.getInt("ProductID"), rs.getInt("CategoryID"), rs.getString("ProductName"),rs.getString("CategoryName"), rs.getString("Brand"), rs.getDouble("Weight"), rs.getString("Description"),rs.getString("cDescription"),
//                        rs.getInt("Stock"),rs.getString("Date"),rs.getBytes("image1"),rs.getBytes("image2"),rs.getDouble("Price"));
//                cproducts.add(p);
//            }
//        } catch (SQLException e) {
//            System.out.println("Exception occured in the getFullProductInfoByPid() method: " + e.getMessage());
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (ps != null) {
//                    ps.close();
//                }
//                if (con != null) {
//                    freeConnection(con);
//                }
//            } catch (SQLException e) {
//                System.out.println("Exception occured in the finally section of the getFullProductInfoByPid() method: " + e.getMessage());
//            }
//        }
//
//        return cproducts;
//    }
    
    
    
     public List<Order> getAllOrders(int userid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Order> orders = new ArrayList();

        try {
            con = getConnection();

            String query = "Select * from salesorder where userid=? And 'date' is not null ";
            ps = con.prepareStatement(query);
            ps.setInt(1, userid);
            rs = ps.executeQuery();

            while (rs.next()) {
              Order p = new Order(rs.getInt("orderid"), rs.getInt("userid"), rs.getDate("orderdate"), rs.getString("status"), rs.getDate("shippingdate"), rs.getDouble("total"),rs.getDouble("discount"));
                orders.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllOrders() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getAllOrders() method: " + e.getMessage());
            }
        }

        return orders;
    }
    
    
}
