 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>

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
            <a class="navbar-brand px-3 mr-5 fs-1 text-warning" href="/shows">Welcome ${userName}</a>
            <a class="navbar-brand px-5 fs-1 mx-5"> </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse d-flex justify-content-end " id="navbarNavDropdown">
                <ul class="navbar-nav px-5">
                    <li class="nav-item">
                        <a class="nav-link" href="/shows">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>


	<div class="container">
		<div  class="card w-50 mx-auto mt-5 d-flex  shadow p-3">
			<div class="card-header border-3 border-bottom border-dark">
				<h2>The Wire</h2>
			</div>
    		<div class="card-body rounded-3 p-3 mt-3 gap-3">
                		<p class="crad-title fs-4 border-bottom">Posted By: ${show.user.userName}</p>

                		<p class="card-title border-bottom">Network: ${show.network}</p>

        				<p class="card-text mt-3 border-bottom">${show.description}</p>


                		<a href="/shows/${show.id}/edit" class="btn btn-warning mt-4">Edit</a>

 
    		</div>
		</div>
	</div>


</body>
</html>