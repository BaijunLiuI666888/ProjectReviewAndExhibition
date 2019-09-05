 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;


/**
 *
 * @author Danielhua
 */






import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



@WebServlet("/fileUpload")
@MultipartConfig(maxFileSize = 16177215) // upload file up to 16MB
public class UploadServlet extends HttpServlet {

    private static final int BUFFER_SIZE = 4096;

    private String url =  "jdbc:mysql://localhost:3306/marketplace";
    private String username  = "root";
    private String password = "";

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

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        

        int CategoryID = Integer.parseInt(request.getParameter("CategoryID"));
        String ProductName = request.getParameter("pName");
        String Brand = request.getParameter("brand");
        double Weight = Double.parseDouble(request.getParameter("Weight"));
       String Description = request.getParameter("description");
        int Stock = Integer.parseInt(request.getParameter("Stock"));
        String  Date= request.getParameter("foodDate");
        SimpleDateFormat foodDate = new SimpleDateFormat("yyyy-MM-dd");
        double price = Double.parseDouble(request.getParameter("price"));
        InputStream inputStream = null;
        InputStream image2= null;
   
        Part filePart = request.getPart("image1");
        Part filePart2 = request.getPart("image2");
        if (filePart != null) {
         
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

       
            inputStream = filePart.getInputStream();
        }
         if (filePart2 != null) {
         
            System.out.println(filePart2.getName());
            System.out.println(filePart2.getSize());
            System.out.println(filePart2.getContentType());

       
            image2 = filePart2.getInputStream();
        }
        Connection conn = null;
        String message = null;

        try {
            conn = getConnection();
      
            String sql =" insert into product (CategoryID,ProductName,Brand,Weight, Description, Stock, Date,image1, image2,price)"
                    +" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,CategoryID);
            statement.setString(2,ProductName);
            statement.setString(3,Brand);
            statement.setDouble(4, Weight);
            statement.setString(5,Description );
            statement.setInt(6, Stock);
            statement.setString(7, Date);
          
        
          
         

            if (inputStream != null) {
               
                statement.setBlob(8, inputStream);
                statement.setBlob(9, image2);
                
            }
            
             statement.setDouble(10, price);
        
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "Image is uploaded successfully into the Database";
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        }
        
        request.setAttribute("Message", message);

   
        getServletContext().getRequestDispatcher("/submit.jsp").forward(
                request, response);
    }
    
}

