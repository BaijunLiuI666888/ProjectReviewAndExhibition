<%-- 
    Document   : logout
    Created on : 01-May-2018, 19:03:05
    Author     : Danielhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
session.invalidate();
response.sendRedirect("index.jsp");
%>
    