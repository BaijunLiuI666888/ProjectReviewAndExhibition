/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Danielhua
 */
public class NoValidActionCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String forwardToJsp = "error.jsp";
    
        HttpSession session = request.getSession();
   //deal with wrong session name or wrong action name 
        session.setAttribute("errorMessage", "No valid action was supplied");
        return forwardToJsp;
    }

}