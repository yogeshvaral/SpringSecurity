<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/files/css/style.css">
</head>
<title>Add User</title>
</head>
<body>
<table>
<form:form modelAttribute="user" action="addUser">
<tr><td> Name : <form:input path="name"/>
<form:errors path="name" cssStyle="color:red"></form:errors></td></tr>
<tr><td> Email : <form:input path="email"/>
<form:errors path="email" cssStyle="color:red"></form:errors></td></tr>
<tr><td> Password : <form:input path="password"/>

<tr><td><input type="submit" value="submit"></td></tr>
</form:form>
</table>
</body>
</html>