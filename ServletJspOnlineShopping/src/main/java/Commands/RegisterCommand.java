/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.Dao;
import Daos.UserDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 *
 * @author D00172193
 */
public class RegisterCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";

        String userName = request.getParameter("uName");

        String password = request.getParameter("password");
        String firstName = request.getParameter("fName");
        String lastName = request.getParameter("lName");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
         
        if ((userName != null && password != null) && (!userName.equals("") && !password.equals(""))) {

            UserDao uDao = new UserDao("marketplace");
            
     
            boolean check = uDao.findUserByUsername(userName);
            System.out.println(check); 
              if(check == false){
       HttpSession session = request.getSession();
            int u = uDao.register(userName, password, firstName, lastName, gender, phone, email, address);
            if (u > 0) {
                session.setAttribute("register", u);
                forwardToJsp = "RegisterSuccess.jsp";
            }
            else {
            forwardToJsp="RegisterFailed.jsp";
            }
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("errorMsg", "both field need to be filled/Name has been used");
            forwardToJsp = "RegisterFailed.jsp";
        }
        }
            
            
          

        return forwardToJsp;
    }
}
