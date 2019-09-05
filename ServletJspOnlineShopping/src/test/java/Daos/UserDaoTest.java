/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Daos;
//
//import Dtos.User;
//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Danielhua
// */
//public class UserDaoTest {
//    
//    public UserDaoTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of encrypt method, of class UserDao.
//     */
//    @Test
//    public void testEncrypt() {
//        System.out.println("encrypt");
//        String key = "";
//        String initVector = "";
//        String value = "";
//        String expResult = "";
//        String result = UserDao.encrypt(key, initVector, value);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of decrypt method, of class UserDao.
//     */
//    @Test
//    public void testDecrypt() {
//        System.out.println("decrypt");
//        String key = "";
//        String initVector = "";
//        String encrypted = "";
//        String expResult = "";
//        String result = UserDao.decrypt(key, initVector, encrypted);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of register method, of class UserDao.
//     */
//    @Test
//    public void testRegister() {
//        System.out.println("register");
//        String userName = "Dan";
//        String password = "1234";
//        String firstName = "D";
//        String lastName = "A";
//        String gender = "M";
//        String phone = "1231231";
//        String email = "lzsh@qq.com";
//        String address = "wadaw";
//        UserDao instance =  new UserDao("marketplace");
//        int expResult = 1;
//        int result = instance.register(userName, password, firstName, lastName, gender, phone, email, address);
//        assertEquals(expResult, result);
//      
//    }
//
//    /**
//     * Test of checkLogin method, of class UserDao.
//     */
//    @Test
//    public void testCheckLogin() {
//        System.out.println("checkLogin");
//        String uname = "xx";
//        String pword = "xx";
//        UserDao instance = new UserDao("marketplace");
//        User expResult = null;
//        User result = instance.checkLogin(uname, pword);
//        assertEquals(expResult, result);
//       
//    }
//
//    /**
//     * Test of editUserDetails method, of class UserDao.
//     */
//    @Test
//    public void testEditUserDetails() {
//        System.out.println("editUserDetails");
//        int userId = 31;
//        String userName = "yy";
//        String password = "yy";
//        String firstName = "yy";
//        String lastName = "yy";
//        String gender = "yy";
//        String phone = "yy";
//        String email = "yy";
//        String address = "yy";
//       UserDao instance =  new UserDao("marketplace");
//        int expResult = 1;
//        int result = instance.editUserDetails(userId, userName, password, firstName, lastName, gender, phone, email, address);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of getUserById method, of class UserDao.
//     */
//    @Test
//    public void testGetUserById() {
//        System.out.println("getUserById");
//        int id = 30;
//       UserDao instance =  new UserDao("marketplace");
//        User expResult = new User(30,"vvv","vvv","vvv","vvv","vvv","vvv","vvv","vvv","2018-05-02",false,false);
//        User result = instance.getUserById(id);
//        assertEquals(expResult, result);
//  
//    }
//
//    /**
//     * Test of AdminEditUser method, of class UserDao.
//     */
//    @Test
//    public void testAdminEditUser() {
//        System.out.println("AdminEditUser");
//        int userId = 24;
//        String userName = "oo";
//        String firstName = "oo";
//        String lastName = "oo";
//        String gender = "oo";
//        String phone = "oo";
//        String email = "oo";
//        String address = "00";
//        boolean ifAdmin = false;
//        boolean ifVip = false;
//        UserDao instance = new UserDao("marketplace");
//        int expResult = 1;
//        int result = instance.AdminEditUser(userId, userName, firstName, lastName, gender, phone, email, address, ifAdmin, ifVip);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of getAllUsers method, of class UserDao.
//     */
//    @Test
//    public void testGetAllUsers() {
//        System.out.println("getAllUsers");
//        UserDao instance = null;
//        List<User> expResult = null;
//        List<User> result = instance.getAllUsers();
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of findUserByUsername method, of class UserDao.
//     */
//    @Test
//    public void testFindUserByUsername() {
//        System.out.println("findUserByUsername");
//        String UserName = "";
//        UserDao instance = null;
//        boolean expResult = false;
//        boolean result = instance.findUserByUsername(UserName);
//        assertEquals(expResult, result);
//     
//    }
//
//    /**
//     * Test of DeleteUser method, of class UserDao.
//     */
//    @Test
//    public void testDeleteUser() {
//        System.out.println("DeleteUser");
//        int id = 22;
//        UserDao instance = null;
//        boolean expResult = false;
//        boolean result = instance.DeleteUser(id);
//        assertEquals(expResult, result);
//  
//    }
//    
//}
