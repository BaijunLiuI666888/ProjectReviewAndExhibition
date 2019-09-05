/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.CategoryDao;
import Daos.UserDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Danielhua
 */
public class AddCategoryCommand implements Command{
     public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        
        String CategoryName = request.getParameter("cName");
        String Description = request.getParameter("Description");
        
        
           if ((CategoryName != null && Description != null) && (!CategoryName.equals("") && !Description.equals(""))) {
           
            CategoryDao cDao = new CategoryDao("marketplace");
            HttpSession session = request.getSession();
            // get result if updated
            int c = cDao.addCategory(CategoryName, Description);

            session.setAttribute("Category", c);
            forwardToJsp = " AddCategorySucc.jsp";
        } else {
            HttpSession session = request.getSession();
            // if field is blank
            session.setAttribute("errorMsg", "both field need to be filled");
         
        }

        return forwardToJsp;
    }
        
        
        
}
