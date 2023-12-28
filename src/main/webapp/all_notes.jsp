<%@page import="org.hibernate.query.Query"%>
<%@page import="com.project.notetaker.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.project.notetaker.helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Notes : Note Taker</title>
<%@ include file='all_js_css.jsp'%>
</head>
<body>
	<div class="container">
		<%@include file='navbar.jsp'%>
		<br>
		<h1 class="text-uppercase">All Notes:</h1>


		<div class="row">

			<div class="col-12"></div>

		</div>
		

		<%
		Session s = FactoryProvider.getFactory().openSession();
		Query query = s.createQuery("from Note");
		List<Note> list = query.list();
		for (Note note : list) {
			
		%>

		<div class="card mt-3" >
			<img class="card-img-top m-3 mx-auto"  style ="max-width:50px;" src="images/pencil.png" alt="Card image cap">
			<div class="card-body pd-5">
				<h5 class="card-title"><%= note.getTitle() %></h5>
				<p class="card-text"><%=note.getContent() %></p>
				<div class="container text-right"><p ><b class="text-primary"><%=note.getAddedDate() %></b></p></div>
				<div class="container text-center mt-2 ">
				<a href="DeleteServlet?note_id=<%=note.getId()%>" class="btn btn-danger">Delete</a>
				<a href="edit.jsp?note_id=<%=note.getId()%>" class="btn btn-primary">Update</a>
				</div>
			</div>
		</div>

		<%
		}

		s.close();
		%>
	</div>
</body>
</html>