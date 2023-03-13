<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des produits par magasins</title>
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
    <form method="post" action="affecterProduitsToMagasins" >
	<h1>Liste des produits</h1>
	<table class="table">
		<thead>
			<tr>
			    <th scope="col">#</th>
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
				    <td><div class="form-check">
							<input class="form-check-input" type="checkbox" name="selectedProduits"value="${p.getId() }"
								id="flexCheckDefault"> 
						</div></td>
						
					<th scope="row"><a href="P?id=${ p.getId() }">${ p.getId() }</th>
					</a>
					
					<td>${ p.getNom() }</td>
					<td>${ p.getReference() }</td>
					<td>${ p.getPrix() }</td>
					<td>${ p.getPoids() }</td>
					<td><a href="supprimer?id=${ p.getId() } "><button
								type="button" class="btn btn-outline-danger">Supprimer</button></a></td>
				</tr>

			</c:forEach>


		</tbody>
	</table>

	<hr>

	<h1>Liste des magasins</h1>
	<table class="table">
		<thead>
			<tr>
			    <th scope="col">#</th>
				<th scope="col">Id</th>
				<th scope="col">Nom</th>
				<th scope="col">Adresse</th>
				<th scope="col">Cp</th>
				<th scope="col">Ville</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="m" items="${ listeM }">
				<tr>
				<td><div class="form-check">
							<input class="form-check-input" type="checkbox" name="selectedMagasins"value="${m.getId() }"
								id="flexCheckDefault"> 
					</div></td>
					<th scope="row"><a href="M?id=${ m.getId() }">${ m.getId() }</a></th>
					
					<td>${ m.getNom() }</td>
					<td>${ m.getAdresse() }</td>
					<td>${ m.getCp() }</td>
					<td>${ m.getVille() }</td>
					<td><a href="supprimer?id=${ m.getId() } "><button
								type="button" class="btn btn-outline-danger">Supprimer</button></a></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	
        <button type="submit" class="btn btn-primary">Envoyer</button>
		<button type="reset" class="btn btn-danger">Annuler</button>
</form>
</body>
</html>