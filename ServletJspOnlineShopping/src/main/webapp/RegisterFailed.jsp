<%-- 
    Document   : registFailed
    Created on : 2017-11-19, 22:07:23
    Author     : LYJni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  


  <head>
    <meta charset="utf-8">
    <title>Asian food Store</title>
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
				<div class="pull-left socialNw">
				
				</div>
				<a  href="index.jsp"> <span class="icon-home"></span> Home</a> 
				
				<a class="active"  href="Register.jsp"><span class="icon-edit"></span> Free Register </a> 
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
                            <a class="logo" href="index.jsp"><span>Asian food Store</span> 
                                <img src="assets/img/V3.png" alt="bootstrap shop">
                            </a>
                        </h1>
                    </div>
        <div class="span4">
	
	</div>
	<div class="span4 alignR">
	<p><br> <strong> Support (24/7) :  0877777777 </strong><br><br></p>
	
      
	</div>
                </div>
    <body>
                      <h1>Something went wrong</h1>
        <%
            // Get the error message variable out of the session
            Object msg = session.getAttribute("errorMsg");
            // Cast it to a String so we can use it
            String error = (String) msg;
            // Display the message
        %>
        
        <div> <%=error%> </div>
        <%    
            // We have finished with the results of this action
            // so now we can remove the value from the session
            session.removeAttribute("errorMsg");
            // This makes sure that old error messages 
            // don't mistakenly get printed out later
        %> 
        
    </body>
</html>
