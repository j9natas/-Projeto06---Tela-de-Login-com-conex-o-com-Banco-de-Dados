package class_conections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	  static final String URL = "jdbc:postgresql://54.207.249.46:5432/";
	  static final String USER = "postgres"; 
	  static final String PASS = "qwe123"; 
	
	public static Connection connect() throws SQLException {

		try {

			Class.forName("org.postgresql.Driver"); 
			System.out.println("Conectou!");
			return DriverManager.getConnection(URL,USER,PASS);	

			
		} catch (ClassNotFoundException e) {

			throw new SQLException(e.getException());

		}

	}

}