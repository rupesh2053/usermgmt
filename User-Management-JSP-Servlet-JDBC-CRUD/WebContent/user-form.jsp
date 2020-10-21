<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file = "navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User management application</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-5 mx-auto">
				<div class="card">
					<div class="card-body">
					
						<c:if test="${user == null }">
							<form action="<%=request.getContextPath()%>/insert" method="post">
							<h4 class="text-center bg-dark text-white p-2 rounded">Insert user</h4>
						</c:if>
						
						<c:if test="${user != null }">
							<form action="<%=request.getContextPath()%>/update" method="post">
							<h4 class="text-center bg-dark text-white p-2 rounded">Update user</h4>
						</c:if>
						
							<input type="hidden" name = "id" value ="<c:out value = '${user.id}'/>"/>
							
							<div class="form-group">
								<input type="text" name = "name" class="form-control" value ="<c:out value = '${user.name}'/>" placeholder="name">
							</div>
							
							<div class="form-group">
								<input type="text" name = "email" class="form-control" value ="<c:out value = '${user.email}'/>" placeholder="email">
							</div>
							
							<div class="form-group">
								<input type="text" name = "address" class="form-control" value ="<c:out value = '${user.address}'/>" placeholder="address">
							</div>
							
							<div class="form-group">
								<input type="text" name = "country" class="form-control" value ="<c:out value = '${user.country}'/>" placeholder="country">
							</div>
							
							<c:if test="${user == null }">
								<button type="submit" class="btn btn-primary w-100">Register</button>
							</c:if>
						
						<c:if test="${user != null }">
							<button type="submit" class="btn btn-primary w-100">Update</button>
						</c:if>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>