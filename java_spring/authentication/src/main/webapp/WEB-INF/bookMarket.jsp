<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
			<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
				<%@ page isErrorPage="true" %>

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
								<a class="navbar-brand px-3 mr-5 fs-1 text-warning" href="/books">Welcome
									${userName}</a>
								<a class="navbar-brand px-5  mx-5">The Book Broker!</a>
								<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
									data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
									aria-expanded="false" aria-label="Toggle navigation">
									<span class="navbar-toggler-icon"></span>
								</button>

								<div class="collapse navbar-collapse d-flex justify-content-end "
									id="navbarNavDropdown">
									<ul class="navbar-nav px-5">
										<li class="nav-item">
											<a class="nav-link" href="/books/new">Add a Book</a>
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




						<div class="container d-flex  justify-content-around my-5 py-4 ">
							<div class="col-4 p-3 border  shadow rounded my-5" style="width: fit-content">
								<h2 class="text-center py-2">Available Books To Borrow</h2>
								<table class="table table-striped mx-auto m-2">
									<thead>
										<tr>
											<th scope="col">Id</th>
											<th scope="col">Title</th>
											<th scope="col">Author</th>
											<th scope="col">Owner</th>
											<th scope="col">Action</th>
											<th scope="col"></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="book" items="${books}">
											<c:choose>
												<c:when
													test="${book.user.id != user.id && book.borrower.userName != user.userName}">
													<tr>
														<td> ${book.id}</td>
														<td><a href='/books/${book.id}'>${book.title}</a></td>
														<td>${book.author}</td>
														<td>${book.user.userName}</td>
														<c:choose>
															<c:when test="${book.user.id != userId}">
																<td>
																	<form action="/books/checkout" method="post">
																		<input type="hidden" name="_method"
																			value="put" />
																		<input type="hidden" name="bookId"
																			value="${book.id}" />
																		<input type="submit" value="Check Out"
																			class="btn btn-primary py-0 px-1" />
																	</form>
																</td>
															</c:when>
														</c:choose>
													</tr>
												</c:when>
											</c:choose>
										</c:forEach>
									</tbody>
								</table>
							</div>

							<div class="col-5 p-3 border  shadow rounded my-5">
								<h2 class="text-center py-2 ">Books I'm Borrowing</h2>
								<table class="table table-striped mx-auto m-2">
									<thead>
										<tr>
											<th scope="col">Id</th>
											<th scope="col">Title</th>
											<th scope="col">Author</th>
											<th scope="col">Owner</th>
											<th scope="col">Action</th>
											<th scope="col"></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="book" items="${books}">
											<c:choose>
												<c:when test="${book.borrower.userName == user.userName}">
													<tr>
														<td> ${book.id}</td>
														<td><a href='/books/${book.id}'>${book.title}</a></td>
														<td>${book.author}</td>
														<td>${book.user.userName}</td>
														<c:choose>
															<c:when test="${book.user.id != userId}">
																<td>
																	<form action="/books/return" method="post">
																		<input type="hidden" name="_method"
																			value="put" />
																		<input type="hidden" name="bookId"
																			value="${book.id}" />
																		<input type="submit" value="Return"
																			class="btn btn-primary py-0 px-1" />
																	</form>
																</td>
															</c:when>
														</c:choose>
													</tr>
												</c:when>
											</c:choose>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>



					</body>

					</html>