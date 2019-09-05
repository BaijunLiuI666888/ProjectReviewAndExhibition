/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.UserDao;
import Dtos.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Danielhua
 */
public class DeleteUserCommand implements Command{
       @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
         String forwardToJsp = "";
        
        int UserID = Integer.parseInt(request.getParameter("userId"));

         boolean success =false ;
     
     
         UserDao uDao = new UserDao("marketplace");
         HttpSession session = request.getSession();
  
         session.getAttribute("logginS");
      
        success  = uDao.DeleteUser(UserID);
        
        if (success == true) {  

           session.setAttribute("DeleteUser", UserID);
        forwardToJsp = "ViewUsersAll.jsp";
        } else {
                forwardToJsp = "deleteFailure.jsp";
    }  
         return forwardToJsp;
    }
}
