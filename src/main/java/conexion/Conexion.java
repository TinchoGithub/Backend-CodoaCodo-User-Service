package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

	public String driver = "com.mysql.cj.jdbc.Driver";
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Connection connection = null;
		try {
			
			Class.forName(driver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "MartinSQL");
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			System.out.println("Ocurrio un ERROR "+e);
		}
		
		return connection;
	}
	
}

