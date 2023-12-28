<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes : Note Taker</title>
<%@include file="all_js_css.jsp" %>
</head>
<body>
<div class="container">
   <%@include file="navbar.jsp" %>
   <br>
   <h1>Please Fill Your Notes Details.</h1>
   <!-- This is Add form  -->
		<form action="SaveNoteServlet" method="post">
			<div class="form-group">
				<label for="title">Note Title</label> <input 
				name="title"
				required
				type="text"
				class="form-control" id="title"
				placeholder="Enter here"/> 
					
			</div>
			<div class="form-group">
				<label for="content">Note Content</label> 
				<textarea 
				required 
				id="content"
				name="content"
				class="form-control"
				placeholder="Enter your content here"
				style="height:200px"></textarea>
			</div>
			
			<div class="container text-center">
			<button type="submit" class="btn btn-primary">Add Note</button>
			</div>
		</form>
	</div>

</body>
</html>