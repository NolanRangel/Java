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

					<nav class="navbar navbar-expand-lg navbar-dark bg-dark p-4">
						<div class="container-fluid me-auto ">
							<a class="navbar-brand px-3 mr-5 fs-1 text-warning" href="#">TV Shows Database</a>
							<a class="navbar-brand px-5  mx-5"></a>
							<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
								data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
								aria-expanded="false" aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>

							<div class="collapse navbar-collapse d-flex justify-content-end " id="navbarNavDropdown">
								<ul class="navbar-nav px-5">

								</ul>
							</div>
						</div>
					</nav>


					<div class="container d-flex w-75 justify-content-around my-5 py-4">
						<div class="col-4 p-3 border  shadow rounded my-5 ">

							<h2 class="text-center py-2">Register</h2>

							<form:form action="/register" method="post" modelAttribute="newUser" class="py-2">
								<div class="form-floating my-2">
									<form:input path="userName" class="form-control" 
										placeholder="Full Name" />
									<label for="floatingInput">Full Name</label>
									<form:errors path="userName" class="form-label alert-danger" />
								</div>

								<div class="form-floating my-2">
									<form:input path="email" type="email" class="form-control" 
										placeholder="name@example.com" />
									<label for="floatingInput">Email address</label>
									<form:errors path="email" class="form-label alert-danger" />
								</div>
								<div class="form-floating my-2">
									<form:password path="password" class="form-control" 
										placeholder="Password" />
									<label for="floatingPassword">Password</label>
									<form:errors path="password" class="form-label alert-danger" />
								</div>

								<div class="form-floating my-2">
									<form:password path="confirm" class="form-control" 
										placeholder="Confirm Password" />
									<label for="floatingPassword">Confirm Password</label>
									<form:errors path="confirm" class="form-label alert-danger" />
								</div>

								<input type="submit" value="Register" class="btn btn-primary mt-3" />

							</form:form>
						</div>

						<div class="col-4 p-3 border  shadow rounded my-5">
							<h2 class="text-center py-2 ">Login</h2>

							<form:form action="/login" method="post" modelAttribute="newLogin" class="py-2">

								<div class="form-floating my-2">
									<form:input path="email" type="email" class="form-control" id="floatingInput"
										placeholder="name@example.com" />
									<label for="floatingInput">Email address</label>
									<form:errors path="email" class="form-label alert-danger" />
								</div>
								<div class="form-floating ">
									<form:input path="password" type="password" class="form-control"
										id="floatingPassword" placeholder="Password" />
									<label for="floatingPassword">Password</label>
									<form:errors path="password" class="form-label alert-danger" />
								</div>

								<input type="submit" value="Login" class="btn btn-success mt-3" />

							</form:form>

						</div>



					</div>

					</html>