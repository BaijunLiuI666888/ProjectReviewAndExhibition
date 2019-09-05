<%-- 
    Document   : error
    Created on : 2017-11-19, 20:50:52
    Author     : LYJni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                    <h1>Something went wrong??</h1>
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
