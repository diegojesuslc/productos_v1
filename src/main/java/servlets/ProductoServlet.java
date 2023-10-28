package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductoDAOImpl;
import model.Producto;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet(name= "prod", urlPatterns= {"/prod"})
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		registrar(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--Entró al Servlet de Productos--");
		String opc = request.getParameter("opcion");
		opc = (opc == null ? "error" : opc);
		System.out.println("--Opción seleccionada : " + opc + "--");
		switch (opc) {	
			case "r": registrar(request, response); break;
			case "a": actualizar(request, response); break;
			case "e": eliminar(request, response); break;
			case "b": buscar(request, response); break;
			case "l": listar(request, response); break;
		default:
			response.sendRedirect("error.jsp");
		}
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idProd = Integer.parseInt(request.getParameter("id"));
		
		ProductoDAOImpl pImpl = new ProductoDAOImpl();
		Producto producto = pImpl.buscarProducto(idProd);
		request.setAttribute("producto", producto);
		String url = "/Act_Producto.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoDAOImpl pImpl = new ProductoDAOImpl();
		ArrayList<Producto> list = pImpl.listarProductos();
		request.setAttribute("lstProducto", list);
		request.getRequestDispatcher("/Lista_Productos.jsp").forward(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idProd = Integer.parseInt(request.getParameter("id"));
		ProductoDAOImpl pImpl = new ProductoDAOImpl();
		pImpl.eliminarProducto(idProd);
		listar(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_prod = Integer.parseInt(request.getParameter("id_prod"));
		String nombre_prod =  request.getParameter("nombre_prod");
		int id_cat = Integer.parseInt(request.getParameter("id_cat"));
		String des_prod = request.getParameter("des_prod");
		String imagen = request.getParameter("imagen");
		double precio = Double.parseDouble(request.getParameter("precio"));
		double calificacion = Double.parseDouble(request.getParameter("calificacion"));
		
		Producto producto = new Producto(nombre_prod, id_cat, des_prod, imagen, precio, calificacion);
		producto.setIdProd(id_prod);
		ProductoDAOImpl pImpl= new ProductoDAOImpl();
		pImpl.actualizarProducto(producto);
		listar(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int id_prod = Integer.parseInt(request.getParameter("id"));
		String nombre_prod =  request.getParameter("nombre_prod");
		int id_cat = Integer.parseInt(request.getParameter("id_cat"));
		String des_prod = request.getParameter("des_prod");
		String imagen = request.getParameter("imagen");
		double precio = Double.parseDouble(request.getParameter("precio"));
		double calificacion = Double.parseDouble(request.getParameter("calificacion"));
		
		Producto producto = new Producto(nombre_prod, id_cat, des_prod, imagen, precio, calificacion);
		ProductoDAOImpl pImpl= new ProductoDAOImpl();
		pImpl.agregarProducto(producto);
		listar(request, response);
	}
}
