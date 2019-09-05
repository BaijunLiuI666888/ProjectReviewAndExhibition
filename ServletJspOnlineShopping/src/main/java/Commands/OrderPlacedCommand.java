/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.CartDao;
import Daos.OrderDao;
import Daos.ProductDao;
import Dtos.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LYJni
 */
public class OrderPlacedCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();

        CartDao cDao = new CartDao("marketplace");
        OrderDao oDao=new OrderDao("marketplace");
        User user = (User) session.getAttribute("logginS");
        Double price = (Double) session.getAttribute("price");
        int userId = user.getUserID();
        Integer orderid = (Integer) session.getAttribute("orderID");
        if (user != null) {
            try {
                int presult =oDao.confirmOrderPriceDate(price,orderid);
                int result = cDao.EmptyCart(userId);

                if (result > 0&&presult>0) {
                    forwardToJsp = "OrderPlaced.jsp";
                    session.removeAttribute("orderID");
                } else {
                    forwardToJsp = "error.jsp";

                    session.setAttribute("errorMessage", "failed to place an orde pls try again");
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
