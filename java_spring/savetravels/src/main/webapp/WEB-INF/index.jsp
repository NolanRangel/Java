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
            <a class="navbar-brand px-3 mr-5 fs-1 text-warning" href="/expenses">Expense Tracker</a>
            <a class="navbar-brand px-5 fs-1 mx-5"> </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse d-flex justify-content-end " id="navbarNavDropdown">
                <ul class="navbar-nav px-5">
                    <li class="nav-item">
                        <a class="nav-link" href="/expenses">Home</a>
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
		    		<th scope="col">Id</th>
		      		<th scope="col">Expense</th>
		      		<th scope="col">Vendor</th>
		      		<th scope="col">Amount</th>
		      		<th scope="col">Edit</th>
		      		<th scope="col">Delete</th>
		    	</tr>
		  	</thead>
		  	<tbody >
		     	<c:forEach var="expense" items="${expenses}">
		    		<tr class="align-items-center">
						<td>${expense.id}</td>
						<td><a href='/expenses/${expense.id}'>${expense.name}</a></td>
						<td>${expense.vendor}</td>
						<td>$ ${expense.amount}</td>
						<td ><a href='/expenses/edit/${expense.id}' class="text-decoration-none text-warning ">Edit</a></td>
						<td> 
							<form action="/expenses/delete/${expense.id }" method="post">
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
	<h2 class="text-center py-2 ">Add an Expense!</h2>
		<form:form action="/expenses" method="post" modelAttribute="expense" class=" p-3 mx-auto border shadow" >
		
	
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
				<input type="submit" value="Submit" class="btn btn-success mt-3"/>		
			</div>
			
		</form:form>

	</div>

</div>



</body>

</html>