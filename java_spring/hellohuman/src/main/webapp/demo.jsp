<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Hello World</h1>
	<% for (int i = 0; i < 5; i++) {%>
		<h1><%= i %></h1>
		<% } %>
		<h3>The Time is: <%= new Date() %></h3>

</body>
</html>