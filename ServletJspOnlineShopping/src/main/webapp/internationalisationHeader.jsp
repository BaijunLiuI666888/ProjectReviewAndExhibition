<%-- 
   
--%>

<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<%

    Locale clientLocale = (Locale) session.getAttribute("currentLocale");

 
    if(clientLocale == null){
    
        clientLocale = request.getLocale();
     
        session.setAttribute("currentLocale", clientLocale);
    }
%>

<form action="FrontController" method="post">

    <select name ="language" onchange="this.form.submit()">
        <%
            String language = (String) session.getAttribute("language");
            if(language == null || language.equals("en")){
                
        %>
            <option value="en" selected>English</option>
            <option value="cn">Chinese</option>
        <%
            }else{
        %>
            <option value="en">English</option>
            <option value="cn" selected>Chinese</option>
        <%        
            }
        %>
    </select>
    <input type="hidden" name="action" value="changeLanguage"/>
</form>
