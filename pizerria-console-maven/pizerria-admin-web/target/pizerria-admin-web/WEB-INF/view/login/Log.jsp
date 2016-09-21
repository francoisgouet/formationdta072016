<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form class="form-horizontal" method="post">
		<fieldset>

			<!-- Form Name -->
			<legend>Form Name</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Email</label>
				<div class="col-md-4">
					<input id="textinput" name="mail" type="text"
						placeholder="moi@example.com" class="form-control input-md">
					<input id="textinput" name="url" type="hidden" value="pizzas/list">

				</div>
			</div>

			<!-- Password input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="psd">Mot de passe</label>
				<div class="col-md-4">
					<input id="psd" name="psd" type="password"
						class="form-control input-md">
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"></label>
				<div class="col-md-4">
					<button id="singlebutton" name="singlebutton"
						class="btn btn-primary">Se connecter</button>
				</div>
			</div>

		</fieldset>
	</form>

</body>
</html>