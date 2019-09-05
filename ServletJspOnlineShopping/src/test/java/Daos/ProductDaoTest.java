/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Daos;
//
//import Dtos.CategoryProduct;
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
//public class ProductDaoTest {
//    
//    public ProductDaoTest() {
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
//     * Test of newProduct method, of class ProductDao.
//     */
//    @Test
//    public void testNewProduct() {
//        System.out.println("newProduct");
//        String ProdcutName = "";
//        String Brand = "";
//        double Weight = 0.0;
//        String Description = "";
//        int Stock = 0;
//        String Date = "";
//        byte[] image1 = null;
//        byte[] image2 = null;
//        double price = 0.0;
//        ProductDao instance = null;
//        int expResult = 0;
//        int result = instance.newProduct(ProdcutName, Brand, Weight, Description, Stock, Date, image1, image2, price);
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of getAllProducts method, of class ProductDao.
//     */
//    @Test
//    public void testGetAllProducts() {
//        System.out.println("getAllProducts");
//        ProductDao instance = null;
//        List<Product> expResult = null;
//        List<Product> result = instance.getAllProducts();
//        assertEquals(expResult, result);
//
//    }
//
//    /**
//     * Test of getFullProductInfoByPid method, of class ProductDao.
//     */
//    @Test
//    public void testGetFullProductInfoByPid() {
//        System.out.println("getFullProductInfoByPid");
//        int pid = 0;
//        ProductDao instance = null;
//        List<CategoryProduct> expResult = null;
//        List<CategoryProduct> result = instance.getFullProductInfoByPid(pid);
//        assertEquals(expResult, result);
//       
//    }
//
//    /**
//     * Test of DeleteProduct method, of class ProductDao.
//     */
//    @Test
//    public void testDeleteProduct() {
//        System.out.println("DeleteProduct");
//        int id = 0;
//        ProductDao instance = null;
//        boolean expResult = false;
//        boolean result = instance.DeleteProduct(id);
//        assertEquals(expResult, result);
//     
//    }
//
//    /**
//     * Test of getFullProductInfoByPName method, of class ProductDao.
//     */
//    @Test
//    public void testGetFullProductInfoByPName() {
//        System.out.println("getFullProductInfoByPName");
//        String pName = "";
//        ProductDao instance = null;
//        List<CategoryProduct> expResult = null;
//        List<CategoryProduct> result = instance.getFullProductInfoByPName(pName);
//        assertEquals(expResult, result);
//  
//    }
//
//    /**
//     * Test of getCountPage method, of class ProductDao.
//     */
//    @Test
//    public void testGetCountPage() {
//        System.out.println("getCountPage");
//        ProductDao instance = null;
//        int expResult = 0;
//        int result = instance.getCountPage();
//        assertEquals(expResult, result);
//   
//    }
//
//    /**
//     * Test of getProduct method, of class ProductDao.
//     */
//    @Test
//    public void testGetProduct() throws Exception {
//        System.out.println("getProduct");
//        int currentPage = 0;
//        ProductDao instance = null;
//        List<Product> expResult = null;
//        List<Product> result = instance.getProduct(currentPage);
//        assertEquals(expResult, result);
//   
//    }
//    
//}
