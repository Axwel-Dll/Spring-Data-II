<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Category</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div id="container">
        <h1>New Category</h1>
        <form:form accept-charset="UTF-8" action="/categories/new" method="post" modelAttribute="category">
            <h2>
                <form:label path="name">Name:</form:label>
                <form:errors path="name"/>
                <form:input path="name"/>
            </h2>
            <input id="btn" type="submit" value="create"/>
        </form:form>
    </div>
</body>
</html>
