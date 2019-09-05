


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
           
            User resultValue =(User)session.getAttribute("logginS"); 

           String user = resultValue.getUserName();
            if (resultValue != null)
            {
                // Cast it to a number
                
        %> 
       
        welcome <%=user%>

        <%

           // session.removeAttribute("logginS");
        } else
        {
        %>
        No user information found.
        <%
            }
        %>
        
        
        
        
         <table>
            <tr>
                <th>UserName</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Gender</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Date</th>
                <th>Vip Member</th>
                
               
            </tr>
       
            <!-- Create a row for this customer -->
            <tr>
                <!-- Create a cell for each component of this customer's information and fill it with 
                     data in this customer's object -->
                <td><%=resultValue.getUserName()%></td>
                <td><%=resultValue.getFirstName()%></td>
                <td><%=resultValue.getLastName()%></td>
                <td><%=resultValue.getGender()%></td>
                 <td><%=resultValue.getPhone()%></td>
                 <td><%=resultValue.getEmail()%></td>
                 <td><%=resultValue.getAddress()%></td>
                 <td><%=resultValue.getDate()%></td>
                 <td><%=resultValue.getIfVip()%></td>
             

            </tr>
           
        </table>
       
        <div><a href="index.html">Back to index</a></div>
        <div><a href="EditDetails.jsp">Edit info</a></div>
    </body>
</html>
