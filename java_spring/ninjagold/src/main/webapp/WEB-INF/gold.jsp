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
	<div class="w-25 mt-5 d-flex flex-column mx-auto my-3">
		<h2 >Your Gold: </h2>
		<textarea id="textArea" name="textArea" rows="1" cols="2" class="form-control">${gold}</textarea>	
	</div>
	
	<div class="d-flex justify-content-center gap-5 mt-5">
		<form action="/gold" method="post">
			<div class="border shadow-lg p-3">
				<h3>Farm</h3>
				<p>(earns 10-20 gold)</p>
				<input type="hidden" name="goldValue" value="farm" />
				<input type="submit" value="Find Gold!" class="btn btn-success mt-3"/>
			</div>
		</form>
		
		<form action="/gold" method="post">
			<div class="border shadow-lg p-3">
				<h3>Cave</h3>
				<p>(earns 5-10 gold)</p>
				<input type="hidden" name="goldValue" value="cave" />
				<input type="submit" value="Find Gold!" class="btn btn-primary mt-3"/>
			</div>
		</form>
		
		<form action="/gold" method="post">
			<div class="border shadow-lg p-3">
				<h3>House</h3>
				<p>(earns 2-5 gold)</p>
				<input type="hidden" name="goldValue" value="house" />
				<input type="submit" value="Find Gold!" class="btn btn-info mt-3"/>
			</div>
		</form>
		
		<form action="/gold" method="post">
			<div class="border shadow-lg p-3">
				<h3>Casino!</h3>
				<p>(earns 0-50 gold)</p>
				<input type="hidden" name="goldValue" value="casino" />
				<input type="submit" value="Find Gold!" class="btn btn-danger mt-3"/>
			</div>
		</form>
	</div>
	
	<div class="w-75 mx-auto text-center mt-5">
		<h3 >Activities: </h3>
		<textarea id="textArea" name="textArea" rows="5" cols="20" class="form-control">
			<c:forEach var="outcome" items="${item}">
				<c:out value="${outcome}"></c:out>
			</c:forEach>
		</textarea>	
	
	</div>

</body>
</html>