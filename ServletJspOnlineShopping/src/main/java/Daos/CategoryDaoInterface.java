/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Category;
import Dtos.Product;
import java.util.List;

/**
 *
 * @author Danielhua
 */
public interface  CategoryDaoInterface {
    
    
    
    
     public int addCategory(String CategoryName, String Description);
     
      public List<Category> getAllCategory();
      public List<Product> getAllProductsByCID(int pid);
    
}
