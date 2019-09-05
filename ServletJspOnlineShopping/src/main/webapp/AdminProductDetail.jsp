<%-- 
    Document   : AdminProductDetail
    Created on : 15-Mar-2018, 01:13:47
    Author     : Danielhua
--%>

<%@page import="java.sql.Blob"%>
<%@page import="java.util.Base64"%>
<%@page import="Daos.ProductDao"%>
<%@page import="Daos.UserDao"%>
<%@page import="Dtos.User"%>
<%@page import="java.util.List"%>
<%@page import="Dtos.Product"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>

<%@page import="Dtos.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        <script>
            function myFunction() {
                alert("please login to proceed");
            }
        </script>
     <html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Asian food store</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Bootstrap styles -->
        <link href="assets/css/bootstrap.css" rel="stylesheet"/>
        <!-- Customize styles -->
        <link href="style.css" rel="stylesheet"/>
        <!-- font awesome styles -->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">

        <link rel="shortcut icon" href="assets/ico/favicon.ico">
  
    </head>
    <body>
        <!-- 
                Upper Header Section 
        -->
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="topNav">
                <div class="container">
                    <div class="alignR">

                        <a class="active" href="AdminManagement.jsp"> <span class="icon-home"></span> Home</a> 
                        <a href="EditDetails.jsp"><span class="icon-user"></span> My Account</a> 
                        <a href="Register.jsp"><span class="icon-edit"></span> Free Register </a> 
                        <a href="contact.html"><span class="icon-envelope"></span> Contact us</a>
                      

                    </div>
                </div>
            </div>
        </div>

        <!--
        Lower Header Section 
        -->
        <div class="container">
            <div id="gototop"> </div>
            <header id="header">
                <div class="row">
                    <div class="span4">
                        <h1>
                            <a class="logo" href="AdminManagement.jsp"><span>Asian food Store</span> 
                                <img src="assets/img/V3.png" alt="bootstrap shop">
                            </a>
                        </h1>
                    </div>
        <div class="span4">
	
	</div>
	<div class="span4 alignR">
	<p><br> <strong> Support (24/7) :  0877777777 </strong><br><br></p>
	  <%@include file="internationalisationHeader.jsp" %>
      
	</div>
                </div>
            </header>
      <%
            // Retrieve the resource bundle from the session
            ResourceBundle dataBundle = (ResourceBundle) session.getAttribute("dataBundle");
            // If there is no bundle stored (i.e. if this is the first time you're coming to the site)
            if(dataBundle == null){
                // Create a resource bundle based on the client's current locale settings
                dataBundle = ResourceBundle.getBundle("properties.ClassicModels", clientLocale);

                // Store this resource bundle for future use
                session.setAttribute("dataBundle", dataBundle);
            }
            
        %>
   
        <h1>All products</h1>
        <%
            int uId = 0;
            User resultValue = (User) session.getAttribute("logginS");
            if (resultValue != null) {
                uId = resultValue.getUserID();
            }
            ProductDao pDao = new ProductDao("marketplace");
            List<Product> products = pDao.getAllProducts();

        %>
        <!-- set up table structure -->

        <table class="table table-bordered table-condensed">
            <tr>
                <th></th>
                <th>Product Name</th>
                <th>Brand</th>
                <th>Stock</th>
                <th>image1</th>
                <th>Price</th>
              <%  if(resultValue!=null){
              %>
                
                <%
}%>

            </tr>
            <%                for (Product p : products) {


            %>

            <tr>
            <form action="FrontController" method="post">        
                <td>
                    <input type="hidden" name="pid" value="<%=p.getProductID()%>"/>
                </td>
                <td><a href="ProductDetails.jsp?pid=<%=p.getProductID()%>"><%=p.getpName()%></a></td>
                <td><%=p.getBrand()%></td>
                <td><%=p.getStock()%></td>
                  <td> <img src="${pageContext.servletContext.contextPath }/ShowImage?ProductID=<%=p.getProductID()%>" /></td>
                <td><%=p.getPrice()%></td>
                <%if (resultValue != null) {


                %>
              
           <td>    <input type="submit" value="DeleteProduct" />
                    <input type="hidden" name ="action" value="DeleteProduct" /></td>
                    <input type ="hidden" name ="productID" value="<%=p.getProductID()%>" />
             
                    <%                } 


                    %>


            </form>


        </tr>
        <%                // Close the loop
            }


        %>
    </table>
      </body>
     <a href="AdminManagement.jsp">Back Management page</a>
