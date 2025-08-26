package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public Connection conectarBD() { // metodo con el objeto connection
		Connection connection = null; // cierre de la conexion por defecto
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_sectorturismo", "root", "2556229"); // url de conexion definiendo los parametros de conexion para conectar con la BD
				System.out.println("Conectado a la base de datos");
			} catch (ClassNotFoundException e) {
				System.out.println("error en el driver: "+e);
			}
		} catch (SQLException noconexion) {
			System.out.println("Error: " + noconexion.getMessage());// muestra del error a la BD
		}
		return connection; // retorna la conexion estando o no abierta en la BD
	}
}