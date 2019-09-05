<%-- 
    Document   : loggin
    Created on : 2017-11-19, 16:47:16
    Author     : LYJni
--%>

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
   
    <body id="top">
        <!-- 
                Upper Header Section 
        -->
        <div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = 'https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.0&appId=419377088534148&autoLogAppEvents=1';
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="topNav">
                <div class="container">
                    <div class="alignR">

                        <a class="" href="index.html"> <span class="icon-home"></span> Home</a> 
                        <a href="#"><span class="icon-user"></span> My Account</a> 
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
                                <li class=""><a href="index.jsp"><%=dataBundle.getString("index_home")%></a></li>
                                <li class=""><a href="ViewProductAll.jsp"><%=dataBundle.getString("index_product")%></a></li>
                             
                      <li class="active"><a href="Loggin.jsp"><%=dataBundle.getString("index_Login")%></a></li>
                            </ul>
                      </div>
                    </div>
                </div>
            </div>
<!-- 
Body Section 
-->
	<div class="row">



	<div class="span9">
    <ul class="breadcrumb">
		<li><a href="index.jsp"><%=dataBundle.getString("index_home")%></a> <span class="divider">/</span></li>
		<li class="active"><%=dataBundle.getString("index_Login")%></li>
    </ul>
	<h3> <%=dataBundle.getString("custLogin_Title")%></h3>	
   <hr class="soft"/>
   <div class="row">

		
		
   
        <div class="span1"> &nbsp;</div>
		<div class="span4">
			<div class="well">


    


         
            <form action="FrontController" method="post">
                  <div class="control-group">
                        <label class="control-label" for="userName"><%=dataBundle.getString("custLogin_Name")%></label>
                    <div class="controls">
				  <input name="userName" class="span3"  type="text" placeholder="userName">
				</div>
                        </div>
                     <div class="control-group">
                        <label class="control-label" for="password"><%=dataBundle.getString("custLogin_Pass")%></label>
                      <div class="controls">
                         <input type="password" name="password" class="span3" size=30 type="text" placeholder="Password"/> </td> 
                      </div>
                 </div>
                  <div class="control-group">
				<div class="controls">
                                    <button type="submit" class="defaultBtn" /><%=dataBundle.getString("custLogin_Button")%></button>
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="loggin" />
                </div>
                  </div>
            </form>
                      
        </div>
                </div>
        </div>
        </div>
        </div>
<footer class="footer">
<div class="row-fluid">
<div class="span2">
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
<h5>Welcome Asian supermarkets</h5>
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
</html>

