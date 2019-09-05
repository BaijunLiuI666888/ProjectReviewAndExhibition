<%-- 
    Document   : LogedVCP
    Created on : 01-May-2018, 19:40:40
    Author     : Danielhua
--%>


<%@page import="java.util.ResourceBundle"%>
<%@page import="Daos.CategoryDao"%>
<%-- 
    Document   : viewUsers
    Created on : 2017-11-19, 23:19:39
    Author     : LYJni
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
        <body id="top">
            <!-- 
                    Upper Header Section 
            -->
            <div id="fb-root"></div>
            <script>(function (d, s, id) {
                    var js, fjs = d.getElementsByTagName(s)[0];
                    if (d.getElementById(id))
                        return;
                    js = d.createElement(s);
                    js.id = id;
                    js.src = 'https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.0&appId=419377088534148&autoLogAppEvents=1';
                    fjs.parentNode.insertBefore(js, fjs);
                }(document, 'script', 'facebook-jssdk'));</script>
            <div class="navbar navbar-inverse navbar-fixed-top">
                <div class="topNav">
                    <div class="container">
                        <div class="alignR">

                            <a class="" href="LogginSuccessful.jsp"> <span class="icon-home"></span> Home</a> 
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
                <%          // Retrieve the resource bundle from the session
                    ResourceBundle dataBundle = (ResourceBundle) session.getAttribute("dataBundle");
                    // If there is no bundle stored (i.e. if this is the first time you're coming to the site)
                    if (dataBundle == null) {
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
			  <li class=""><a href="LogginSuccessful.jsp"><%=dataBundle.getString("2bar_home")%></a></li>
			  <li class="active"><a href="LogedVCP.jsp"><%=dataBundle.getString("2bar_products")%></a></li>
                          <li class=""><a href="ViewMyCart.jsp"><%=dataBundle.getString("2bar_mycart")%></a></li>
                           <li class=""><a href="ViewMyOrders.jsp"><%=dataBundle.getString("2bar_myorder")%></a></li>
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
	</div>
                <!-- 
                Body Section 
                -->
                <div class="row">
                    <div id="sidebar" class="span3">
                        <div class="well well-small">
                            <ul class="nav nav-list">
                                <p>All Categories</p>

                              <li><a href="LogedCategoryProducts.jsp?pid=1"><span class="icon-chevron-right"><%=dataBundle.getString("categorybar_drinks")%></span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=2"><%=dataBundle.getString("categorybar_sf")%></span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=3"> <%=dataBundle.getString("categorybar_freshmeat")%></span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=5"><%=dataBundle.getString("categorybar_vegetables")%></span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=6"><%=dataBundle.getString("categorybar_ingredients")%></span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=4"><%=dataBundle.getString("categorybar_riceflournoodle")%></span></a></li>
                            <li><a href="LogedCategoryProducts.jsp?pid=7"><%=dataBundle.getString("categorybar_others")%></span></a></li>

                            </ul>
                        </div>


              

    </div>
                    <div class="span9">
                        <div class="well well-small">
                            <h3>Our Products </h3>
                            <div class="row-fluid">
                                <ul class="thumbnails">
                                    <li class="span4">
                                        <div class="thumbnail">
                                          <a href="ProductDetails.jsp?pid=25" class="overlay"></a>
                                            <a class="zoomTool" href="ProductDetails.jsp?pid=25" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
                                            <a href="ProductDetails.jsp?pid=25"><img src="assets/img/80318217_800x800.jpg" alt=""></a>
                                            <div class="caption cntr">
                                                <p>Winter Bamboo Shoot</p>
                                                <p><strong> $2.00</strong></p>
                                                <form action="FrontController" method="post">   
                                                    <select id="selectWidth"  name="pQuantity" size="1"  >
                                                        <option value="1" selected>1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                        <option value="4">4</option>
                                                        <option value="5">5</option>
                                                    </select>
                                                    <input type ="hidden" name="pid" value="25"></input>


                                                    <td><input type="submit"  class="shopBtn" value="AddCart" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddCart" /></td>

                                                </form>

                                                <form action="FrontController" method="post">   
                                                    <td>
                                                        <input type="hidden" name="pid" value="25"/>
                                                    </td>
                                                    <td><input type="submit"class="pull-left" value="Add To Wishlist" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddWishlist" /></td>
                                                </form>

                                                <br class="clr">
                                            </div>
                                        </div>
                                    </li>
                                    <li class="span4">
                                        <div class="thumbnail">
                                          <a href="ProductDetails.jsp?pid=17" class="overlay"></a>
                                            <a class="zoomTool" href="ProductDetails.jsp?pid=17" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
                                            <a href="ProductDetails.jsp?pid=17"><img src="assets/img/8801043150620_800x800.jpg" alt=""></a>
                                            <div class="caption cntr">
                                                <p>Nongshim Shin Ramyun Noodle</p>
                                                <p><strong> $1.00</strong></p>
                                                 <form action="FrontController" method="post">   
                                                    <select id="selectWidth"  name="pQuantity" size="1"  >
                                                        <option value="1" selected>1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                        <option value="4">4</option>
                                                        <option value="5">5</option>
                                                    </select>
                                                    <input type ="hidden" name="pid" value="17"></input>


                                                    <td><input type="submit"  class="shopBtn" value="AddCart" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddCart" /></td>

                                                </form>

                                                <form action="FrontController" method="post">   
                                                    <td>
                                                        <input type="hidden" name="pid" value="17"/>
                                                    </td>
                                                    <td><input type="submit"class="pull-left" value="Add To Wishlist" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddWishlist" /></td>
                                                </form>
                                                <br class="clr">
                                            </div>
                                        </div>
                                    </li>
                                    <li class="span4">
                                        <div class="thumbnail">
                                            <a href="ProductDetails.jsp?pid=19" class="overlay"></a>
                                            <a class="zoomTool" href="ProductDetails.jsp?pid=19" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
                                            <a href="ProductDetails.jsp?pid=19"><img src="assets/img/6921804700757_800x800.jpg" alt=""></a>
                                      
                                                 <div class="caption cntr">
                                                 <p>Preserved Black Beans in Chilli Oil</p>
                                                <p><strong> $2.00</strong></p>
                                                 <form action="FrontController" method="post">   
                                                    <select id="selectWidth"  name="pQuantity" size="1"  >
                                                        <option value="1" selected>1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                        <option value="4">4</option>
                                                        <option value="5">5</option>
                                                    </select>
                                                    <input type ="hidden" name="pid" value="19"></input>


                                                    <td><input type="submit"  class="shopBtn" value="AddCart" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddCart" /></td>

                                                </form>

                                                <form action="FrontController" method="post">   
                                                    <td>
                                                        <input type="hidden" name="pid" value="19"/>
                                                    </td>
                                                    <td><input type="submit"class="pull-left" value="Add To Wishlist" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddWishlist" /></td>
                                                </form>
                                                <br class="clr">
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="row-fluid">
                                <ul class="thumbnails">
                                    <li class="span4">
                                        <div class="thumbnail">
                                         <a href="ProductDetails.jsp?pid=20" class="overlay"></a>
                                            <a class="zoomTool" href="ProductDetails.jsp?pid=20" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
                                            <a href="ProductDetails.jsp?pid=20"><img src="assets/img/8715035110106_800x800.jpg" alt=""></a>
                                            <div class="caption cntr">
                                                <p>Kikkoman Soy Sauce</p>
                                                <p><strong> $3.00</strong></p>
                                                 <form action="FrontController" method="post">   
                                                    <select id="selectWidth"  name="pQuantity" size="1"  >
                                                        <option value="1" selected>1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                        <option value="4">4</option>
                                                        <option value="5">5</option>
                                                    </select>
                                                    <input type ="hidden" name="pid" value="20"></input>


                                                    <td><input type="submit"  class="shopBtn" value="AddCart" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddCart" /></td>

                                                </form>

                                                <form action="FrontController" method="post">   
                                                    <td>
                                                        <input type="hidden" name="pid" value="20"/>
                                                    </td>
                                                    <td><input type="submit"class="pull-left" value="Add To Wishlist" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddWishlist" /></td>
                                                </form>
                                                <br class="clr">
                                            </div>
                                        </div>
                                    </li>
                                    <li class="span4">
                                        <div class="thumbnail">
                                            <a href="ProductDetails.jsp?pid=18" class="overlay"></a>
                                            <a class="zoomTool" href="ProductDetails.jsp?pid=18" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
                                            <a href="ProductDetails.jsp?pid=18"><img src="assets/img/6921180820025_800x800.jpg" alt=""></a>
                                            <div class="caption cntr">
                                                <p>Pearl River Bridge Light Soy Sauce </p>
                                                <p><strong> $2.00</strong></p>
                                                 <form action="FrontController" method="post">   
                                                    <select id="selectWidth"  name="pQuantity" size="1"  >
                                                        <option value="1" selected>1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                        <option value="4">4</option>
                                                        <option value="5">5</option>
                                                    </select>
                                                    <input type ="hidden" name="pid" value="18"></input>


                                                    <td><input type="submit"  class="shopBtn" value="AddCart" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddCart" /></td>

                                                </form>

                                                <form action="FrontController" method="post">   
                                                    <td>
                                                        <input type="hidden" name="pid" value="18"/>
                                                    </td>
                                                    <td><input type="submit"class="pull-left" value="Add To Wishlist" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddWishlist" /></td>
                                                </form>
                                                <br class="clr">
                                            </div>
                                        </div>
                                    </li>
                                    <li class="span4">
                                        <div class="thumbnail">
                                            <a href="ProductDetails.jsp?pid=21" class="overlay"></a>
                                            <a class="zoomTool" href="ProductDetails.jsp?pid=21" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
                                            <a href="ProductDetails.jsp?pid=21"><img src="assets/img/8853662056241_800x800.jpg" alt=""></a>
                                            <div class="caption cntr">
                                                <p>Flying Goose Sriracha Chilli Sauce Extra Coriander</p>
                                                <p><strong> $3.00</strong></p>
                                                  <form action="FrontController" method="post">   
                                                    <select id="selectWidth"  name="pQuantity" size="1"  >
                                                        <option value="1" selected>1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                        <option value="4">4</option>
                                                        <option value="5">5</option>
                                                    </select>
                                                    <input type ="hidden" name="pid" value="21"></input>


                                                    <td><input type="submit"  class="shopBtn" value="AddCart" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddCart" /></td>

                                                </form>

                                                <form action="FrontController" method="post">   
                                                    <td>
                                                        <input type="hidden" name="pid" value="21"/>
                                                    </td>
                                                    <td><input type="submit"class="pull-left" value="Add To Wishlist" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddWishlist" /></td>
                                                </form>
                                                <br class="clr">
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="row-fluid">
                                <ul class="thumbnails">
                                    <li class="span4">
                                        <div class="thumbnail">
                                            <a href="ProductDetails.jsp?pid=30" class="overlay"></a>
                                            <a class="zoomTool" href="ProductDetails.jsp?pid=30" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
                                            <a href="ProductDetails.jsp?pid=30"><img src="assets/img/8850030113155_800x800.jpg" alt=""></a>
                                            <div class="caption cntr">
                                                <p>Lobo Sukiyaki Sauce</p>
                                                <p><strong> $3.00</strong></p>
                                                <form action="FrontController" method="post">   
                                                    <select id="selectWidth"  name="pQuantity" size="1"  >
                                                        <option value="1" selected>1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                        <option value="4">4</option>
                                                        <option value="5">5</option>
                                                    </select>
                                                    <input type ="hidden" name="pid" value="30"></input>


                                                    <td><input type="submit"  class="shopBtn" value="AddCart" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddCart" /></td>

                                                </form>

                                                <form action="FrontController" method="post">   
                                                    <td>
                                                        <input type="hidden" name="pid" value="30"/>
                                                    </td>
                                                    <td><input type="submit"class="pull-left" value="Add To Wishlist" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddWishlist" /></td>
                                                </form>
                                                <br class="clr">
                                            </div>
                                        </div>
                                    </li>
                                    <li class="span4">
                                        <div class="thumbnail">
                                           <a href="ProductDetails.jsp?pid=24" class="overlay"></a>
                                            <a class="zoomTool" href="ProductDetails.jsp?pid=24" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
                                            <a href="ProductDetails.jsp?pid=24""><img src="assets/img/8717953183125_800x800.jpg" alt=""></a>
                                            <div class="caption cntr">
                                                <p>Fu Xing Pickled Cabbage</p>
                                                <p><strong> $1.00</strong></p>
                                                  <form action="FrontController" method="post">   
                                                    <select id="selectWidth"  name="pQuantity" size="1"  >
                                                        <option value="1" selected>1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                        <option value="4">4</option>
                                                        <option value="5">5</option>
                                                    </select>
                                                    <input type ="hidden" name="pid" value="24"></input>


                                                    <td><input type="submit"  class="shopBtn" value="AddCart" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddCart" /></td>

                                                </form>

                                                <form action="FrontController" method="post">   
                                                    <td>
                                                        <input type="hidden" name="pid" value="24"/>
                                                    </td>
                                                    <td><input type="submit"class="pull-left" value="Add To Wishlist" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddWishlist" /></td>
                                                </form>
                                                <br class="clr">
                                            </div>
                                        </div>
                                    </li>
                                    <li class="span4">
                                        <div class="thumbnail">
                                             <a href="ProductDetails.jsp?pid=22" class="overlay"></a>
                                            <a class="zoomTool" href="ProductDetails.jsp?pid=22" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
                                            <a href="ProductDetails.jsp?pid=22"><img src="assets/img/5201051006002_800x800.jpg" alt=""></a>
                                            <div class="caption cntr">
                                                <p>Zanae Squids In Hot Sauce</p>
                                                <p><strong> $3.00</strong></p>
                                                 <form action="FrontController" method="post">   
                                                    <select id="selectWidth"  name="pQuantity" size="1"  >
                                                        <option value="1" selected>1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                        <option value="4">4</option>
                                                        <option value="5">5</option>
                                                    </select>
                                                    <input type ="hidden" name="pid" value="22"></input>


                                                    <td><input type="submit"  class="shopBtn" value="AddCart" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddCart" /></td>

                                                </form>

                                                <form action="FrontController" method="post">   
                                                    <td>
                                                        <input type="hidden" name="pid" value="22"/>
                                                    </td>
                                                    <td><input type="submit"class="pull-left" value="Add To Wishlist" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddWishlist" /></td>
                                                </form>
                                                <br class="clr">
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="row-fluid">
                                <ul class="thumbnails">
                                    <li class="span4">
                                        <div class="thumbnail">
                                            <a href="ProductDetails.jsp?pid=16" class="overlay"></a>
                                            <a class="zoomTool" href="ProductDetails.jsp?pid=16" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
                                            <a href="ProductDetails.jsp?pid=16"><img src="assets/img/6921294357639_800x800.jpg" alt=""></a>
                                            <div class="caption cntr">
                                                <p>Honey Pomelo Drink</p>
                                                <p><strong> $2.00</strong></p>
                                                  <form action="FrontController" method="post">   
                                                    <select id="selectWidth"  name="pQuantity" size="1"  >
                                                        <option value="1" selected>1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                        <option value="4">4</option>
                                                        <option value="5">5</option>
                                                    </select>
                                                    <input type ="hidden" name="pid" value="16"></input>


                                                    <td><input type="submit"  class="shopBtn" value="AddCart" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddCart" /></td>

                                                </form>

                                                <form action="FrontController" method="post">   
                                                    <td>
                                                        <input type="hidden" name="pid" value="16"/>
                                                    </td>
                                                    <td><input type="submit"class="pull-left" value="Add To Wishlist" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddWishlist" /></td>
                                                </form>
                                                <br class="clr">
                                            </div>
                                        </div>
                                    </li>
                                    <li class="span4">
                                        <div class="thumbnail">
                                          <a href="ProductDetails.jsp?pid=14" class="overlay"></a>
                                            <a class="zoomTool" href="ProductDetails.jsp?pid=14" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
                                            <a href="ProductDetails.jsp?pid=14"><img src="assets/img/6921294398847_800x800.jpg" alt=""></a>
                                            <div class="caption cntr">
                                                <p>KSF Green Tea</p>
                                                <p><strong> $3.00</strong></p>
                                                <form action="FrontController" method="post">   
                                                    <select id="selectWidth"  name="pQuantity" size="1"  >
                                                        <option value="1" selected>1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                        <option value="4">4</option>
                                                        <option value="5">5</option>
                                                    </select>
                                                    <input type ="hidden" name="pid" value="14"></input>


                                                    <td><input type="submit"  class="shopBtn" value="AddCart" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddCart" /></td>

                                                </form>

                                                <form action="FrontController" method="post">   
                                                    <td>
                                                        <input type="hidden" name="pid" value="14"/>
                                                    </td>
                                                    <td><input type="submit"class="pull-left" value="Add To Wishlist" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddWishlist" /></td>
                                                </form>
                                                <br class="clr">
                                            </div>
                                        </div>
                                    </li>
                                    <li class="span4">
                                        <div class="thumbnail">
                                           <a href="ProductDetails.jsp?pid=15" class="overlay"></a>
                                            <a class="zoomTool" href="ProductDetails.jsp?pid=15" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
                                            <a href="ProductDetails.jsp?pid=15"><img src="assets/img/6921294305012_800x800.jpg" alt=""></a>
                                            <div class="caption cntr">
                                                <p>KSF Ice Red Tea</p>
                                                <p><strong> $2.00</strong></p>
                                                 <form action="FrontController" method="post">   
                                                    <select id="selectWidth"  name="pQuantity" size="1"  >
                                                        <option value="1" selected>1</option>
                                                        <option value="2">2</option>
                                                        <option value="3">3</option>
                                                        <option value="4">4</option>
                                                        <option value="5">5</option>
                                                    </select>
                                                    <input type ="hidden" name="pid" value="15"></input>


                                                    <td><input type="submit"  class="shopBtn" value="AddCart" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddCart" /></td>

                                                </form>

                                                <form action="FrontController" method="post">   
                                                    <td>
                                                        <input type="hidden" name="pid" value="15"/>
                                                    </td>
                                                    <td><input type="submit"class="pull-left" value="Add To Wishlist" /></td> 
                                                    <td><input type="hidden" name ="action" value="AddWishlist" /></td>
                                                </form>
                                                <br class="clr">
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>

                        </div>
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
