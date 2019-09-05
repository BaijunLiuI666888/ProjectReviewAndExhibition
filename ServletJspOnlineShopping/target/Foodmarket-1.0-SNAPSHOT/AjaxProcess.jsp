<%-- 
    Document   : AjaxProcess
    Created on : 2018-3-14, 19:02:58
    Author     : LYJni
--%>

<%@ page import="java.sql.*" %>  
<%  
String name=request.getParameter("val");  
if(name==null||name.trim().equals("")){  
out.print("<p>Please enter name!</p>");  
}else{  
try{        
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/marketplace";
            String username = "root";
            String password = "";
            Connection con = null;
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
PreparedStatement ps=con.prepareStatement("select * from product where ProductName like '"+name+"%'");  
ResultSet rs=ps.executeQuery();  
  
if(!rs.isBeforeFirst()) {      
 out.println("<p>No Record Found!</p>");   
}else{  
out.print("<table border='1' cellpadding='2' width='100%'>");  
out.print("<tr><th>Name</th></tr>");  
while(rs.next()){  
out.print("<tr><td><a href='ProductDetails.jsp?pid="+rs.getInt("productid")+"'>"+rs.getString("productName")+"</a></td></tr>");  
}  
out.print("</table>");  
}
con.close();  
}catch(Exception e){out.print(e);}  
}//end of else  
%>   
