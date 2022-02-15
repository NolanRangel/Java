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

    <!-- css -->
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>


<body>

	<h1 class="text-center my-5">Here's Your Omikuji!!</h1>
	
	<div class=" w-50 d-flex flex-column align-items-center mt-3 p-5 border mx-auto shadow-lg">
	
		<p>In <span><c:out value="${number}"></c:out></span> years,
		 	you will live in <span><c:out value="${city}"></c:out></span> with
		 	<span><c:out value="${name}"></c:out></span> as your roommate, and do
		 	<span><c:out value="${hobby}"></c:out></span> for a living. The next time you see a <span><c:out value="${creature}"></c:out></span>, you will have good luck.
		 	Also, <span><c:out value="${textArea}"></c:out></span>
		 </p>
	
	 <input type="button" onclick="location.href='/omikuji'" value="Go back" class="btn btn-success mt-5">
	</div>
	 

</body>
</html>