<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/styles.css">
<title>Profile Page</title>
</head>
<body>
	<div id="container">
		<div id="leftpanel">
			<h1><c:out value="${license.person.firstName} ${license.person.lastName}"/></h1>
			<h2>License Number: <c:out value="${license.number}"/></h2>
			<h2>State: <c:out value="${license.state}"/></h2>
			<h2>Expiration Date: <fmt:formatDate pattern ="MM-dd-yyyy" value ="${license.expirationDate}"/></h2>
		</div>
	</div>
</body>
</html>