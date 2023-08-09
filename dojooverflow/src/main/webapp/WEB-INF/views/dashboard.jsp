<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Question Dashboard</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<div class="container">
		<h1>Questions Dashboard</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Question</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${questions}" var="question">
				<tr>
					<td><a href="/questions/${question.id}"> <c:out value="${question.question}" /></a></td>
					<td><c:forEach items="${question.tags}" var="tag">
							<c:out value="${tag.subject}" />
						</c:forEach>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a id="newquestion" href="/questions/new">New Question</a>
	</div>

</body>
</html>