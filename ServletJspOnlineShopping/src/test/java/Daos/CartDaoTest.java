///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Daos;
//
//import Dtos.CartProduct;
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
//public class CartDaoTest {
//    
//    public CartDaoTest() {
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
//     * Test of addToCart method, of class CartDao.
//     */
//    @Test
//    public void testAddToCart() {
//        System.out.println("addToCart");
//        int userId = 19;
//        int productId = 9;
//        int quantity = 2;
//        CartDao instance = new CartDao("marketplace");
//        int expResult = 1;
//        int result = instance.addToCart(userId, productId, quantity);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of AllInCartByUserId method, of class CartDao.
//     */
//    @Test
//    public void testAllInCartByUserId() {
//        System.out.println("AllInCartByUserId");
//        int id = 5;
//        CartDao instance = new CartDao("marketplace");
//        List<CartProduct> expResult = null;
//        List<CartProduct> result = instance.AllInCartByUserId(id);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of EmptyCart method, of class CartDao.
//     */
//    @Test
//    public void testEmptyCart() {
//        System.out.println("EmptyCart");
//        int id = 3;
//        CartDao instance = new CartDao("marketplace");
//        int expResult = 1;
//        int result = instance.EmptyCart(id);
//        assertEquals(expResult, result);
// 
//    }
//
//    /**
//     * Test of deleteCartItem method, of class CartDao.
//     */
//    @Test
//    public void testDeleteCartItem() {
//        System.out.println("deleteCartItem");
//        int productId = 7;
//        int userId = 1;
//        CartDao instance = new CartDao("marketplace");
//        int expResult = 1;
//        int result = instance.deleteCartItem(productId, userId);
//        assertEquals(expResult, result);
//     
//    }
//    
//}
