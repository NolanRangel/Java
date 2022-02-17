<%@ page isErrorPage="true" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

<div class="container  my-5 py-5" >
	<div class="d-flex justify-content-end  ">
		<form action="/languages/delete/${language.id }" method="post">
			<input type="hidden" name="_method" value="delete" />
			<input type="submit" value="Delete" class="btn btn-danger" />
		</form>	
	</div>
	<div class="col-8 p-5 border  shadow rounded mx-auto " >
	<h2 class="text-center p-1 mb-4">Edit!</h2>
		<form:form action="/languages/edit/${language.id}" method="post" modelAttribute="language" class=" w-50 p-3 mx-auto border shadow" >
		 <input type="hidden" name="_method" value="put" /> 
	
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
	        	<form:input type="number" path="version" step="0.01" class="form-control" placeholder="Enter Version.."/>
	    	</div>    
	
			
				<input type="submit" value="Save" class="btn btn-warning mt-3"/>		
					
		</form:form>
			


	</div>
</div>


</body>

</html>