<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div id="container">
		<div id="leftpanel">
			<h1><c:out value="${product.name}"/></h1>
			<h2>Categories:</h2>
			<c:forEach items="${product.categories}" var="cat">				
			<h3>-<c:out value="${cat.name}"/></h3>				
			</c:forEach>
		</div>
		<div id="rigthpanel">
			<form:form action="/products/${product.id}" method="post" modelAttribute="categoryProduct">
				<h2>
					<form:label path="category">Add Category</form:label>
					   <form:select path="category">
						   <c:forEach items="${categories}" var="cat">
							   <form:option value="${cat.id}"><c:out value="${cat.name}"/></form:option>
						</c:forEach>
					 </form:select>
				</h2> 
				<form:input type="hidden" path="product" value="${product.id}" />
				<input id="btn" type="submit" value="add"/>	
			</form:form>  
		</div>
    </div>
</body>
</html>
