<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Name view</title>
</head>
<body>
today is : ${date} </br>
Hello ${name} </br>

____________________________<br>
List of team Members
<c:forEach var="temp" items="${team}">
</br>	${temp} 
</c:forEach>
</body>
</html>