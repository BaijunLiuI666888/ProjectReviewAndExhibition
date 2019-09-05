<%-- 
    Document   : viewAllUsers
    Created on : 12-Mar-2018, 13:44:21
    Author     : d00172193
--%>
<%@page import="java.util.Base64"%>
<%@page import="Daos.ProductDao"%>
<%@page import="Daos.UserDao"%>
<%@page import="Dtos.User"%>
<%@page import="java.util.List"%>
<%@page import="Dtos.Product"%>

<%@page import="Dtos.User"%>
<%@page import="java.util.ArrayList"%>
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


<!--
Navigation Bar Section 
-->
<div class="navbar">
	  <div class="navbar-inner">
		<div class="container">
		  <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		  </a>
		  <div class="nav-collapse">
			<ul class="nav">
		
                          <li class=""><a href="AdminManagement.jsp">Admin Management</a></li>
                          <li class="active"><a href="ViewUsersAll.jsp">Edit user</a></li>
			  <li class=""><a href="AdminProductDetail.jsp">Edit Product</a></li>
			  <li class=""><a href="uploadImage.jsp">Add new Product</a></li>
			  <li class=""><a href="AddCategory.jsp">Add new Category</a></li>
                          
			</ul>
			
                      
		
                    
		
		  </div>
		</div>
	  </div>
	</div>
<!-- 
        <h1>All Users</h1>
        <%
            User resultValue = (User) session.getAttribute("logginS");

            if (resultValue != null) {
                UserDao uDao = new UserDao("marketplace");
                List<User> users = uDao.getAllUsers();

        %>
        <!-- set up table structure -->

        <table class="table table-bordered table-condensed">
            <tr>
                <th></th>
                <th>UserName</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Joining Date</th>
                <th>MemberShipt Status</th>
            </tr>
            <%                // Loop to print out all of the rows
                for (User u : users) {


            %>
            <!-- Create a row for this customer -->

            <tr>
            <form action="FrontController" method="post">     
                
                <td>
                    <input type="hidden" name="uid" value="<%=u.getUserID()%>"/>
                </td>
                <td><%=u.getUserName()%></td>
                <td><%=u.getFirstName()%></td>
                <td><%=u.getLastName()%></td>
                <td><%=u.getGender()%></td>
                <td><%=u.getPhone()%></td>
                <td><%=u.getEmail()%></td>
                <td><%=u.getAddress()%></td>
                <td><%=u.getDate()%></td>
                <td><%=u.getIfVip()%></td>
                <td><a href="AdminEditUserForm.jsp?uid=<%=u.getUserID()%>" >Edit</a></td>
                <td><input type="submit" value="DeleteUser" />
                    <input type="hidden" name ="action" value="DeleteUser" /></td>
                    <input type ="hidden" name ="userId" value="<%=u.getUserID()%>" />

            </form>


        </tr>
        <%
                // Close the loop
            }
        } else {
        %>please Login first<%
            }

        %>
    </table>



</form> 
</body>
    <a href="AdminManagement.jsp">Back Management page</a>
</html>

