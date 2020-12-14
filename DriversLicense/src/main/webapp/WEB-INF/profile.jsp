<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
</head>
<body>
	
	<h1>${person.firstName} ${person.lastName}</h1>
	<br />
	<h2>License Number: ${license.number}</h2>
	<br />
	<h2>State: ${license.state}</h2>
	<br />
	<h2>Expiration Date: ${license.expirationDate}</h2>
</body>
</html>