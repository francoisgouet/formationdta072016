<%@page import="fr.pizzeria.model.Pizza"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<form class="form-horizontal" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend>Form Name</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput1">Code</label>
				<div class="col-md-4">
					<input id="textinput1" name="code" type="text"
						placeholder="code" class="form-control input-md" required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput2">Nom</label>
				<div class="col-md-4">
					<input id="textinput2" name="nom" type="text"
						placeholder="nom" class="form-control input-md" required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Prix</label>
				<div class="col-md-4">
					<input id="textinput" name="prix" type="text"
						placeholder="prix" class="form-control input-md" required="">

				</div>
			</div>

			<!-- Button Drop Down -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="buttondropdown">Categorie</label>
				<div class="col-md-4">
					<div class="input-group">
						<input id="buttondropdown" name="categorie"
							class="form-control" placeholder="categorie" type="text" required="">
						<div class="input-group-btn">
							<button id="btn" type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown">
								Action <span class="caret"></span>
							</button>
							<ul id="select" class="dropdown-menu pull-right">
								<li><a href="#">VIANDE</a></li>
								<li><a href="#">SANS_VIANDE</a></li>
								<li><a href="#">POISSON</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<!-- File Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="filebutton">Image</label>
				<div class="col-md-4">
					<input id="filebutton" name="file" class="input-file"
						type="file">
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"></label>
				<div class="col-md-4">
					<button id="singlebutton" 
						class="btn btn-primary">Envoyer</button>
				</div>
			</div>

		</fieldset>
	</form>
	<script
		src="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>