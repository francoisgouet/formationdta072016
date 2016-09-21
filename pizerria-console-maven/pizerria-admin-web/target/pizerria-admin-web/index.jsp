<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.Time"%>
<%@page import="java.util.Date"%>
<html>
<!-- <meta HTTP-EQUIV="Refresh" CONTENT="10"> -->

<body>
	<h2>Hello World!</h2>
	<% 
			Date a = new Date();
			DateFormat df = new SimpleDateFormat("HH:mm:ss");
			String da =df.format(a);
			Time h = new Time(5);
		%>
	<h2></h2>
	<h2><%= da%></h2>
</body>
</html>
