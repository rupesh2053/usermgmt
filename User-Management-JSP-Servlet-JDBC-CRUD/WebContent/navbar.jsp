<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
	.navbar{
		background: black;
	}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg">
  <a class="navbar-brand text-white" href="<%= request.getContextPath() %>/list">User Management</a>
  <div class="collapse navbar-collapse">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link text-white" href="<%= request.getContextPath() %>/new">Add user</a>
      </li>
      <li class="nav-item">
        <a class="nav-link text-white" href="<%= request.getContextPath() %>/list">User lists</a>
      </li>
      </ul>
  </div>
</nav>