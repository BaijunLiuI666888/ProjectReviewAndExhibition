/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.WishlistDao;
import Dtos.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LYJni
 */
public class AddWishlistCommand  implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String forwardToJsp = "";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("logginS");
        int userId = user.getUserID();
        int productId = Integer.parseInt(request.getParameter("pid"));
        if (userId != 0 && productId != 0 ) {
            try {

                  WishlistDao wDao=new WishlistDao("marketplace");
                   int result = wDao.addToWishlist(userId, productId);
                if (result > 0) {
                    forwardToJsp = "LogedVCP.jsp";

                } else {
                    forwardToJsp = "error.jsp";

                    session.setAttribute("errorMessage", "insert failed,vs");
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
