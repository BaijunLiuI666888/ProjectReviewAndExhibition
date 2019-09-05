<%-- 

--%>


<%@page import="Daos.UserDao"%>
<%@page import="Dtos.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>welcome</title>
    </head>
 <body>
       
        <%
           
            User resultValue =(User)session.getAttribute("userInfo"); 
           
           String user = resultValue.getUserName();
            if (resultValue != null)
            {
        
                
        %> 
       
        welcome <%=user%>

        <%

          
        } else
        {
        %>
        No user information found.
        <%
            }
        %>
        
        
        
        {
         <table>
            <tr>
                <th>UserName</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Address</th>
                <th>JoinDate</th>
                
               
            </tr>
       
         
            <tr>
           
                <td><%=resultValue.getUserName()%></td>
                <td><%=resultValue.getFirstName()%></td>
                <td><%=resultValue.getLastName()%></td>
                 <td><%=resultValue.getPhone()%></td>
                 <td><%=resultValue.getGender()%></td>
                 <td><%=resultValue.getAddress()%></td>
                 <td><%=resultValue.getDate()%></td>
             

            </tr>
           
        </table>
       
        <div><a href="index.jsp">Back to index</a></div>
        <div><a href="EditDetails.jsp">Edit info</a></div>
    </body>
</html>
