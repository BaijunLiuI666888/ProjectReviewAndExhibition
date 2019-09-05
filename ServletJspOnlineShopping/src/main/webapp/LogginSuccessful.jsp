<%-- 
    Document   : logginSuccessful
    Created on : 2017-11-19, 17:41:07
    Author     : LYJni
--%>

<%@page import="Dtos.User"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <%
           
            User resultValue =(User)session.getAttribute("logginS"); 
            
            if (resultValue != null)
            {
               
                
        %> 
 <script>
            var request;
            function sendInfo()
            {
                var v = document.vinform.t1.value;
                var url = "AjaxProcess.jsp?val=" + v;

                if (window.XMLHttpRequest) {
                    request = new XMLHttpRequest();
                } else if (window.ActiveXObject) {
                    request = new ActiveXObject("Microsoft.XMLHTTP");
                }

                try {
                    request.onreadystatechange = getInfo;
                    request.open("GET", url, true);
                    request.send();
                } catch (e) {
                    alert("Unable to connect to server");
                }
            }

            function getInfo() {
                if (request.readyState === 4) {
                    var val = request.responseText;
                    document.getElementById('amit').innerHTML = val;
                }
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
			  <li class="active"><a href="LogginSuccessful.jsp"><%=dataBundle.getString("2bar_home")%></a></li>
			  <li class=""><a href="LogedVCP.jsp"><%=dataBundle.getString("2bar_products")%></a></li>
                          <li class=""><a href="ViewMyCart.jsp"><%=dataBundle.getString("2bar_mycart")%></a></li>
                           <li class=""><a href="ViewMyOrders.jsp"><%=dataBundle.getString("2bar_myorder")%></a></li>
                             <li class=""><a href="ViewWishlist.jsp"><%=dataBundle.getString("2bar_wishlist")%></a></li>
                  <form name="vinform" action="SearchResult.jsp" method ="post" class="navbar-search pull-left">
                                <input type="text" name="t1" onkeyup="sendInfo()" placeholder="Search a product..." class="search-query span2">
                                <span id="amit"> </span>
                 </form>
                             
                               <li class=""><a> <%=dataBundle.getString("2bar_welcom")%> <%=resultValue.getUserName()%></a></li>
                               <li class=""><a href="logout.jsp"><%=dataBundle.getString("2bar_logout")%></a></li>
			</ul>
			
                      
		
                    
			
		  </div>
		</div>
	  </div>
	</div>

      
       
      <div class="row">
                <div id="sidebar" class="span3">
                    <div class="well well-small">
                        <ul class="nav nav-list">
                             <p><%=dataBundle.getString("categorybar_title")%></p>

                            <li><a href="LogedCategoryProducts.jsp?pid=1"><span class="icon-chevron-right"><%=dataBundle.getString("categorybar_drinks")%></span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=2"><span class="icon-chevron-right"><%=dataBundle.getString("categorybar_sf")%></span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=3"><span class="icon-chevron-right"> <%=dataBundle.getString("categorybar_freshmeat")%></span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=5"><span class="icon-chevron-right"><%=dataBundle.getString("categorybar_ingredients")%></span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=6"><span class="icon-chevron-right"><%=dataBundle.getString("categorybar_vegetables")%></span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=4"><span class="icon-chevron-right"><%=dataBundle.getString("categorybar_riceflournoodle")%></span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=7"><span class="icon-chevron-right"><%=dataBundle.getString("categorybar_others")%></span></a></li>
                        </ul>
                    </div>
<ul class="nav nav-list promowrapper">
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="ProductDetails.jsp?pid=17" ><span class="icon-search"></span> QUICK VIEW</a>
				<img src="assets/img/n.png" alt="bootstrap ecommerce templates">
				
			  </div>
			</li>
			<li style="border:0"> &nbsp;</li>
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="ProductDetails.jsp?pid=23"><span class="icon-search"></span> QUICK VIEW</a>
				<img src="assets/img/8801047119470_800x800 (1).jpg" alt="shopping cart template">
				
			  </div>
			</li>
			<li style="border:0"> &nbsp;</li>
			<li>
			  <div class="thumbnail">
				<a class="zoomTool"href="ProductDetails.jsp?pid=13"><span class="icon-search"></span> QUICK VIEW</a>
				<img src="assets/img/kang.png" alt="bootstrap template">
				
			  </div>
			</li>
		  </ul>
		
	</div>
	<div class="span9">
	<div class="well np">
		<div id="myCarousel" class="carousel slide homCar">
            <div class="carousel-inner">
			  <div class="item">
                <img style="width:100%" src="assets/img/food2.png" alt="bootstrap ecommerce templates">
                <div class="carousel-caption">
                      <h4>New Product Asian sauces</h4>
                      <p><span>For cooking food & easy to use</span></p>
                </div>
              </div>
			  <div class="item">
                <img style="width:100%" src="assets/img/Food1.png" alt="bootstrap ecommerce templates">
                <div class="carousel-caption">
                      <h4>Japanese food</h4>
                      <p><span>Highly Google seo friendly</span></p>
                </div>
              </div>
			  <div class="item active">
                <img style="width:100%" src="assets/img/D.png" alt="bootstrap ecommerce templates">
                <div class="carousel-caption">
                      <h4>Twitter Bootstrap cart</h4>
                      <p><span>Very easy to integrate and expand.</span></p>
                </div>
              </div>
              <div class="item">
                <img style="width:100%" src="assets/img/K2.png" alt="bootstrap templates">
                <div class="carousel-caption">
                      <h4>Bootstrap templates integration</h4>
                      <p><span>Compitable to many more opensource cart</span></p>
                </div>
              </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
          </div>
        </div>
<!--
New Products
-->
	<div class="well well-small">

	<h3>New Products </h3>
	<hr class="soften"/>
		<div class="row-fluid">
		<div id="newProductCar" class="carousel slide">
            <div class="carousel-inner">
			<div class="item active">
			  <ul class="thumbnails">
				<li class="span3">
				<div class="thumbnail">
					<a class="zoomTool" href="ProductDetails.jsp?pid=29"><span class="icon-search"></span> QUICK VIEW</a>
					<a href="#" class="tag"></a>
					<a href="ProductDetails.jsp?pid=29"><img src="assets/img/RT.png" alt="bootstrap-ring"></a>
				</div>
				</li>
				<li class="span3">
				  <div class="thumbnail">
					<a class="zoomTool" href="ProductDetails.jsp?pid=26" ><span class="icon-search"></span> QUICK VIEW</a>
					<a href="#" class="tag"></a>
					<a  href="ProductDetails.jsp?pid=26"><img src="assets/img/8801043001786_800x800.jpg" alt=""></a>
				  </div>
				</li>
				<li class="span3">
				  <div class="thumbnail">
					<a class="zoomTool" href="ProductDetails.jsp?pid=22"><span class="icon-search"></span> QUICK VIEW</a>
					<a href="#" class="tag"></a>
					<a  href="ProductDetails.jsp?pid=22"><img src="assets/img/5201051006002_800x800.jpg" alt=""></a>
				  </div>
				</li>
				<li class="span3">
				  <div class="thumbnail">
					<a class="zoomTool" href="ProductDetails.jsp?pid=24" ><span class="icon-search"></span> QUICK VIEW</a>
					<a  href="ProductDetails.jsp?pid=24"><img src="assets/img/8717953183125_800x800.jpg" alt=""></a>
				  </div>
				</li>
			  </ul>
			  </div>
		   <div class="item">
		  <ul class="thumbnails">
			<li class="span3">
			  <div class="thumbnail">
				<a class="zoomTool" href="ProductDetails.jsp?pid=27" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a  href="ProductDetails.jsp?pid=27"><img src="assets/img/6924187828544_800x800.jpg" alt=""></a>
			  </div>
			</li>
			<li class="span3">
			  <div class="thumbnail">
				<a class="zoomTool" href="ProductDetails.jsp?pid=25" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a  href="ProductDetails.jsp?pid=25"><img src="assets/img/80318217_800x800.jpg" alt=""></a>
			  </div>
			</li>
			<li class="span3">
			  <div class="thumbnail">
				<a class="zoomTool" href="ProductDetails.jsp?pid=18" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a  href="ProductDetails.jsp?pid=18"><img src="assets/img/6921180820025_800x800.jpg" alt=""></a>
			  </div>
			</li>
			<li class="span3">
			  <div class="thumbnail">
				<a class="zoomTool" href="ProductDetails.jsp?pid=19" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a  href="ProductDetails.jsp?pid=19"><img src="assets/img/6921804700757_800x800.jpg" alt=""></a>
			  </div>
			</li>
		  </ul>
		  </div>
		   </div>
		  <a class="left carousel-control" href="#newProductCar" data-slide="prev">&lsaquo;</a>
            <a class="right carousel-control" href="#newProductCar" data-slide="next">&rsaquo;</a>
		  </div>
		  </div>
		<div class="row-fluid">
		  <ul class="thumbnails">
			<li class="span4">
			  <div class="thumbnail">
				 
				<a class="zoomTool" href="ProductDetails.jsp?pid=15" ><span class="icon-search"></span> QUICK VIEW</a>
				<a href="ProductDetails.jsp?pid=15"><img src="assets/img/6921294305012_800x800.jpg" alt=""></a>
				
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail">
				<a class="zoomTool" href="ProductDetails.jsp?pid=16" ><span class="icon-search"></span> QUICK VIEW</a>
				<a href="ProductDetails.jsp?pid=16"><img src="assets/img/6921294357639_800x800.jpg" alt=""></a>
			
				
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail">
				<a class="zoomTool" href="ProductDetails.jsp?pid=14" ><span class="icon-search"></span> QUICK VIEW</a>
                                <a href="ProductDetails.jsp?pid=14"><img src="assets/img/6921294398847_800x800.jpg" alt=""></a>
				
			  </div>
			</li>
		  </ul>
		</div>
	</div>

        </div>
            </div>
<!--
Clients 
Clients 
-->
 <%

       
        } else
        {
        %>
        No user information found.
        <%
            }
        %>

<!--
Footer
-->
<footer class="footer">
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


