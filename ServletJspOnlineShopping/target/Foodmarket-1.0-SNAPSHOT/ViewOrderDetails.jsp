<%-- 
    Document   : QuantitySelect
    Created on : 15-Feb-2018, 13:25:56
    Author     : d00172193
--%>

<%@page import="Dtos.OrderProduct"%>
<%@page import="Dtos.Product"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Dtos.User"%>
<%@page import="Dtos.CartProduct"%>
<%@page import="Dtos.Cart"%>
<%@page import="java.util.List"%>
<%@page import="Dtos.Cart"%>
<%@page import="Daos.CartDao"%>
<%@page import="Daos.OrderDetailDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
<html>
 
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
<!-- 
	Upper Header Section 
-->


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
                         <ul class="nav">
			  <li class=""><a href="LogginSuccessful.jsp"><%=dataBundle.getString("2bar_home")%></a></li>
			  <li class=""><a href="LogedVCP.jsp"><%=dataBundle.getString("2bar_products")%></a></li>
                          <li class=""><a href="ViewMyCart.jsp"><%=dataBundle.getString("2bar_mycart")%></a></li>
                           <li class="active"><a href="ViewMyOrders.jsp"><%=dataBundle.getString("2bar_myorder")%></a></li>
                             <li class=""><a href="ViewWishlist.jsp"><%=dataBundle.getString("2bar_wishlist")%></a></li>
                  <form name="vinform" action="SearchResult.jsp" method ="post" class="navbar-search pull-left">
                                <input type="text" name="t1" onkeyup="sendInfo()" placeholder="Search a product..." class="search-query span2">
                                <span id="amit"> </span>
                 </form>
                             
                              
                               <li class=""><a href="logout.jsp"><%=dataBundle.getString("2bar_logout")%></a></li>
			</ul>
		</div>
	  </div>
	</div>
-->
	
	<div class="row">
	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="index.jsp">Home</a> <span class="divider">/</span></li>
		<li class="active">Order History</li>
 </ul>
<div class="well well-small">
		<h1>Detailed Order</h1>
	<hr class="soften"/>	
			
       
        <h1>Your Detailed order</h1>
        <%
            User resultValue = (User) session.getAttribute("logginS");
            int oid = Integer.parseInt(request.getParameter("oid"));
            int uId = resultValue.getUserID();
            if (resultValue != null) {
                OrderDetailDao odDao = new OrderDetailDao("marketplace");

                List<OrderProduct> items = odDao.AllInOrderByOrderId(oid);
                double total = 0.0;
                DecimalFormat df = new DecimalFormat("#.00");
              
        %>
        <!-- set up table structure -->
      <table class="table table-bordered table-condensed">
          <thead>
            <tr>
                <th>Product Name</th>
               <th>Image1</th>
               <th>Price</th>
                <th>Quantity Selected</th>
               


            </tr>
               <thead>
            <%
                for (OrderProduct c : items) {

            %>
         
  <tbody>
            <tr>

                <td><%=c.getProductname()%></td>
                
                <td> <img src="${pageContext.servletContext.contextPath }/ShowImage?ProductID=<%=c.getProductid()%>" /></td>
               <td><%=c.getPrice()%></td>
                <td><%=c.getQuantity()%></td>
            

              


              <tbody>


            <%
                    total += c.getQuantity() * c.getPrice();

                }
              
            %>

            <p>Hello <%=resultValue.getUserName()%> : <br> There was your total Pay For this order: </p>
            <p>total: <%=df.format(total)%> (EURO)</p>
            <%     session.setAttribute("price",total);                              %>
            <%--         ***********************        --%>


            <%                } else {
            %>please Login first<%
                }
            %>
        </table>
        <a href="LogedVCP.jsp" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Continue Shopping </a>
        
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