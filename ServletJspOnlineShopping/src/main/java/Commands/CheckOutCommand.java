/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.CartDao;
import Daos.OrderDao;
import Daos.OrderDetailDao;
import Dtos.User;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LYJni
 */
// initialize a sales orderfirst with user id ;
// everytime add the cart, order detail should add as well 
// everytime add cart should get the order id first using 
public class CheckOutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String forwardToJsp = "";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("logginS");
        int userId = user.getUserID();

        if (userId != 0 ) {
            try {

                    OrderDao oDao = new OrderDao("marketplace");
                    OrderDetailDao dDao=new OrderDetailDao("marketplace");
                    // initialize a order for salesordertable
                    int iniResult = oDao.orderInitialize(userId);
                        // get orderid by userid
                    int orderID=oDao.getOrderIdByUid(userId);
                    // set orderid to session
                    session.setAttribute("orderID", orderID);
                      Map items =(Map)session.getAttribute("itemMap"); 
                    int detailResult=dDao.addDetail(items, orderID);
                if (iniResult > 0&&detailResult>0) {
                    forwardToJsp = "Checking.jsp";
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
