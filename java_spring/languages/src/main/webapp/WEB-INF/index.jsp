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




</head>

<body>


    <!-- NAVBAR -->

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
        <div class="container-fluid me-auto ">
            <a class="navbar-brand px-3 mr-5 fs-1 text-warning" href="/languages">Languages</a>
            <a class="navbar-brand px-5 fs-1 mx-5"> </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse d-flex justify-content-end " id="navbarNavDropdown">
                <ul class="navbar-nav px-5">
                    <li class="nav-item">
                        <a class="nav-link" href="/languages">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

	
	
<div class="container d-flex w-75 justify-content-around my-5 py-4" >
	<div class="col-1 p-3 border  shadow rounded my-5 " style="width: fit-content">
	<h2 class="text-center py-2">Expenses</h2>
		<table class="table  mx-auto m-3 border  shadow">
		  	<thead>
		    	<tr>
		    		<th scope="col">Name</th>
		      		<th scope="col">Creator</th>
		      		<th scope="col">Version</th>
		      		<th scope="col">Edit</th>
		      		<th scope="col">Delete</th>
		    	</tr>
		  	</thead>
		  	<tbody >
		     	<c:forEach var="language" items="${allLanguages}">
		    		<tr class="align-items-center">
						<td><a href='/languages/${language.id}'>${language.name}</a></td>
						<td>${language.creator}</td>
						<td>$ ${language.version}</td>
						<td ><a href='/languages/edit/${language.id}' class="text-decoration-none text-warning ">Edit</a></td>
						<td> 
							<form action="/languages/delete/${language.id }" method="post">
								<input type="hidden" name="_method" value="delete" />
								<button  class="btn btn-danger"> Delete </button>
							</form>						
						</td>
		    		</tr>
				</c:forEach>
		  	</tbody>
		</table>
	</div>
	
	<div class="col-6 p-3 border  shadow rounded my-5" >
	<h2 class="text-center py-2 ">Add a Language!</h2>
		<form:form action="/languages" method="post" modelAttribute="language" class=" p-3 mx-auto border shadow" >
		
	
			<div class="form-group my-4">

	        	<form:errors path="name" class="form-label text-danger"/>
	        	<form:input path="name" class="form-control" placeholder="Add a Name.."/>
	    	</div>
	    	
	    	<div class="form-group my-4">

	        	<form:errors path="creator" class="form-label text-danger"/>
	        	<form:textarea path="creator" class="form-control" placeholder="Add a Creator.."/>
	    	</div>

	    	<div class="form-group my-4">

	        	<form:errors path="version" class="form-label text-danger"/>     
	        	<form:input type="number" path="version" step="0.01" class="form-control" placeholder="Enter a Version.."/>
	    	</div>    
	
			<div>
				<input type="submit" value="Submit" class="btn btn-success mt-3"/>		
			</div>
			
		</form:form>

	</div>

</div>



</body>

</html>