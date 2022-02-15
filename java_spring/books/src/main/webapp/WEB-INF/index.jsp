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

<h2 class="text-center mt-5">All Books</h2>
	
<table class="table table-striped mx-auto w-50 mt-5 p-5 border shadow-lg rounded">
  	<thead>
    	<tr>
    		<th scope="col">Id</th>
      		<th scope="col">Title</th>
      		<th scope="col">Language</th>
      		<th scope="col"># Pages</th>
    	</tr>
  	</thead>
  	<tbody>
     	<c:forEach var="book" items="${books}">
    		<tr>
				<td>${book.id}</td>
				<td><a href='/books/${book.id}'>${book.title}</a></td>
				<td>${book.language}</td>
				<td>${book.numberOfPages}</td>
    		</tr>
		</c:forEach>
  	</tbody>
</table>

</body>
</html>