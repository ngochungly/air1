<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Formulaire de saisie</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<style>
		body{
		    font-size: 16px;
		    margin: 0 auto;
		    max-width: 500px;
		}
	</style>
</head>
<body>
	<br>
	<c:if test="${requestScope.message != null}">
		<div class="alert alert-warning" role="alert">
			${requestScope.message}
		</div>
	</c:if>
	
	<form role="form" method="post" action="./AnnonceAdd" name="annonceAddForm" class="well" style="background-color: #cceeff;padding: 10px 10px 10px 10px;">
		<div class="form-group">
			<label for="title"><b>Title</b></label>
			<input type="text" class="form-control" name="title" required id="title" placeholder="Enter title" value="${annonce.title}">
		</div>
		<div class="form-group">
			<label for="description"><b>Description</b></label>
			<input type="textarea" class="form-control" name="description" required id="description" placeholder="Description" value="${annonce.description}">
		</div>
		<div class="form-group">
			<label for="adress"><b>Adress</b></label>
			<input type="text" class="form-control" name="adress" required id="adress" placeholder="Enter adress" value="${annonce.adress}">
		</div>
		<div class="form-group">
			<label for="mail"><b>Mail</b></label>
			<input type="mail" class="form-control" name="mail" id="mail" placeholder="Enter mail" value="${annonce.mail}">
		</div>
		<br>
		<button type="submit" class="btn btn-primary">Save</button>
	</form>
	
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>
</html>