<%@page import="com.cg.project.bean.Associate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<font color="olive" size="7">
<table>
<tr>
<td>Welcome</td>
 <td>${requestScope.associate.associateId}</td>
</tr>
<tr>
<td>First Name:</td>
 <td>${requestScope.associate.firstName} </td>
</tr>
<tr>
<td>Hobbies</td>
<td><c:forEach var="hobby" items="${requestScope.associate.hobbies}"> hobby</c:forEach> </td>
</tr>
</table>
<%-- <%
Associate associate=(Associate) request.getAttribute("associate");
out.print("Welcome");
/* out.print("First Name:"+associate.getFirstName());
out.print("Last Name:"+associate.getLastName());
out.print("Email:"+associate.getEmail());
out.print("Password:"+associate.getPassword());
out.print("Date of Birth:"+associate.getDate()); */
%> --%>
</font>
</div>
</body>
</html>