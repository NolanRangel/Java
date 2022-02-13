<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>

	<h1 class="text-center mt-5">Welcome User!</h1>
	<input type="button" onclick="location.href='/count'" value="Count" class="text-center">
	<input type="button" onclick="location.href='/reset'" value="Reset" class="text-center">
</body>
</html>