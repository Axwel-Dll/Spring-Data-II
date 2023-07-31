<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>New License</title>
  <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
  <div id="container">
    <h1>New License</h1>
    <form:form accept-charset="UTF-8" action="/licenses/new" method="post" modelAttribute="license">
        <h2>Person
          <select name="person" id="person">
          <c:forEach items="${persons}" var="person">
                <option value="${person.id}">${person.firstName} ${person.lastName}</option>
            </c:forEach>
        </select>
        </h2>
        <h2>
          <form:label path="state">State</form:label>
          <form:errors path="state"/>
          <form:input path="state"/>
        </h2>
        <h2>
          <form:label path="expirationDate">Expiration Date</form:label>
          <form:errors path="expirationDate"/>
          <input type="date" id="expirationDate" name="expirationDate">
        </h2>
        <input id="btn" type="submit" value="Create"/>
    </form:form>  
  </div>
</body>
</html>
   