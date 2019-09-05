/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.CartDao;
import Daos.OrderDao;
import Daos.OrderDetailDao;
import Daos.ProductDao;
import Dtos.User;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LYJni
 */
public class DeleteCartItemCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
      String forwardToJsp = "";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("logginS");
        int userId = user.getUserID();
        int pid =  Integer.parseInt(request.getParameter("pid"));

        if (userId != 0 ) {
            try {

                    CartDao oDao = new CartDao("marketplace");
                    
                    int result=oDao.deleteCartItem(pid, userId);
                    // set orderid to session
                
            
                   
                if (result > 0) {
                    forwardToJsp = "ViewMyCart.jsp";
                } else {
                    forwardToJsp = "error.jsp";

                    session.setAttribute("errorMessage", "pls login first or select an item");
                }

            } catch (IllegalArgumentException e) {
                forwardToJsp = "error.jsp";

                session.setAttribute("errorMessage", "input correction needed");
            }

        } else {

            forwardToJsp = "error.jsp";

            session.setAttribute("errorMessage", "A parameter value required for updating was missing");
        }

        return forwardToJsp;

    }
}
