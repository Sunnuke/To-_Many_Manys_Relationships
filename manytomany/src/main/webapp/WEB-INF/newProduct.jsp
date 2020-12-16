<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
	<body>
		<div class="container">
			<div class="row align-items-start">
				<h1>New Product</h1>
			</div>
			<div class="row">
				<div class="col">
					<form:form action="/Product" method="post" modelAttribute="product">
						Name: <form:input path="name" placeholder="Name of Product"/><br>
						<br>Description: <form:textarea path="description" placeholder="Description of Product"/><br>
						<br>Price: <form:input type="number" path="price" placeholder="Price of Product"/><br>
						<br><br><form:button type="submit">Create</form:button><br>
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>