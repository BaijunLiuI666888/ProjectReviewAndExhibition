/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.ProductDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Danielhua
 */
public class DeleteProductCommand implements Command{
       @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
         String forwardToJsp = "";
        
        int productID = Integer.parseInt(request.getParameter("productID"));

         boolean success =false ;
     
     
         ProductDao pDao = new ProductDao("marketplace");
         HttpSession session = request.getSession();
  
         session.getAttribute("logginS");
      
        success  = pDao.DeleteProduct(productID);
        
        if (success == true) {  

           session.setAttribute("DeleteProduct", productID);
        forwardToJsp = "AdminProductDetail.jsp";
        } else {
                forwardToJsp = "deleteFailure.jsp";
    }  
         return forwardToJsp;
    }
}
