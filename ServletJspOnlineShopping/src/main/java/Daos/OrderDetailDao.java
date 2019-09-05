/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Cart;
import Dtos.CartProduct;
import Dtos.OrderProduct;
import Dtos.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author d00172193
 */
public class OrderDetailDao extends Dao implements OrderDetailDaoInterface {

    public OrderDetailDao(String databaseName) {
        super(databaseName);
    }

    public int addToDetail(int orderID, int productId, int quantity) {
        Connection con = null;
        int rowsAffected = 0;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String query = " insert into cart (UserID,ProductID, Quantity)"
                    + " values (?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, orderID);
            ps.setInt(2, productId);
            ps.setInt(3, quantity);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the addToCart() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the addToCart() method");
                e.getMessage();
            }
        }
        return rowsAffected;
    }
  
      public List<OrderProduct> AllInOrderByOrderId(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<OrderProduct> itemList = new ArrayList();

        try {
            con = getConnection();

            String query = "SELECT * FROM product p INNER JOIN orderproductdetail od on od.ProductID = p.ProductID INNER JOIN salesorder so on so.OrderID = od.OrderID WHERE so.OrderID=? ";
            ps = con.prepareStatement(query);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                OrderProduct c = new OrderProduct(rs.getInt("productid"), rs.getInt("categoryid"), rs.getString("productname"),  rs.getString("brand"), rs.getDouble("weight"),rs.getString("description"),rs.getInt("stock"),rs.getDate("Date"),
                        rs.getBytes("image1"),rs.getBytes("image2"),rs.getDouble("price"),rs.getInt("orderid"),rs.getInt("quantity"),rs.getInt("userid"),rs.getDate("orderdate"),rs.getString("status"),rs.getDate("shippingdate"),rs.getDouble("total"),rs.getDouble("discount"));
                itemList.add(c);

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the AllInOrderByOrderId() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the AllInOrderByOrderId() method: " + e.getMessage());
            }
        }
        return itemList;
    }

    public int addDetail(Map items, int orderid) {

        Connection con = null;
        int rowsAffected = 0;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            Set set = items.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry) iterator.next();

                int proid = (Integer) mentry.getKey();
                int quantity = (Integer) mentry.getValue();

                String query = " INSERT INTO `orderproductdetail`(`OrderID`, `ProductID`, `Quantity`) VALUES (?,?,?)";
                ps = con.prepareStatement(query);
                ps.setInt(1, orderid);
                ps.setInt(2, proid);
                ps.setInt(3, quantity);
                rowsAffected += ps.executeUpdate();
            }

            

        } catch (SQLException e) {
            System.out.println("Exception occured in the addToCart() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the addToCart() method");
                e.getMessage();
            }
        }
        return rowsAffected;

    }
}
