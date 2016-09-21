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
<title>Insert title here</title>
<link
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script><%@ page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
</head>
<body>
	<c:forEach var="eventCourant" items="${listeEvent}">
		<h5>${eventCourant.cal}</h5>
		<h5>${eventCourant.pizza.code}</h5>
	</c:forEach>
</body>
</html>