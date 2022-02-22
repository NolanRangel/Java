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
            <a class="navbar-brand px-3 mr-5 fs-1 text-warning" href="/books">Welcome ${userName}!</a>
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
                        <a class="nav-link" href="/books">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>


	<div class="container">
		<div  class="card w-25 mx-auto mt-5 d-flex rounded shadow-lg p-3">
			<div class="card-header border-3 border-bottom border-dark">
				<h2>${book.title}</h2>
			</div>
    		<div class="card-body rounded-3 p-3 mt-3 gap-3">
        		<c:choose>
            		<c:when test="${book.user.id == userId}" >
                		<p class="fs-4"><span class="card-title text-danger">You</span> read,</p>
            		</c:when>
            		<c:otherwise >
                		<p><span class="card-title text-warning">${book.user.userName}</span> read,</p>
            		</c:otherwise>
        		</c:choose>
        			<p><span class="card-title text-info fs-4">${book.title}</span> by <span class="text-success fs-4">${book.author}</span></p>
        		<c:choose>
            		<c:when test="${book.user.id == userId}" >
                		<p class="card-text">Here are your thoughts...</p>
            		</c:when>
            		<c:otherwise >
                		<p class="card-text ">Here are ${book.user.userName}'s thoughts...</p>
            		</c:otherwise>
        		</c:choose>
        		<p class="card-text fs-4">${book.description}</p>
        		<c:choose>
            		<c:when test="${book.user.id == userId}" >
                		<a href="/books/${book.id}/edit" class="btn btn-warning mt-4">Edit</a>
            		</c:when>
        		</c:choose>
        		<c:choose>
            		<c:when test="${book.user.id == userId}" >
						<form action="/books/${book.id }/delete" method="post">
							<input type="hidden" name="_method" value="delete" />
							<button  class="btn btn-danger"> Delete </button>
						</form>						
            		</c:when>
        		</c:choose>
    		</div>
		</div>
	</div>


</body>

</html>