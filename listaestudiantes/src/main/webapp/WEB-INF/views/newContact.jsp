<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>New Contact</title>
  <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
  <div id="container">
    <h1>New Contact</h1>
    <form:form accept-charset="UTF-8" action="/contact/new" method="post" modelAttribute="addcontact">
        <h2>Student:
          <select name="student" id="student">
          <c:forEach items="${students}" var="student">
                <option value="${student.id}">${student.firstName} ${student.lastName}</option>
            </c:forEach>
        </select>
        </h2>
		<h2>
          <form:label path="address">Address:</form:label>
          <form:errors path="address"/>
          <form:input path="address"/>
        </h2>
		<h2>
          <form:label path="city">City:</form:label>
          <form:errors path="city"/>
          <form:input path="city"/>
        </h2>
        <h2>
          <form:label path="state">State:</form:label>
          <form:errors path="state"/>
          <form:input path="state"/>
        </h2>
        <input id="btn" type="submit" value="Create"/>
    </form:form>  
  </div>
</body>
</html>
   