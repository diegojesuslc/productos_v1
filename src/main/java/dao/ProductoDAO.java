package dao;

import java.util.ArrayList;

import model.Categoria;
import model.Producto;


public interface ProductoDAO {
	
	public ArrayList<Producto> listarProductos();
	public int agregarProducto(Producto prod);
	public int actualizarProducto(Producto prod);
	public boolean eliminarProducto(int id);
	public Producto buscarProducto(int id);
	public ArrayList<Categoria> listarCategorias();
}
