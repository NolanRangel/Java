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

<!-- css -->
<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>

<body>
	<div class="col-6 p-3 border  shadow-lg rounded" >
		<form:form action="/expenses/edit/{id}" method="post" modelAttribute="expense" class="rounded w-50 p-3 mx-auto border shadow-lg" >
		<input type="hidden" name="_method" value="put" />
	
			<div class="form-group my-4">

	        	<form:errors path="name" class="form-label text-danger"/>
	        	<form:input path="name" class="form-control" placeholder="Add an Expense.."/>
	    	</div>
	    	
	    	<div class="form-group my-4">

	        	<form:errors path="vendor" class="form-label text-danger"/>
	        	<form:textarea path="vendor" class="form-control" placeholder="Add a Vendor.."/>
	    	</div>

	    	<div class="form-group my-4">

	        	<form:errors path="amount" class="form-label text-danger"/>     
	        	<form:input type="number" path="amount" step="0.01" class="form-control" placeholder="Enter Amount.."/>
	    	</div>    
	
			<div>
				<input type="submit" value="Edit" class="btn btn-primary mt-3"/>		
			</div>
			
		</form:form>

	</div>


</body>

</html>