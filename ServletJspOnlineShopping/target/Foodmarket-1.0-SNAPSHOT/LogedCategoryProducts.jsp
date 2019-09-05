<%-- 
    Document   : LogedCategoryProducts
    Created on : 02-May-2018, 16:12:54
    Author     : Danielhua
--%>

<%@page import="Daos.CategoryDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
			  <li class=""><a href="LogginSuccessful.jsp">Home</a></li>
			  <li class="active"><a href="LogedVCP.jsp">Products</a></li>
                          <li class=""><a href="ViewMyCart.jsp">My Cart</a></li>
                           <li class=""><a href="ViewMyOrders.jsp">My Order</a></li>
                             <li class=""><a href="ViewWishlist.jsp">Wish List</a></li>
                        
		 <form name="vinform" action="SearchResult.jsp" method ="post" class="navbar-search pull-left">
                                <input type="text" name="t1" onkeyup="sendInfo()" placeholder="Search a product..." class="search-query span2">
                                <span id="amit"> </span>
                 </form>
                              
                             <li class=""><a href="logout.jsp">LogOut</a><li>
			</ul>
			
                      
		
                    
			
		  </div>
		</div>
	  </div>
	</div>
 
                <div class="row">
                <div id="sidebar" class="span3">
                    <div class="well well-small">
                        <ul class="nav nav-list">
                            <p>All Categories</p>

                            <li><a href="LogedCategoryProducts.jsp?pid=1"><span class="icon-chevron-right">Drinks</span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=2"><span class="icon-chevron-right">Seafood</span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=3"><span class="icon-chevron-right">Fresh Meat</span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=5"><span class="icon-chevron-right">Ingredients</span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=6"><span class="icon-chevron-right">Vegetables</span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=4"><span class="icon-chevron-right">RICE & FLOUR & NOODLES</span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=7"><span class="icon-chevron-right">Others</span></a></li>


                        </ul>
                    </div>
                </div>
                
       
<div class="span9">
            <marquee><h1>welcome</h1></marquee>  


            <br>
            <h1>Our products</h1>
            <%
                int uId = 0;
                User resultValue = (User) session.getAttribute("logginS");
                if (resultValue != null) {
                    uId = resultValue.getUserID();
                }
                CategoryDao cDao = new CategoryDao("marketplace");
                int pid = Integer.parseInt(request.getParameter("pid"));
                List<Product> products = cDao.getAllProductsByCID(pid);

            %>
            <!-- set up table structure -->
            <%                for (Product p : products) {


            %>
            <form action="FrontController" method="post">   
                <input type="hidden" name="pid" value="<%=p.getProductID()%>"/>
                <div class="row-fluid">
                    <ul class="thumbnails">
                        <li class="span4">
                            <div class="thumbnail">
                                <a href="ProductDetails.jsp" class="overlay"></a>
                                <a class="zoomTool" href="ProductDetails.jsp" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
                                <a href="ProductDetails.jsp?pid=<%=p.getProductID()%>"> <img src="${pageContext.servletContext.contextPath }/ShowImage?ProductID=<%=p.getProductID()%>" /></a>

                            </div>
                        </li>
                    </ul>
                </div>








                <%if (resultValue != null) {


                %>
                <td> <select name="pQuantity" size="1" id="pQuantity">
                        <option value="1" selected>1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </td>

                <td><input type="submit" value="AddCart" /></td> 
                <td><input type="hidden" name ="action" value="AddCart" /></td>
                    <%                }


                    %>

            </form>

<%    if (resultValue != null) {
%>
            <form action="FrontController" method="post">   
                <td>
                    <input type="hidden" name="pid" value="<%=p.getProductID()%>"/>
                </td>
                <td><input type="submit" value="Add To Wishlist" /></td> 
                <td><input type="hidden" name ="action" value="AddWishlist" /></td>
            </form>

<%
}%>



        
        <%                // Close the loop
            }


        %>
    </table>



</form> 
<%    if (resultValue != null) {
%>
<form> 
    <input type=button 
           value="MY CART"
           onClick="self.location = 'ViewMyCart.jsp'">
</form> 

<%
} else {
%>
<form> 
    <input type=button 
           value="Log In"
           onClick="self.location = 'Loggin.jsp'">
</form> 

<%
    }

%>
</div>
                </div>
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

