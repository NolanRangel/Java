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

		<h2 class="text-center mt-5">You have visited, http://localhost:8080, ${count} times!</h2>
		<input type="button" onclick="location.href='/counttwo'" value="Go to Add 2">
</body>
</html>