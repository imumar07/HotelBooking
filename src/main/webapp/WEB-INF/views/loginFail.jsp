<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<meta  charset="UTF-8">
<title>First JSP</title>
<style>
	body{
		background-color:aqua;
		height:100vh;
		display:flex;
		flex-direction:row;
		justify-content:center;
		align-items:center;
		border:2px solid green;
	}
	.arrange{
		height:fit-content;
		background-color:#ffffff;
		padding:10px;
		border-radius:10px;
	}
	form{
		
	}
</style>
</head>
<body>
<div class="arrange">
<form action="loginForm" method="post">
<h1>User not found</h1>
<p>Create account and login</p>
<div class="text-center m-2 mt-4">
<button type="submit" class="btn btn-success">Login in</button>
</div>
</form>
</div>
</body>
</html>