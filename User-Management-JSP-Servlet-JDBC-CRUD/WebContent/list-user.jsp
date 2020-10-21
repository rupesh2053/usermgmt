<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User management application</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-3">
		<h4 class="text-center mt-2 mb-2 text-white bg-dark p-2 rounded">User
			list</h4>
		<hr />
		<a href="<%=request.getContextPath()%>/new" class="btn btn-info mb-2">Add
			user</a>

		<table class="table table-dark table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>EMAIL</th>
					<th>ADDRESS</th>
					<th>COUNTRY</th>
					<th>ACTION</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.name}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.address}" /></td>
						<td><c:out value="${user.country}" /></td>
						<td><a href="<%=request.getContextPath()%>/edit?id=<c:out value = "${user.id}"/>" class="btn btn-success">edit</a> 
							 <a href="<%=request.getContextPath()%>/delete?id=<c:out value = "${user.id}"/>" class="btn btn-danger">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>