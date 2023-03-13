<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>La liste des produits</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</head>
<body>
	<h1>La liste des produits </h1>
	
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Nom</th>
					<th scope="col">Références</th>
					<th scope="col">Prix</th>
					<th scope="col">Poids</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="p" items="${ listeP }">
				<tr>
					<th scope="row"><a href="P?id=${ p.getId() }">>${ p.getId() }</th></a>
					<td>${ p.getNom() }</td>
					<td>${ p.getReference() }</td>
					<td>${ p.getPrix() }</td>
					<td>${ p.getPoids() }</td>
					<td><a href="supprimer?id=${ p.getId() } " ><button type="button" class="btn btn-outline-danger">Supprimer</button></a></td>
				</tr>
				
				</c:forEach>		
			</tbody>
			
		</table>
	
</body>
</html>