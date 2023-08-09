<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <table class="table table-striped">
        <thead>
            <th>City Name</th>
            <th>Population</th>
            <th>country_id</th>
        </thead>
        <tbody>
            <c:forEach var="city" items="${table}">
                <tr>
                    <td>${city.name}</td>
                    <td>${city.population}</td>
                    <td>${city.country.id}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
