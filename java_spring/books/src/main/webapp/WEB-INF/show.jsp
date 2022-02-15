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

	<div class="container">
		<div  class="card w-25 mx-auto mt-5 d-flex rounded shadow-lg">
			<div class="card-header ">
				<h2>${book.title}</h2>
			</div>
			<div  class="card-body">
				<p class="card-text">Description: ${book.description}</p>
				<p class="card-text">Language: ${book.language}</p>
				<p class="card-text">Number of Pages: ${book.numberOfPages}</p>		
			</div>
		</div>
	
	</div>

</body>
</html>