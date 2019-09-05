///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Daos;
//
//import Dtos.Category;
//import Dtos.Product;
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
//public class CategoryDaoTest {
//    
//    public CategoryDaoTest() {
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
//     * Test of addCategory method, of class CategoryDao.
//     */
//    @Test
//    public void testAddCategory() {
//        System.out.println("addCategory");
//        String CategoryName = "aa";
//        String Description = "aa";
//        CategoryDao instance = new CategoryDao("marketplace");
//        int expResult = 1;
//        int result = instance.addCategory(CategoryName, Description);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of getAllCategory method, of class CategoryDao.
//     */
//    @Test
//    public void testGetAllCategory() {
//        System.out.println("getAllCategory");
//        CategoryDao instance = new CategoryDao("marketplace");
//        List<Category> expResult = null;
//        List<Category> result = instance.getAllCategory();
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of getAllProductsByCID method, of class CategoryDao.
//     */
//    @Test
//    public void testGetAllProductsByCID() {
//        System.out.println("getAllProductsByCID");
//        int pid = 2;
//        CategoryDao instance = new CategoryDao("marketplace");
//        List<Product> expResult = null;
//        List<Product> result = instance.getAllProductsByCID(pid);
//        assertEquals(expResult, result);
//
//    }
//    
//}
