/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.UserDao;
import Dtos.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserEditCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        int userId = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("uName");
        String password = request.getParameter("password");
        String firstName = request.getParameter("fName");
        String lastName = request.getParameter("lName");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        if (userName != null && password != null && !userName.equals("")) {
            try {

                UserDao uDao = new UserDao("marketplace");
                int results = uDao.editUserDetails(userId, userName, password, firstName, lastName, gender, phone, email, address);

                HttpSession session = request.getSession();

                session.setAttribute("userUpdated", results);

                if (results > 0) {

                    User u = uDao.getUserById(userId);
                    session.setAttribute("editS", u);

                }
                  forwardToJsp = "UpdateSuccess.jsp";
            } catch (IllegalArgumentException e) {
                forwardToJsp = "error.jsp";

                HttpSession session = request.getSession();

                session.setAttribute("errorMessage", "correct input required");
            }
        } else {

            forwardToJsp = "error.jsp";

            HttpSession session = request.getSession();

            session.setAttribute("errorMessage", "A parameter value required for updating was missing");
        }
        return forwardToJsp;
    }

}
