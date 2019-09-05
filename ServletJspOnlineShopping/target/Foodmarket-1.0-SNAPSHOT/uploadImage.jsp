<%-- 
    Document   : uploadImage
    Created on : 13-Mar-2018, 12:50:56
    Author     : Danielhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

                        <a class="active" href="LogginSuccessful.jsp"> <span class="icon-home"></span> Home</a> 
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
                            <a class="logo" href="LogginSuccessful.jsp"><span>Asian food Store</span> 
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
		
                          <li class="active"><a href="AdminManagement.jsp">Admin Management</a></li>
                          <li class=""><a href="ViewUsersAll.jsp">Edit user</a></li>
			  <li class=""><a href="AdminProductDetail.jsp">Edit Product</a></li>
			  <li class=""><a href="uploadImage.jsp">Add new Product</a></li>
			  <li class=""><a href="AddCategory.jsp">Add new Category</a></li>
                          
			</ul>
			
                      
		
                    
		
		  </div>
		</div>
	  </div>
	</div>
    <h1>Add Product</h1>
    <form method="post" action="fileUpload"
        enctype="multipart/form-data">
        <table>
            <tr>
                <td>Category ID:</td>
              <tr> <select name="CategoryID" size="1" id="pQuantity">
                    <option value="1" selected>Drinks</option>
                    <option value="2">SeaFood</option>
                    <option value="3">Fresh Meat</option>
                    <option value="4">RICE&FLOUR&NOODLES</option>
                    <option value="5">Vegetables</option>
                    <option value="6">Sauce</option>
                    <option value="7">Snacks</option>
                </select>
                </tr>
            </tr>
            <tr>
                <td>Product Name:</td>
                <td><input type="text" name="pName" size="10"
                    required="required" /></td>
            </tr>
            <tr>
                <td>Brand:</td>
                <td><input type="text" name="brand" size="10"
                    required="required" /></td>
            </tr>
            <tr>
                <td>Weight:</td>
                <td><input id="number" type="number" name="Weight" size="10"
                    required="required" /></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><input type="text" name="description" size="10"
                    required="required" /></td>
            </tr>
             <tr>
                <td>Stock:</td>
                <td><input id="number" type="number" name="Stock" size="10"
                    required="required" /></td>
            </tr>
             <tr>
                <td>Date:</td>
                <td><input id="date" type="date" name="foodDate" size="10"
                    required="required" /></td>
            </tr>
              <tr>
                <td>price:</td>
                <td><input id="number" type="number" name="price" size="10"
                    required="required" /></td>
            </tr>
            
            
            <tr>
                <td>Choose Image1:</td>
                <td><input type="file" name="image1" size="10"
                    required="required" /></td>
            </tr>
              <tr>
                <td>Choose Image2:</td>
                <td><input type="file" name="image2" size="10"
                    required="required" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"></td>
                <td><input type="reset" value="Clear" /></td>
            </tr>
        </table>
    </form>
</body>
</html>