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
            <a class="navbar-brand px-3 mr-5 fs-1 text-warning" href="/languages">Languages!</a>
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
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

<div class="container my-5 py-5">
	<div class="container p-4 border  shadow rounded  w-50">
	<h2 class="text-center mb-5"></h2>
		<div  class="card mx-auto   rounded shadow">
			<div class="card-header ">
				<h2>${language.name}</h2>
			</div>
			<div  class="card-body">
				<p class="card-text">Vendor: ${language.creator}</p>
				<p class="card-text">Amount: ${language.version}</p>	
			</div>
			<div class="d-flex align-items-center justify-content-between">
				<a href='/languages/edit/${language.id}' class="text-decoration-none text-dark btn btn-warning m-3 w-25">Edit</a>
				<form action="/languages/delete/${language.id }" method="post">
					<input type="hidden" name="_method" value="delete" />
					<button  class="btn btn-danger text-dark mx-3"> Delete </button>
				</form>				
			</div>

		</div>
	
	</div>

</div>

</body>
</html>