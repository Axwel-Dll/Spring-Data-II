<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Porduct</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div id="container">
        <h1>New Product</h1>
        <form:form accept-charset="UTF-8" action="/products/new" method="post" modelAttribute="product">
            <h2>
                <form:label path="name">Name:</form:label>
                <form:errors path="name"/>
                <form:input path="name"/>
            </h2>
            <h2>
                <form:label path="description">Description:</form:label>
                <form:errors path="description"/>
                <form:textarea path="description"/>
            </h2>
            <h2>
                <form:label path="price">Price:</form:label>
                <form:errors path="price"/>
                <form:input path="price"/>
            </h2>   
            <input id="btn" type="submit" value="create"/>
        </form:form>
    </div>
</body>
</html>
