package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConexion {
	
	public static Connection getConexion() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/proyectopi";
			String user = "root";
			String pwd = "MYSQL";
			cn = DriverManager.getConnection(url, user, pwd);		
		}
		catch(Exception e) {
			System.out.println("No se conectó");
			e.printStackTrace();
		}
		return cn;
	}
}
