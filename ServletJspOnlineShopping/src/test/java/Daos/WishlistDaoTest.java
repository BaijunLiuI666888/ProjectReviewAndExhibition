/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Daos;
//
//import Dtos.WishProduct;
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
//public class WishlistDaoTest {
//    
//    public WishlistDaoTest() {
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
//     * Test of addToWishlist method, of class WishlistDao.
//     */
//    @Test
//    public void testAddToWishlist() {
//        System.out.println("addToWishlist");
//        int uid = 9;
//        int pid = 20;
//        WishlistDao instance = new WishlistDao("marketplace");
//        int expResult = 0;
//        int result = instance.addToWishlist(uid, pid);
//        assertEquals(expResult, result);
//     
//    }
//
//    /**
//     * Test of getWishlistProductByUserId method, of class WishlistDao.
//     */
//    @Test
//    public void testGetWishlistProductByUserId() {
//        System.out.println("getWishlistProductByUserId");
//        int id = 5;
//        WishlistDao instance = new WishlistDao("marketplace");
//        List<WishProduct> expResult = null;
//        List<WishProduct> result = instance.getWishlistProductByUserId(id);
//        assertEquals(expResult, result);
//     
//    }
//    
//}
