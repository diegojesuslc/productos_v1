<%@page import="model.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductoDAO"%>
<%@page import="dao.ProductoDAOImpl"%>
<%@page import="utils.DAOFactoryProductos"%>
<%@page import="model.Producto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%
Producto producto = (Producto) request.getAttribute("producto");
int id_prod = producto.getIdProd();
String nombre_prod = producto.getNombreProd();
int id_cat = producto.getIdCat();
String des_prod = producto.getDesProd();
String imagen = producto.getImagen();
double precio = producto.getPrecio();
double calificacion = producto.getCalificacion();
%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Productos</title>
<t:head></t:head>
</head>
<header>
	<t:header></t:header>
</header>
<body>
	<%
	String id = (String) request.getParameter("id");
	%>
	<div class="container-fluid mt-3 row align-items-start">
		<div class="col"></div>
		<div id="formulario" class="col bg-light align-middle">
			<form action="prod?opcion=<%=(id != null ? "a" : "r")%>&id=<%=id%>"
				method="post" class="mt-3 row g-2">
				<div class="text-center">
					<h1>Actualizar Producto</h1>
				</div>
				<div>
					<label class="fw-bold fst-italic form-label">Id:</label> <input
						class="form-control" type="number" id="id_prod" name="id_prod"
						value="<%=id_prod%>" readonly="readonly" />
				</div>
				<br />
				<div>
					<label class="fw-bold fst-italic form-label">Nombre:</label> <input
						type="text" class="form-control" name="nombre_prod"
						value="<%=nombre_prod%>" />
				</div>
				<br />
				<div>
					<label class="fw-bold fst-italic form-label">Categoria:</label> <select
						class="form-select" name="id_cat">
						<%
						DAOFactoryProductos cat = DAOFactoryProductos.getDAOFactory(DAOFactoryProductos.MYSQL);
						ProductoDAO impl = cat.getProductoInterface();
						ArrayList<Categoria> lstCat = impl.listarCategorias();
						//out.print("<option value='" + producto.getIdCat() + "'>" + producto.getNombreCat() + "</option>");
						for (Categoria c : lstCat) {
							// Verifica si esta categoría coincide con la categoría del producto
					        String selected = (c.getIdCat() == producto.getIdCat()) ? "selected" : "";
					        out.print("<option value='" + c.getIdCat() + "' " + selected + ">" + c.getNombreCat() + "</option>");
						}
						%>
					</select>
				</div>
				<br />
				<div>
					<label class="fw-bold fst-italic form-label">Descripcion:</label> <input
						type="text" class="form-control" name="des_prod"
						value="<%=des_prod%>" />
				</div>
				<br />
				<div>
					<label class="fw-bold fst-italic form-label">Imagen:</label> <input
						type="text" class="form-control" name="imagen" value="<%=imagen%>" />
				</div>
				<br />
				<div>
					<label class="fw-bold fst-italic form-label">Precio:</label> <input
						type="number" class="form-control" name="precio"
						value="<%=precio%>" />
				</div>
				<br />
				<div>
					<label class="fw-bold fst-italic form-label">Calificación:</label>
					<input type="number" class="form-control" name="calificacion"
						value="<%=calificacion%>" />
				</div>
				<br />
				<div class="d-grid gap-2 d-md-block text-center mb-3">
					<input class="btn btn-primary" type="submit" value="Guardar" /> <a
						href="prod?opcion=l" class="btn btn-danger">Reporte</a>
				</div>
			</form>
		</div>
		<div class="col"></div>
	</div>
</body>
</html>