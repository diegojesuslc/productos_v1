<%@ tag language="java" pageEncoding="UTF-8"%>

<nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="Index.jsp">Menú Principal</a>
            <div class="dropdown">
                <a style="color: white;" class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Mantenimientos</a>
                <div class="dropdown-menu text-center">
                    <a href="Reg_Producto.jsp" class="dropdown-item">Productos</a>
                </div>
            </div>


            <div class="dropdown">
                <a style="color: white;" class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Listas</a>
                <div class="dropdown-menu text-center">
                    <a href="prod?opcion=l" class="dropdown-item">Productos</a>       
                </div>
            </div>
        </div>

    </nav>