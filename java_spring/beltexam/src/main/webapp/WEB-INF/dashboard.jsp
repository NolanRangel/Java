<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
			<!-- NAVBAR -->
			

			<nav class="navbar navbar-expand-lg navbar-dark bg-dark p-4">
				<div class="container-fluid me-auto ">
					<a class="navbar-brand px-3 mr-5 fs-1 text-warning" href="#">Welcome ${userName}</a>
					<a class="navbar-brand px-5 fs-1 mx-5"> </a>
					<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
						data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse d-flex justify-content-end " id="navbarNavDropdown">
						<ul class="navbar-nav px-5">
							<li class="nav-item">
								<a class="nav-link" href="/shows/new">Add a TV Show</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="/logout">Logout</a>
							</li>
						</ul>
					</div>
				</div>
			</nav>

			<h2 class="text-center my-5">TV Shows</h2>
			
			<div class="container mb-5 ">
				<div class="container p-3 border  shadow" style="width: fit-content">
					<table class="table table-striped mx-auto m-2">
						<thead>
							<tr>
								<th scope="col">Show</th>
								<th scope="col">Network</th>


							</tr>
						</thead>
						<tbody>
							<c:forEach var="show" items="${shows}">
								<tr class="py-2">
									<td><a href='/shows/${show.id}'>${show.title}</a></td>
									<td>${show.network}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="d-flex justify-content-center mt-3">
					<div>
						<a class="btn btn-primary mx-auto" href="/shows/new">Add a Show</a>		
					</div>	
				</div>
			</div>
			

	


	</body>
</html>