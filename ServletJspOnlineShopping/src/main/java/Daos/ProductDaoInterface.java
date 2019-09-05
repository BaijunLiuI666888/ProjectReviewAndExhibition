/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.CategoryProduct;
import Dtos.Product;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Danielhua
 */
public interface ProductDaoInterface {
    
    public int newProduct(String ProdcutName ,String Brand ,double Weight ,String Description  ,int Stock, String Date,byte[] image1,byte[] image2 ,double price );
    public List<Product> getAllProducts();
      public List<CategoryProduct> getFullProductInfoByPid(int pid);
      
      public boolean DeleteProduct (int id);
       public List<CategoryProduct> getFullProductInfoByPName(String pName);
}
