<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>New Question</title>
	<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<div class="container">
		<h1>What is your question?</h1>
    
		<form action="/questions/new" method="post">
			<label>Question:</label><br>
			<textarea name="question" rows="4" cols="50"></textarea><br>
			<span style="color: red">${questionError}</span><br> 
			
			<label>Tags (separados por comas):</label><br>
			<input type="text" name="tags"><br>
			<span style="color: red">${tagsError}</span><br> 
			
			<input type="submit" value="Submit" class="btn btn-primary submit-button"/>
		</form>
	</div>
</body>
</html>