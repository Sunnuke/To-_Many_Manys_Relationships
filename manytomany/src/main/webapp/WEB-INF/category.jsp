<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
	<body>
		<div class="container">
			<div class="row align-items-start">
				<h1>${category.name}</h1>
			</div><br>
			<div class="row">
				<div class="col">
					<h3>Products:</h3>
					<c:forEach items="${products}" var="product">
						<p>-${product.name}</p>
					</c:forEach>
				</div>
				<div class="col">
					<form:form action="/AddProduct/${category.id}" method="post" modelAttribute="product">
						<form:select path="id">
							<c:forEach items="${menu}" var="product">
								<form:option value="${product.id}">${product.name}</form:option>
							</c:forEach>
						</form:select>
						<br><br><form:button type="submit">Create</form:button>
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>