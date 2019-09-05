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
public class AdminUserEditCommand implements Command{
     public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        int userId = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("uName");
         String firstName = request.getParameter("fName");
        String lastName = request.getParameter("lName");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        boolean ifAdmin = Boolean.parseBoolean(request.getParameter("ifAdmin"));
        boolean ifVip = Boolean.parseBoolean(request.getParameter("ifVip"));

        if (userName != null  && !userName.equals("")&&firstName!=null&&firstName!=null&&lastName!=null&&gender!=null&&phone!=null&&email!=null&&address!=null) {
            try {

                UserDao uDao = new UserDao("marketplace");
                int results = uDao.AdminEditUser(userId, userName, firstName, lastName, gender, phone, email, address,ifAdmin,ifVip);

                HttpSession session = request.getSession();

                session.setAttribute("userUpdated", results);

                if (results > 0) {

                    User u = uDao.getUserById(userId);
                    session.setAttribute("editS", u);
                    forwardToJsp = "ProfileEditSuccess.jsp";
                    
                }else {
                forwardToJsp="error.jsp";
                session.setAttribute("errorMsg", "update error Dao");
                
                }
                
            } catch (IllegalArgumentException e) {
                forwardToJsp = "error.jsp";

                HttpSession session = request.getSession();

                session.setAttribute("errorMsg", "correct input required");
            }
        } else {

            forwardToJsp = "error.jsp";

            HttpSession session = request.getSession();

            session.setAttribute("errorMsg", "A parameter value required for updating was missing");
        }
        return forwardToJsp;
    }

}
