<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<linkrel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.7/js/bootstrap.min.js"></script>
<title>Borrar producto segun su id</title>
</head>
<body>
	<h1>Buscar informacion del producto (agregando un id existente)</h1>
	<form action="productoServlet" method="get">
			<label for="id">id del producto</label>
			<input type="number" name="id" id="id" maxlength="10"><br><br/>
			<input class="eliminar" type="submit" value="Eliminar">
			 
	</form>
</body>
</html>