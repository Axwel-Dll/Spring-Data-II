<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Question profile</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/showquestion.css">
</head>
<body>
    <div class="container">
        <h1><c:out value="${question.question}" /></h1>
		<a href="/questions" class="dashboard-link">Question Dashboard</a>
        <div class="tags">
            <h2 class="tags-heading">Tags:</h2>
            <c:forEach items="${question.tags}" var="tag">
                <span class="badge badge-primary"><c:out value="${tag.subject}" /></span>
            </c:forEach>
        </div>

        <div class="row">
            <div class="col-md-6">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Answers</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${question.answers}" var="answer">
                            <tr>
                                <td><c:out value="${answer.answer}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
			<div class="col-md-6">
                <div class="rightpanel">
                    <h3>Add your answer:</h3>
                    <form:form action="/questions/${question.id}" method="post" modelAttribute="addAnswer">
                        <p>
                            <form:textarea path="answer" class="input-square" />
                        </p>
                        <p>
                            <form:errors class="text-danger" path="answer" />
                        </p>
   						<input type="submit" value="Answer it!" class="btn btn-primary submit-button"/>
                    </form:form>

                </div>
            </div>
        </div>
    </div>
</body>
</html>