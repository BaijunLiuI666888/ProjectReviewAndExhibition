
<%@page import="java.util.ArrayList"%>
<%@page import="Dtos.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results of Update</title>
    </head>
    <body>
        <%
            // Get the result from the session (how many customers were updated)
            User resultValue = (User) session.getAttribute("userInfo");
            // If we have a result value to use, then display it
            if (resultValue != null) {
                // Cast it to a number

        %> 
        <!-- display the number of customers updated -->
        Successfully Changed: new Details are as follows;


        <table>
            <tr>
                <th>User Name</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Date joined</th>
                <th>Membership</th>
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

        <%

            session.removeAttribute("editS");
        } else {
        %>
        No customer update information found/update failed
        <%
            }

            if (resultValue.getIfAdmin() == true) {


        %>

        <div><a href="AdminManagement.jsp">Select page</a></div>
        <%                    } else {
        %>
        <div><a href="LogginSuccessful.jsp">index</a></div>           
        <%
            }
        %>
    </body>
</html>
