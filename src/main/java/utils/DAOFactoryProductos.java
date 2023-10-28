package utils;

import dao.ProductoDAO;

public abstract class DAOFactoryProductos {
	public static final int MYSQL = 1;
	public static final int SQL = 2;
	
	public abstract ProductoDAO getProductoInterface();
	
	public static DAOFactoryProductos getDAOFactory(int qBD) {
		switch (qBD) {
		case MYSQL:
			return new MySqlDAOFactoryProductos();
		default:
			return null;
		}
	}
}
