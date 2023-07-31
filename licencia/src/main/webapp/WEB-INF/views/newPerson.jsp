<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Person</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div id="container">
    	<h1>New Person</h1>
        <form:form accept-charset="UTF-8" action="/persons/new" method="post" modelAttribute="addperson">
            <h2>
                <form:label path="firstName">First Name:</form:label>
                <form:errors path="firstName"/>
                <form:input path="firstName"/>
            </h2>
            <h2>
                <form:label path="lastName">Last Name:</form:label>
                <form:errors path="lastName"/>
                <form:input path="lastName"/>
            </h2>
            <input id="btn" type="submit" value="Create"/>
        </form:form> 
    </div>    
</body>
</html>