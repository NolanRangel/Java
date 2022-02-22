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


			<!-- NAVBAR -->

			<nav class="navbar navbar-expand-lg navbar-dark bg-dark p-4">
				<div class="container-fluid me-auto ">
					<a class="navbar-brand px-3 mr-5 fs-1 text-warning" href="/books">Welcome ${userName}!</a>
					<a class="navbar-brand px-5 fs-1 mx-5"> </a>
					<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
						data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false"
						aria-label="Toggle navigation">
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
								<a class="nav-link" href="/logout">Logout</a>
							</li>
						</ul>
					</div>
				</div>
			</nav>

			<h2 class="text-center my-5">All Books</h2>

			<div class="container ">
				<div class="container p-3 border  shadow" style="width: fit-content">
					<table class="table table-striped mx-auto m-2">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Title</th>
								<th scope="col">Author</th>
								<th scope="col">Added By</th>
								<th scope="col">Actions</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="book" items="${books}">
								<tr class="py-2">
									<td> ${book.id}</td>
									<td><a href='/books/${book.id}'>${book.title}</a></td>
									<td>${book.author}</td>
									<td>${book.user.userName}</td>
									<c:choose>
										<c:when test="${book.user.id == userId}">
											<td class="d-flex align-items-center gap-2">
												<a href="/books/${book.id}/edit" class="btn btn-warning">Edit</a>
												|
												<form action="/books/${book.id }/delete" method="post">
													<input type="hidden" name="_method" value="delete" />
													<button class="btn btn-danger"> Delete </button>
												</form>
											</td>
										</c:when>
									</c:choose>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>






			</html>