<!doctype html>
<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.Collection"%>
<%@page import="fr.pizzeria.admin.web.ListerPizzaController"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.Time"%>
<%@page import="java.util.Date"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<h2>Hello World!</h2>
	<%-- 	<h2>${lp}</h2> --%>
	<table class="table table-hover">
		<thead>
			<tr>
				<td><strong>#</strong></td>
				<td><strong>Code</strong></td>
				<td><strong>Nom</strong></td>
				<td><strong>Prix</strong></td>
				<td><strong>Categorie</strong></td>
				<td><strong>Image</strong></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach var="pizzaCourante" items="${lp}">

					<td>${pizzaCourante.id}</td>
					<td>${pizzaCourante.code}</td>
					<td>${pizzaCourante.nom}</td>
					<td>${pizzaCourante.prix}</td>
					<td>${pizzaCourante.categorie}</td>
					<td><img class="img-responsive"
						src="<c:url value='/images/pizzas/${pizzaCourante.url}' />" alt=""
						width=80 /></td>
					<td>
						<form action="<c:url value='/pizzas/edit'/>">
							<input type="hidden" name="codePizza"
								value="${pizzaCourante.code}"></input> <input type="submit"
								value="Editer" class="btn btn-default"></input>
						</form>
					</td>
					<td>
						<form action="<c:url value='/pizzas/delete'/>" method="post">
							<input type="hidden" name="codePizza"
								value="${pizzaCourante.code}"></input> <input type="submit"
								value="Supprimer" class="btn btn-default"></input>
						</form>
					</td>
					<td>
						<form action="<c:url value='/pizzas/new'/>">
							<input type="submit" value="Nouvelle" class="btn btn-default"></input>
						</form>
					</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<script
		src="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>

</html>
