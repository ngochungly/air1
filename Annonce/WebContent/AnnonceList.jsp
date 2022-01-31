<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Annonce List</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<style>
		body{
		    font-size: 16px;
		    margin: 0 auto;
		    max-width: 600px;
		}
	</style>
</head>
<body>
	<br>
	<h1>Annonce list (${fn:length(annonceList)})</h1>
	
	<c:if test="${ requestScope.message != null }">
		<div class="alert alert-warning" role="alert">
			${ requestScope.message }
		</div>
	</c:if>

	<c:if test="${ fn:length(annonceList) eq 0 }">
		<div class="alert alert-warning" role="alert">
			No annonce.
			<a href="./AnnonceAdd">
				Créer un.
			</a>
		</div>
	</c:if>

	<div class="list-group">
		<c:forEach var="annonce" items="${annonceList}">
			<a href="./AnnonceDetail?title=${annonce.title}" class="list-group-item" title="${annonce.description}">
					${ annonce.title } (${ annonce.mail })
					<div class="pull-right">
						<fmt:formatDate type="date" value="${annonce.date}"/>
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					</div>
			</a>
		</c:forEach>
	</div>
	<br>
	<form action="./AnnonceAdd">
		<button type="submit" class="btn btn-success">+ Add an item</button>
	</form>
	
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	
</body>
</html>