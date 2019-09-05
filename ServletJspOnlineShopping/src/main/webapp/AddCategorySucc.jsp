<%-- 
    Document   : AddCategorySucc
    Created on : 13-Mar-2018, 20:32:41
    Author     : Danielhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <body>
          <%
          
            Object resultValue = session.getAttribute("Category");
          
        
            if (resultValue != null)
            {
              
         %> 
successfully 

        <%

            session.removeAttribute("Category");
        } else
        {
        %>
        No customer update information found.
        <%
            }
        %>
        <div><a href="index.jsp">Back to index</a></div>
    </body>
</html>