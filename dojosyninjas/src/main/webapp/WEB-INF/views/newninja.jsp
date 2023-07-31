<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Ninja</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<div id="container">
		<div id="leftpanel">
			<h1>New Ninja</h1>
		    <form:form accept-charset="UTF-8" action="/ninjas/new" method="post" modelAttribute="add">
				<h2>
			        <form:label path="dojo">Dojo:</form:label>
			        <form:errors path="dojo"/>
					<form:select path="dojo">
						<c:forEach items="${dojos}" var="dojo">
						    <form:option value="${dojo}"><c:out value="${dojo.name}"/></form:option>
						</c:forEach>
			 		</form:select>
			    </h2>
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
			    <h2>
			        <form:label path="age">Age:</form:label>
			        <form:errors path="age"/>
			        <form:input path="age"/>
			    </h2> 
			    <input id="btn" type="submit" value="create"/>
			</form:form>
		</div>
	</div>
</body>
</html>
