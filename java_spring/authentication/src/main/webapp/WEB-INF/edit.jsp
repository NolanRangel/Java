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
            <a class="navbar-brand px-3 mr-5 fs-1 text-warning" href="/books">Welcome ${userName}</a>
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
						<a class="nav-link" href="/books/market">Book Market</a>
					</li>
                    <li class="nav-item">
                        <a class="nav-link" href="/books">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
	

		<div class="col-6 p-3 border  shadow mx-auto my-5 py-5" >
			<form:form action="/books/${id}/edit" method="post" modelAttribute="book" class="rounded w-50 p-3 mx-auto border shadow-lg" >
			<input type="hidden" name="_method" value="put" />
		
				<div class="form-group my-4">
	
		        	<form:errors path="title" class="form-label text-danger"/>
		        	<form:input path="title" class="form-control" placeholder="Add a Title.."/>
		    	</div>
		    	
		    	<div class="form-group my-4">
	
		        	<form:errors path="description" class="form-label text-danger"/>
		        	<form:textarea path="description" class="form-control" placeholder="Add a Description.."/>
		    	</div>
	
		    	<div class="form-group my-4">
	
		        	<form:errors path="author" class="form-label text-danger"/>     
		        	<form:input  path="author" class="form-control" placeholder="Enter an Author.."/>
		    	</div>    
		
				<div>
					<input type="submit" value="Edit" class="btn btn-warning mt-3"/>		
				</div>
				
			</form:form>

	</div>


</body>

</html>