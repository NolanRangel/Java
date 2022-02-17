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
<!-- css -->
<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>


<body>


    <!-- NAVBAR -->

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid me-auto ">
            <a class="navbar-brand px-3 mr-5 fs-1 text-warning" href="/books">Book Club</a>
            <a class="navbar-brand px-5 fs-1 mx-5"> </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse d-flex justify-content-end " id="navbarNavDropdown">
                <ul class="navbar-nav px-5">
                    <li class="nav-item">
                        <a class="nav-link" href="/books/new">Add a Book</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

<h2 class="text-center my-5">All Books</h2>

<div class="container " >
	<div class="container p-3 border  shadow-lg rounded" style="width: fit-content">
		<table class="table table-striped mx-auto m-2">
		  	<thead>
		    	<tr>
		    		<th scope="col">Id</th>
		      		<th scope="col">Title</th>
		      		<th scope="col">Language</th>
		      		<th scope="col"># Pages</th>
		    	</tr>
		  	</thead>
		  	<tbody >
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
	</div>
	<!--
	<button class=" mx-auto btn btn-primary mt-3 ">
		<a href="/books/new" class="text-light text-decoration-none">Create a Book</a>
	</button>
	-->
	<!-- <button onclick="location.href='/books/new'" ></button> -->
	
</div>

</body>
</html>




