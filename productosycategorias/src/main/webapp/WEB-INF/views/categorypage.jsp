<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Category Page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div id="container">
		<div id="leftpanel">
			<h1><c:out value="${category.name}"/></h1>
			<h2>Products:</h2>
			<c:forEach items="${category.products}" var="product">				
			<h3>-<c:out value="${product.name}"/></h3>				
			</c:forEach>
		</div>
		<div id="rigthpanel">
			<form:form action="/categories/${category.id}" method="post" modelAttribute="productCategory">
				<h2>
					<form:label path="product">Add Product</form:label>
					   <form:select path="product">
						   <c:forEach items="${products}" var="product">
							   <form:option value="${product.id}"><c:out value="${product.name}"/></form:option>
						</c:forEach>
					 </form:select>
				</h2> 
				<form:input type="hidden" path="category" value="${category.id}" />
				<input id="btn" type="submit" value="add"/>	
			</form:form>  
		</div>
    </div>
</body>
</html>
