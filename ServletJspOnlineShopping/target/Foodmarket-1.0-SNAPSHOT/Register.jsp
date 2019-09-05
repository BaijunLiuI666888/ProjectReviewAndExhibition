<%-- 
    Document   : RegisterPage
    Created on : 14-Dec-2017, 16:04:51
    Author     : D00162121
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

   <html lang="en">
            <script src='https://www.google.com/recaptcha/api.js'></script>
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
			  <li class=""><a href="index.jsp"><%=dataBundle.getString("index_home")%>	</a></li>
			  <li class=""><a href="ViewProductAll.jsp"><%=dataBundle.getString("index_product")%></a></li>
		
			</ul>
			
                      
		
                    
			
		  </div>
		</div>
	  </div>
	</div>
<!-- 
Body Section 
-->
	<div class="row">
                <ul class="breadcrumb">
		<li><a href="index.jsp"><%=dataBundle.getString("index_home")%></a> <span class="divider">/</span></li>
		<li class="active"><%=dataBundle.getString("CutReg_Title")%></li>
    </ul>
            <h3>Register </h3>
            <hr class="soft"/>
	<div class="well">
          
        <form action="FrontController" method="post"class="form-horizontal">
         
            <h3><%=dataBundle.getString("cutReg_formTitle")%></h3>
              <div class="control-group">
			<label class="control-label" for="uName"><%=dataBundle.getString("CutReg_Uname")%><sup>*</sup></label>
			<div class="controls">
			  <input type="text" id="uName" name="uName" placeholder="Username">
			</div>
		 </div>
              <div class="control-group">
			<label class="control-label" for="password"><%=dataBundle.getString("CutReg_Pass")%><sup>*</sup></label>
			<div class="controls">
			  <input  id="password" name="password" type="password" placeholder="Password">
			</div>
		 </div>
            	<div class="control-group">
			<label class="control-label" for="inputFname"><%=dataBundle.getString("CutReg_Fname")%><sup>*</sup></label>
			<div class="controls">
			  <input type="text"name="fName" id="fName" placeholder="First Name">
			</div>
		 </div>
            	<div class="control-group">
			<label class="control-label" for="inputlname"><%=dataBundle.getString("CutReg_Lname")%><sup>*</sup></label>
			<div class="controls">
			  <input type="text" name="lName" id="lName" placeholder="last Name">
			</div>
		 </div>
                	<div class="control-group">
			<label class="control-label" for="inputGender"><%=dataBundle.getString("CutReg_Gender")%><sup>*</sup></label>
			<div class="controls">
			  <input type="text"name="gender" id="gender" placeholder="gender">
			</div>
		 </div>
               <div class="control-group">
			<label class="control-label" for="inputPhone"><%=dataBundle.getString("CutReg_Phone")%><sup>*</sup></label>
			<div class="controls">
			  <input type="text"name="phone" id="phone" placeholder="phone"     >
			</div>
		 </div>
            	<div class="control-group">
		<label class="control-label" for="inputEmail"><%=dataBundle.getString("CutReg_email")%><sup>*</sup></label>
		<div class="controls">
		  <input type="email" name="email" placeholder="Email">
		</div>
	  </div>
               	<div class="control-group">
		<label class="control-label" for="inputAddress"><%=dataBundle.getString("CutReg_Address")%> <sup>*</sup></label>
		<div class="controls">
		  <input type="text" name="address" placeholder="address">
		</div>
	  </div>
             <div class="control-group">
		<div class="controls">
           <div class="g-recaptcha" data-sitekey="6Lco1VYUAAAAAPqeXEXmqsW4ev1fURaXL37QPtKp"></div>
            <input type="submit" value="<%=dataBundle.getString("CutReg_Button")%>" />
         
            <input type="hidden" name ="action" value="register" />
                  
        </div>
            </div>
                   
        </form>
                 
</div><footer class="footer">
<div class="row-fluid">
<div class="span2">
<h5>Your Account</h5>
<a href="#">YOUR ACCOUNT</a><br>
<a href="#">ORDER HISTORY</a><br>
 </div>
<div class="span2">
<h5>Information</h5>
<a href="contact.html">CONTACT</a><br>
<a href="#">ABOUT US</a><br>
 </div>

 <div class="span6">
                  <h5>The standard chunk of Lorem</h5>
          <div class="fb-page" data-href="https://www.facebook.com/facebook" data-tabs="timeline" data-height="70" data-small-header="false" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="false"><blockquote cite="https://www.facebook.com/facebook" class="fb-xfbml-parse-ignore"><a href="https://www.facebook.com/facebook">Facebook</a></blockquote></div>
 </div>
 </div>
</footer>
</div><!-- /container -->

<div class="copyright">
<div class="container">

	
	<span>Copyright &copy; 2018<br> FOOD MARKET</span>
</div>
</div>
<a href="#top" class="gotop"><i class="icon-double-angle-up"></i></a>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.easing-1.3.min.js"></script>
    <script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
    <script src="assets/js/shop.js"></script>
  </body>
