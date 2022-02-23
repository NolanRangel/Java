<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>

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

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark p-4">
        <div class="container-fluid me-auto ">
            <a class="navbar-brand px-3 mr-5 fs-1 text-warning" href="/shows">Welcome ${userName}</a>
            <a class="navbar-brand px-5 mx-5">Create a New TV Show</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse d-flex justify-content-end " id="navbarNavDropdown">
                <ul class="navbar-nav px-5">
                    <li class="nav-item">
                        <a class="nav-link" href="/shows">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

	<h1 class="text-center my-5">New Show!</h1>
	
	<form:form action="/shows" method="post" modelAttribute="show" class="rounded w-25 p-3 mx-auto border shadow" >
	


    	<div class="form-floating my-2">
			<form:input path="title" class="form-control" id="floatingInput" placeholder="Add a Show" />
			<label for="floatingInput">Title</label>
			<form:errors path="title" class="form-label alert-danger" />
		</div>
		
		<div class="form-floating my-2">

        	<form:input path="network" class="form-control" placeholder="Add an Network"/>
        	<label for="floatingInput">Network</label>
        	<form:errors path="network" class="form-label text-danger" />
    	</div>
    	
    	<div class="form-floating my-2">

        	<form:textarea path="description"  class="form-control" placeholder="Add a Description"/>
        	<label for="floatingInput">Description</label>
        	<form:errors path="description" class="form-label text-danger"/>
    	</div>
    	  

		<div>
			<input type="submit" value="Submit" class="btn btn-primary mt-3"/>		
		</div>
		
	</form:form>
	<div class="d-flex justify-content-center mt-3">
		<div>
			<a class="btn btn-primary mx-auto" href="/shows">Cancel</a>		
		</div>	
	</div>


</body>

</html>