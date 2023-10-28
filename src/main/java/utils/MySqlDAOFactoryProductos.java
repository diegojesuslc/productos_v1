package utils;

import dao.ProductoDAO;
import dao.ProductoDAOImpl;

public class MySqlDAOFactoryProductos extends DAOFactoryProductos{

	@Override
	public ProductoDAO getProductoInterface() {
		return new ProductoDAOImpl();
	}



}
