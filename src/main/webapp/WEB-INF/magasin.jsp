<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Un magasin</title>
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
<table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Nom</th>
					<th scope="col">Adresse</th>
					<th scope="col">Cp</th>
					<th scope="col">Ville</th>
				</tr>
			</thead>
			<tbody>
		
				<tr>
					<th scope="row">${ m.getId() }</th>
					<td>${ m.getNom() }</td>
					<td>${ m.getAdresse() }</td>
					<td>${ m.getCp() }</td>
					<td>${ m.getVille() }</td>
				</tr>
				
			</tbody>
		</table>
</body>
</html>