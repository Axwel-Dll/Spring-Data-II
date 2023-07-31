<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<div id="container">
		<div id="leftpanel">
   			<h1>New Dojo</h1>
	        <form:form action="/dojos/new" method="post" modelAttribute="add">
	        <p>
	            <form:label path="name">Name</form:label>
	            <form:errors path="name"/>
	            <form:input path="name"/>
	        </p> 
	        <input id="btn2" type="submit" value="create"/>
	        </form:form>  
    	</div>
	</div>
</body>
</html>
