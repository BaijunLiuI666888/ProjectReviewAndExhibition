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
 * @author D00172193
 */
public class LogginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if ((userName != null && password != null) && (!userName.equals("") && !password.equals(""))) {
            UserDao uDao = new UserDao("marketplace");
            HttpSession session = request.getSession();
            User u = uDao.checkLogin(userName, password);

            if (u == null) {

                session.setAttribute("errorMsg", "wrong userName/password  Please try again ");
                forwardToJsp = "LogginFailed.jsp";
            } else {
                session.setAttribute("logginS", u);
                if (u.getIfAdmin() == true) {
                    forwardToJsp = "AdminManagement.jsp";
                } else {

                    forwardToJsp = "LogginSuccessful.jsp";
                session.setAttribute("userInfo", u);
                }

            }

        } else if (userName == null || password == null) {
            HttpSession session = request.getSession();

            session.setAttribute("errorMsg", "No username or password information contained in request.");
            forwardToJsp = "LogginFailed.jsp";
        } else {

            HttpSession session = request.getSession();
            session.setAttribute("errorMsg", "Blank username and password supplied.");
            forwardToJsp = "LogginFailed.jsp";

        }
        return forwardToJsp;
    }
}
