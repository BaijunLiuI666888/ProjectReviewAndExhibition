<%-- 
    Document   : AdminEditUserForm
    Created on : 2018-3-12, 18:58:54
    Author     : LYJni
--%>

<%@page import="Dtos.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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

        <%

            int EuserId = Integer.parseInt(request.getParameter("uid"));
             User resultValue = (User) session.getAttribute("logginS");
            if (EuserId != 0) {
                // Cast it to a number

        %> 

        welcome <%="-- admin " + resultValue.getUserName() + " --"%> 

        <%

            // session.removeAttribute("logginS");
        } else {
        %>
        No user information found.
        <%
            }
        %>
        <div>




            <p>Form to edit details</p>
            <form action="FrontController" method="post">
                <table>
                    <tr>
                        <td> user name  : </td><td> <input name="uName" size=30 required="" type="text" /> </td> 
                    </tr>
                  
                    <tr>
                        <td> first name  : </td><td> <input name="fName" size=15 type="text" /> </td> 
                    </tr>
                    <tr>
                        <td> last name  : </td><td> <input name="lName" size=30 type="text" /> </td> 
                    </tr>
                    <tr>
                        <td> gender  : </td><td> <input name="gender" size=15 type="text" /> </td> 
                    </tr>

                    <tr>
                        <td> phone  : </td><td> <input name="phone" size=30 required="" type="text" /> </td> 
                    </tr>
                    <tr>
                        <td> email  : </td><td> <input name="email" size=15 type="text" /> </td> 
                    </tr>
                    <tr>
                        <td> address  : </td><td> <input name="address" size=50 type="text" /> </td> 
                    </tr>
                    <tr>
                        <td> ifAdmin  : </td><td> <input name="ifAdmin" size=50 type="text" /> </td> 
                    </tr>
                    <tr>
                        <td> ifVip  : </td><td> <input name="ifVip" size=50 type="text" /> </td> 
                    </tr>

                </table>
                <input type="hidden" name="id" value="<%=EuserId%>">
                <input type="submit" value="Change" />
                <input type="hidden" name ="action" value="AdminEditUser" />

            </form>
        </div>
    </body>
      <a href="ViewUsersAll.jsp">Back User page</a>
      
</html>
