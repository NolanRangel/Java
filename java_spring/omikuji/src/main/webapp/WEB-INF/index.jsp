<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <!-- bootstrap -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>


<body>
	<h1 class="text-center mt-5">Send an Omikuji!</h1>
	<form action="/form/process" method="post" class="rounded w-50 p-3 mx-auto border shadow-lg">
		<div class="form-group">
			<label for="number" class="form-label">Pick any number from 5 to 25</label>
			<input type="number" class="form-control" id="number" name="number">		
		</div>
		
		<div class="form-group">
			<label for="city" class="form-label">Enter the name of any city</label>
			<input type="text" class="form-control" id="city" name="city">		
		</div>
		<div class="form-group">
			<label for="name" class="form-label">Enter the name of any real person</label>
			<input type="text" class="form-control" id="name" name="name">
		</div>
		
		<div class="form-group">
			<label for="hobby" class="form-label">Enter a professional endeavor or hobby</label>
			<input type="text" class="form-control" id="hobby" name="hobby">			
		</div>
		
		<div class="form-group">
			<label for="creature" class="form-label">Enter a type of living thing</label>
			<input type="text" class="form-control" id="creature" name="creature">		
		</div>
		<div class="form-group">
			<label for="textArea" class="form-label">Say something nice to someone.</label>
			<textarea id="textArea" name="textArea" rows="5" cols="20" class="form-control"></textarea>		
		</div>
		
		
		<input type="submit" value="Send" class="btn btn-primary mt-3"/>
	</form>

</body>
</html>