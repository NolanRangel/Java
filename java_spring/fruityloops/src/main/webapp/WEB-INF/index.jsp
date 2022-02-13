<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- c: allows for variable injection -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="IUTF-8">
<title>Insert title here</title>


</head>
<body>

<h2 class="text-center mt-5">Fruit Store</h2>
	
<table class="table table-striped w-50 mt-5 p-5 border shadow-lg rounded">
  	<thead>
    	<tr>
      		<th scope="col">Name</th>
      		<th scope="col">Price</th>
    	</tr>
  	</thead>
  	<tbody>
     	<c:forEach var="fruit" items="${fruits}">
    		<tr>
				<td>${fruit.name}</td>
				<td>${fruit.price}</td>
    		</tr>
		</c:forEach>
  	</tbody>
</table>

</body>
</html>