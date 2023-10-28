package utils;
import java.sql.*;

public class PruebaConexion {
	public static void main(String[] args) {
		try {
			// Crear conexion
			String url="jdbc:mysql://localhost:3306/proyectopi";
			String user="root";
			String pwd="MYSQL";
			Connection miConexion = DriverManager.getConnection(url, user, pwd);
			// Crear objeto statement
			Statement miStatement = miConexion.createStatement();
			// Ejecutar SQL
			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM `productos`;");
			// Recorrer result set
			while(miResultSet.next()) {
				System.out.println(miResultSet.getString("nombre_prod"));
			}
		}
		catch(Exception e) {
			System.out.println("No se conectó");
			e.printStackTrace();
		}
	}

}
