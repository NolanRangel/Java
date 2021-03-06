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
                        <a class="nav-link" href="/books/new">Add a Book</a>
                    </li>
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


	<div class="container">
		<div  class="card w-25 mx-auto mt-5 d-flex rounded shadow-lg">
			<div class="card-header ">
				<h2>${book.title}</h2>
			</div>
			<div  class="card-body">
				<p class="card-text">Description: ${book.description}</p>
				<p class="card-text">Language: ${book.language}</p>
				<p class="card-text">Number of Pages: ${book.numberOfPages}</p>		
			</div>
		</div>
	
	</div>

</body>
</html>