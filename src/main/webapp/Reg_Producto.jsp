<%@page import="dao.ProductoDAO"%>
<%@page import="com.mysql.cj.x.protobuf.MysqlxDatatypes.Array"%>
<%@page import="utils.DAOFactoryProductos"%>
<%@page import="model.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductoDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de productos</title>
<t:head />
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
		<div id="form" class="col bg-light align-middle">
			<form id="frmbase" class="myFormContainer mt-3 row g-3"
				action="prod?opcion=<%=(id!=null?"a":"r")%>&id=<%=id%>"
				method="post">
				<div class="text-center">
					<h1>Agregar Producto</h1>
				</div>
				<div>
					<label class="fw-bold fst-italic form-label" for="nombre_prod">Nombre
						:</label> <input class="form-control" type="text" name="nombre_prod"
						id="nombre_prod" />
				</div>
				<div>
					<label class="fw-bold fst-italic form-label" for="des_prod">Descripción
						:</label> <input class="form-control" type="text" name="des_prod"
						id="des_prod" />
				</div>
								<div>
					<label class="fw-bold fst-italic form-label" for="nombre_cat">Categoria
						:</label> <select class="form-select" name="id_cat">
						<%
						DAOFactoryProductos cat = DAOFactoryProductos
						.getDAOFactory(DAOFactoryProductos.MYSQL);
						ProductoDAO daop = cat.getProductoInterface();
						ArrayList<Categoria> lstCat = daop.listarCategorias();
						out.print("<option value='-1'>Seleccione...</option>");
						for (Categoria c : lstCat) {
							out.print("<option value='" + c.getIdCat() + "'>" 
										+ c.getNombreCat() + "</option> selected");
						}
						%>
					</select>
				</div>
				<div>
					<label class="fw-bold fst-italic form-label" for="imagen">Imagen
						:</label> <input class="form-control" type="text" name="imagen"
						id="imagen" />
				</div>
				<div>
					<label class="fw-bold fst-italic form-label" for="precio">Precio
						:</label> <input class="form-control" type="text" name="precio"
						id="precio" />
				</div>

				<div>
					<label class="fw-bold fst-italic form-label" for="calificacion">calificacion
						:</label> <input class="form-control" type="text" name="calificacion"
						id="calificacion" />
				</div>

				<div class="d-grid gap-2 d-md-block text-center mb-3">
					<button type="submit" class="btn btn-primary" value="Registrar">Registrar</button>
				</div>
			</form>
		</div>
		<div class="col"></div>
	</div>



</body>
</html>