<%-- 
    Document   : image
    Created on : 2018-3-14, 12:44:29
    Author     : LYJni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@page import="java.sql.Blob"%>
        <%@page import="java.util.Base64"%>
        <%@page import="Daos.ProductDao"%>
        <%@page import="Daos.UserDao"%>
        <%@page import="Dtos.User"%>
        <%@page import="java.util.List"%>
        <%@page import="Dtos.Product"%>
        <%@page import="java.io.*"%>
        <%@page import="java.sql.*"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        666
        <%
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/marketplace";
            String username = "root";
            String password = "";
            Connection con = null;
            OutputStream img;

            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            if (con != null) {
                ResultSet rs = null;
                PreparedStatement ps = null;
                

                ps = con.prepareStatement("select image1 from product where productID=1");
                rs = ps.executeQuery();
                if (rs.next()) {
                    byte barray[] = rs.getBytes(1);
                    response.setContentType("image/png");
                    
                    %>
                    image1
                    <%
                    img = response.getOutputStream();
                    img.write(barray);

                    img.flush();
                    img.close();
                    

                } else {
        %>
        null rs
        <%
                        }

        } else {

        %>
        null con
        <%            }


        %>
    </body>
</html>
