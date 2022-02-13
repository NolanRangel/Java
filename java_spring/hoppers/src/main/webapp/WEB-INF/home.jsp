<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hoppers Receipt</title>
<!-- bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>

<body>


	
	<div class="card text-center w-50 border-1 shadow-lg mt-5">
  		<div class="card-header ">
    		<h1>Customer Name: ${name}</h1>
  		</div>
  		
  		<div class="card-body">
    		<h5 class="card-title">Item name: ${itemName}</h5>
    		<p class="card-text">Price: <c:out value="${price}" /></p>
    		<p class="card-text">Description: <c:out value="${description}" /></p>
    		<p class="card-text">Vendor: <c:out value="${vendor}" /></p>
  		</div>

	</div>

</body>
</html>