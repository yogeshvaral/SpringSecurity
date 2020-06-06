<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Access Denied</title>
</head>
<body>
Access Denied
</p>
Follow the link to navigate to Homepage
<c:url var="homepage" value="/"/>
<a href="${homepage}" > Follow Me</a>
</body>
</html>