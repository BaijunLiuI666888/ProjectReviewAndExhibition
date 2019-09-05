/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.CartProduct;
import Dtos.WishProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LYJni
 */
public class WishlistDao extends Dao implements WishlistDaoInterface {

    public WishlistDao(String databaseName) {
        super(databaseName);
    }
    
    @Override
    public int addToWishlist(int uid, int pid) {
        Connection con = null;
        int rowsAffected = 0;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String query = " insert into wishlist (userid, productid)"
                    + " values (?, ?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, uid);
            ps.setInt(2, pid);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the addToWishlist() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the addToWishlist() method");
                e.getMessage();
            }
        }
        return rowsAffected;
    }
    
     public List<WishProduct> getWishlistProductByUserId(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<WishProduct> itemList = new ArrayList();

        try {
            con = getConnection();

            String query = "SELECT * FROM wishlist INNER JOIN product ON wishlist.productID = product.productID WHERE userID = ?";
            ps = con.prepareStatement(query);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                WishProduct c = new WishProduct(rs.getInt("wishlistid"), rs.getInt("UserID"), rs.getInt("ProductID"), rs.getInt("CategoryID"), rs.getString("ProductName"), rs.getString("Brand"), rs.getDouble("Weight"), rs.getString("Description"),
                        rs.getInt("Stock"), rs.getDate("Date"), rs.getBytes("image1"), rs.getBytes("image2"), rs.getDouble("Price"));
                itemList.add(c);

            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getWishlistProductByUserId() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getWishlistProductByUserId() method: " + e.getMessage());
            }
        }
        return itemList;
    }
    
    
    
    
}
