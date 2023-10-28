<%@page import="model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Productos</title>
<t:head />
</head>
<header>
	<t:header></t:header>
</header>
<body>

	<div class="container-fluid">
		<h1>Lista de Productos</h1>
		<div>
			<a href="Reg_Producto.jsp" class="btn btn-primary">Agregar</a>
		</div>
	</div>
	<p></p>
	<table class="table" id="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Nombre</th>
				<th scope="col">Categoria</th>
				<th scope="col">Descripción</th>
				<th scope="col">Imagen</th>
				<th scope="col">Precio</th>
				<th scope="col">Calificación</th>
				<th scope="col">Opciones</th>
			</tr>
		</thead>
		<tbody>
			<%
			ArrayList<Producto> lstProducto = (ArrayList<Producto>) request.getAttribute("lstProducto");
			if (lstProducto != null) {
				for (Producto prod : lstProducto) {
			%>
			<tr class="grilla_campo">
				<td><%=prod.getIdProd()%></td>
				<td><%=prod.getNombreProd()%></td>
				<td><%=prod.getNombreCat()%></td>
				<td><%=prod.getDesProd()%></td>
				<td>
                    <img src="<%= "img/" + URLEncoder.encode(prod.getImagen(), "UTF-8") %>"
                         alt="<%= prod.getImagen() %>"
                         width="100"
                         height="100">                    
                </td>
				<td><%=prod.getPrecio()%></td>
				<td><%=prod.getCalificacion()%></td>
				<td><a href="prod?opcion=b&id=<%=prod.getIdProd()%>">
						<button class="btn btn-success">Actualizar</button>
				</a> <a href="prod?opcion=e&id=<%=prod.getIdProd()%>">
						<button class="btn btn-danger">Eliminar</button>
				</a></td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>
	<p></p>
	<a class="btn btn-primary" href="#">Generar Reporte</a>
	<p></p>

</body>
<script>
	$(document).ready(function() {
		$('#table').DataTable();
	});
</script>
</html>