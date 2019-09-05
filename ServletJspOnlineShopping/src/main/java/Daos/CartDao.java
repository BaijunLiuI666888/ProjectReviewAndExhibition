/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Cart;
import Dtos.CartProduct;
import Dtos.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author d00172193
 */
public class CartDao extends Dao implements CartDaoInterface {

    public CartDao(String databaseName) {
        super(databaseName);
    }

    @Override
    public int addToCart(int userId, int productId, int quantity) {
        Connection con = null;
        int rowsAffected = 0;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String query = " insert into cart (UserID,ProductID, Quantity)"
                    + " values (?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, userId);
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
    @Override
      public List<CartProduct> AllInCartByUserId(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<CartProduct> itemList = new ArrayList();

        try {
            con = getConnection();

            String query = "SELECT * FROM cart INNER JOIN product ON cart.productID = product.productID WHERE userID = ?";
            ps = con.prepareStatement(query);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                CartProduct c = new CartProduct(rs.getInt("CartID"), rs.getInt("UserID"), rs.getInt("ProductID"),  rs.getInt("CategoryID"), rs.getString("ProductName"),rs.getString("Brand"),rs.getDouble("Weight"),rs.getString("Description"),
                        rs.getInt("Stock"),rs.getDate("Date"),rs.getBytes("image1"),rs.getBytes("image2"),rs.getDouble("Price"),rs.getInt("quantity"));
                itemList.add(c);

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getProductByCode() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getProductByCode() method: " + e.getMessage());
            }
        }
        return itemList;
    }
          public int EmptyCart(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ra = 0;
        try {
            con = getConnection();
            //delete from users table
            String query = "DELETE FROM cart WHERE userId=?";

            ps = con.prepareStatement(query);
            ps.setInt(1, id);

           ra= ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Exception occured in the EmptyCard() method");
            e.getMessage();
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
                System.out.println("Exception occured in the finally section of the EmptyCard() method");
                e.getMessage();
            }
        }
        return ra;
    }

    public int deleteCartItem(int productId,int userId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ra = 0;
        try {
            con = getConnection();
            //delete from users table
            String query = "DELETE FROM cart WHERE productId=? AND userid=?";

            ps = con.prepareStatement(query);
            ps.setInt(1, productId);
            ps.setInt(2,userId);

            ra=ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Exception occured in the EmptyCard() method");
            e.getMessage();
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
                System.out.println("Exception occured in the finally section of the EmptyCard() method");
                e.getMessage();
            }
        }
        return ra;
    }
}
