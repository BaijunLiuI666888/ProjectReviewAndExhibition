/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Danielhua
 */
@WebServlet(name = "ShowImage", urlPatterns = {"/ShowImage"})
public class ShowImage extends HttpServlet {

 
 private static final int BUFFER_SIZE = 4096;
    // database connection settings
    private String url =  "jdbc:mysql://localhost:3306/marketplace";
    private String username  = "root";
    private String password = "";

    //naive way to obtain a connection to database
    //this MUST be improved, shown for 
    private Connection getConnection() {
        Connection con = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
        
            throw new RuntimeException("Failed to obtain database connection.", e);
        }
        return con;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        Connection conn = null;


     try{
            conn = getConnection();

        PreparedStatement stmt = conn.prepareStatement("select image1 from product where ProductID=?");
        stmt.setLong(1, Long.valueOf(request.getParameter("ProductID")));
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            response.getOutputStream().write(rs.getBytes("image1"));
        }
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
 

}
