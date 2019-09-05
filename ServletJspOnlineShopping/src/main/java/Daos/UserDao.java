/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.User;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Danielhua
 */
public class UserDao extends Dao implements UserDaoInterface {

    public UserDao(String databaseName) {
        super(databaseName);
    }
            //=====================================//
        String key = "Bar12345Bar12345"; // 128 bit key
        String initVector = "RandomInitVector"; // 16 bytes IV

       
         
        //==============================================

//          public static String sha256(String msg) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA256");
//            md.update(msg.getBytes());
//            byte byteData[] = md.digest();
//            
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < byteData.length; i++) {
//                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
//            }
//            return sb.toString();
//        } catch (Exception ex) {
//            return "";
//        }
//    }
    public static String encrypt(String key, String initVector, String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            System.out.println("encrypted string: "
                    + Base64.encodeBase64String(encrypted));

            return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String key, String initVector, String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public int register(String userName, String password, String firstName, String lastName, String gender, String phone, String email, String address) {
        Connection con = null;
        int rowsAffected = 0;
        PreparedStatement ps = null;
        Calendar calendar = Calendar.getInstance();
        java.sql.Date joiningDate = new java.sql.Date(calendar.getTime().getTime());
        boolean ifVip = false;
        boolean ifAdmin = false;


        try {
            con = getConnection();

            String query = " insert into user (UserName,Password,FirstName, LastName,Gender, Phone, Email,Address, Date,ifAdmin,ifVip)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, encrypt(key, initVector, password));
            ps.setString(3, firstName);
            ps.setString(4, lastName);
            ps.setString(5, gender);
            ps.setString(6, phone);
            ps.setString(7, email);
            ps.setString(8, address);
            ps.setDate(9, joiningDate);
            ps.setBoolean(10, ifAdmin);
            ps.setBoolean(11, ifVip);
            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the register() method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the register() method");
                e.getMessage();
            }
        }
        return rowsAffected;
    }

    @Override
    public User checkLogin(String uname, String pword) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            con = this.getConnection();

            String query = "SELECT * FROM user WHERE UserName = ? AND Password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, encrypt(key, initVector,pword));

            rs = ps.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("UserID");
                String userName = rs.getString("UserName");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String gender = rs.getString("Gender");
                String phone = rs.getString("Phone");
                String email = rs.getString("Email");
                String address = rs.getString("Address");
                String date = rs.getString("Date");
                Boolean ifAdmin = rs.getBoolean("ifAdmin");
                Boolean ifVip = rs.getBoolean("ifVip");

                u = new User(userId, userName, password, firstName, lastName, gender, phone, email, address, date, ifAdmin, ifVip);
            }
        } catch (SQLException e) {
            System.out.println("An error occurred in the checklogin() method: " + e.getMessage());
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
                System.out.println("An error occurred when shutting down the checklogin() method: " + e.getMessage());
            }
        }
        return u;
    }

    @Override
    public int editUserDetails(int userId, String userName, String password, String firstName, String lastName, String gender, String phone, String email, String address) {

        Connection con = null;

        PreparedStatement ps = null;

        int rowsAffected = 0;

        try {

            con = getConnection();

            String query = " UPDATE user SET UserName=? ,password=?,FirstName=?,lastName=?,gender=?,phone=?,email=?,address=? where userId = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, userName);
            ps.setString(2,  encrypt(key, initVector, password));
            ps.setString(3, firstName);
            ps.setString(4, lastName);
            ps.setString(5, gender);
            ps.setString(6, phone);
            ps.setString(7, email);
            ps.setString(8, address);
            ps.setInt(9, userId);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {

            System.out.println("Exception occured in the editUserDetails() method: " + e.getMessage());

        } finally {

            try {

                if (ps != null) {

                    ps.close();

                }

                if (con != null) {

                    freeConnection(con);

                }

            } catch (SQLException e) {

                System.out.println("Exception occured in the finally section of the editDetailsByTitle() method");

                e.getMessage();

            }

        }

        return rowsAffected;

    }

    @Override
    public User getUserById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        try {
            con = getConnection();

            String query = "Select * from user where userId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                u = new User(rs.getInt("userId"), rs.getString("userName"), rs.getString("password"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("gender"), rs.getString("phone"), rs.getString("email"), rs.getString("address"), rs.getString("date"), rs.getBoolean("ifAdmin"), rs.getBoolean("ifVip"));
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getUserById() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getUserById() method: " + e.getMessage());
            }
        }
        return u;
    }

    public int AdminEditUser(int userId, String userName, String firstName, String lastName, String gender, String phone, String email, String address, boolean ifAdmin, boolean ifVip) {

        Connection con = null;

        PreparedStatement ps = null;

        int rowsAffected = 0;

        try {

            con = getConnection();

            String query = " UPDATE user SET UserName=? ,FirstName=?,lastName=?,gender=?,phone=?,email=?,address=?,ifAdmin=?,ifVip=? where userId = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, userName);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, gender);
            ps.setString(5, phone);
            ps.setString(6, email);
            ps.setString(7, address);
            ps.setBoolean(8, ifAdmin);
            ps.setBoolean(9, ifVip);
            ps.setInt(10, userId);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {

            System.out.println("Exception occured in the AdminEditUser() method: " + e.getMessage());

        } finally {

            try {

                if (ps != null) {

                    ps.close();

                }

                if (con != null) {

                    freeConnection(con);

                }

            } catch (SQLException e) {

                System.out.println("Exception occured in the finally section of the AdminEditUser() method");

                e.getMessage();

            }

        }

        return rowsAffected;

    }

    public List<User> getAllUsers() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList();

        try {
            con = getConnection();

            String query = "Select * from User ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User(rs.getInt("UserID"), rs.getString("UserName"), rs.getString("Password"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Gender"), rs.getString("Phone"), rs.getString("Email"), rs.getString("Address"),
                        rs.getString("Date"), rs.getBoolean("ifAdmin"), rs.getBoolean("ifVip"));
                users.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllUsers() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getAllUsers() method: " + e.getMessage());
            }
        }

        return users;
    }

    public boolean findUserByUsername(String UserName) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            con = this.getConnection();
            //check from users table
            String query = "SELECT * FROM user WHERE UserName = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, UserName);

            rs = ps.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the findUserByUsername()  method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the gfindUserByUsername()  method: " + e.getMessage());
            }
        }
        return check;
    }

    @Override
    public boolean DeleteUser(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean deleteOk = false;
        try {
            con = getConnection();
            //delete from users table
            String query = "DELETE FROM user WHERE UserId=?";

            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
            deleteOk = true;
        } catch (SQLException e) {
            System.out.println("Exception occured in the DeleteUser() method");
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
                System.out.println("Exception occured in the finally section of the DeleteUser() method");
                e.getMessage();
            }
        }
        return deleteOk;
    }
}
