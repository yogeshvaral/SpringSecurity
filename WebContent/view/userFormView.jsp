<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Form</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/files/css/style.css">
</head>
<body>
	<h4>Submit Your Information</h4>
	<hr>
	<form:form action="displayUserInfo" modelAttribute="user">
Name: <form:input path="name" required="true" placeholder="Enter Name" />
	  <form:errors path="name"/>
		</p>
Gender: Male: <form:radiobutton path="gender" value="Male" />
		Female: <form:radiobutton path="gender" value="Female" />
		</p>
Country:<form:select path="country">
			<form:option value="India" />
			<form:option value="United States" label="The United States" />
			<form:option value="England" />
			<form:option value="Poland" />
		</form:select>
		</P>
Introduction:<form:textarea path="introduction" />
		</p>
VisitedCountries:
			Taiwan <form:checkbox path="visitedCountries" value="Taiwab" />
			Brazil <form:checkbox path="visitedCountries" value="Brazil" />
			Shrilanka <form:checkbox path="visitedCountries" value="Shrilanka" />
			Australia <form:checkbox path="visitedCountries" value="Australia" />
		</p>
		Accept Agreement<form:checkbox path="" value="Accept" required="true" />
		</p>
		<input type="submit" value="submit">

	</form:form>

</body>
</html>