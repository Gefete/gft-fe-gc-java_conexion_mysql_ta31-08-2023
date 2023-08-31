import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Mysql_Connection {
	String jdbcUrl = "jdbc:mysql://localhost:3307/TA_31";
	String usuario = "root";
	String contraseña = "root";
	Connection conexion;
	
	//Connexion
	public Mysql_Connection() {
		try 
		{
		    this.conexion = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
		    System.out.println("Conexión exitosa a la base de datos.");
	
		    
		} catch (SQLException e) {
		    e.printStackTrace();
		    System.out.println("Error al conectar a la base de datos.");
		}
	}
	
	//Cerrar Connexion
	public void closeConnection() {
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null, conexion);
		}catch(SQLException ex){
			Logger.getLogger(Mysql_Connection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void createDB(String name) {
		try {
			String Query = "CREATE DATABASE "+name;
			Statement st =  conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Database creada");
		}catch(SQLException ex){
			System.out.println();
			System.out.println(ex.getMessage());
			System.out.println("Error creando Base de Datos.");
			System.out.println();
			//Logger.getLogger(Mysql_Connection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void createTable(String db, String name, String queryData) {
		try {
			//Meterse en la base de datos
			String Querydb = "USE "+db+";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(Querydb);
			
			//Creacion de tabla
			String Query = "Create table "+name+" ("
					+queryData
					+" );";
			
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Tabla creada con exito!");
		}catch(SQLException ex) {
			System.out.println();
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");
			System.out.println();
		}
	}
	
	public void insertData(String db, String table_name, String valuesName, String values) {
		try {
			//Meterse en la base de datos
			String Querydb = "USE "+db+";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(Querydb);
			
			String Query = "INSERT INTO "+table_name+" ("+valuesName+") Value ("
			+values+")";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Insertados con exito!");
		}catch(SQLException ex){
			System.out.println();
			System.out.println(ex.getMessage());
			System.out.println("Error en el almacenamiento");
			System.out.println();
		}
	}
	
	public void getValues(String db, String table_name, String[] selectValues) {
		try {
			//Meterse en la base de datos
			String Querydb = "USE "+db+";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(Querydb);
			
			String Query = "Select * from "+table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			while (resultSet.next()) {
				for (int i = 0; i < selectValues.length; i++) {
					System.out.println(""+selectValues[i]+": "
							+resultSet.getString(selectValues[i]));
				}
				System.out.println("-----------");
				
			}
			
		}catch(SQLException ex){
			System.out.println();
			System.out.println(ex.getMessage());
			System.out.println("Error al leer almacenamiento");
			System.out.println();
		}
	}
	
	public void deleteRecord(String db, String table_name, String ID) {
		try {
			//Meterse en la base de datos
			String Querydb = "USE "+db+";";
			Statement stbd = conexion.createStatement();
			stbd.executeUpdate(Querydb);
			
			String Query = "Delete from "+table_name+" Where ID=\""+ID+"\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
		}catch(SQLException ex){
			System.out.println();
			System.out.println(ex.getMessage());
			System.out.println("Error borrando registro");
			System.out.println();
		}
	}
}
