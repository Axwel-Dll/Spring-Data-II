<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Students</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div id="container">
        <h1>All Students</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Address</th>
                    <th>City</th>
                    <th>State</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${students}" var="student">
                <tr>
                    <td><c:out value="${student.firstName} ${student.lastName}"/></td>
                    <td><c:out value="${student.age}"/></td>
                    <td><c:out value="${student.contact.address}"/></td>
                    <td><c:out value="${student.contact.city}"/></td>
                    <td><c:out value="${student.contact.state}"/></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
