<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>

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

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
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
                        <a class="nav-link" href="/books">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

	<h1 class="text-center my-5">New Book!</h1>
	
	<form:form action="/books" method="post" modelAttribute="book" class="rounded w-50 p-3 mx-auto border shadow-lg" >
	

		<div class="form-group my-4">
        	<!-- <form:label path="title" class="form-label">Title</form:label> -->
        	<form:errors path="title" class="form-label text-danger"/>
        	<form:input path="title" class="form-control" placeholder="Add a Title.."/>
    	</div>
    	<div class="form-group my-4">
        	<!-- <form:label path="description" class="form-label">Description</form:label> -->
        	<form:errors path="description" class="form-label text-danger"/>
        	<form:textarea path="description" class="form-control" placeholder="Add a Description.."/>
    	</div>
    	<div class="form-group my-4">
        	<!-- <form:label path="language" class="form-label">Language</form:label> -->
        	<form:errors path="language" class="form-label text-danger" />
        	<form:input path="language" class="form-control" placeholder="Language Written?"/>
    	</div>
    	<div class="form-group my-4">
        	<!-- <form:label path="numberOfPages" class="form-label">Pages</form:label> -->
        	<form:errors path="numberOfPages" class="form-label text-danger"/>     
        	<form:input type="number" path="numberOfPages" class="form-control" placeholder="Number of Pages?"/>
    	</div>    

		<div>
			<input type="submit" value="Submit" class="btn btn-primary mt-3"/>		
		</div>
		
	</form:form>


</body>

</html>