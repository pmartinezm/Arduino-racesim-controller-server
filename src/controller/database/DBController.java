package controller.database;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import model.QueryResult;
import util.RSConverter;

public class DBController {
	private String path;
	private String base = "jdbc:sqlite:";
	private String url;
	private Connection connection;
	public static DBController instance;

	public static DBController getInstance() {
		if (instance == null) {
			instance = new DBController();
		}
		return instance;
	}

	/**
	 * Creates the db file.
	 * 
	 * @param path path_to_file/name.ext
	 * @return true if the db was created, false if not (error creating or already
	 *         exists)
	 */
	public boolean createDatabase(String path) {
		System.out.println("Creating database...");
		this.path = path;
		this.url = this.base + this.path;
		boolean response = checkFile();
		testConnection();
		return response;
	}

	public void configureDatabase(ArrayList<String> queries) {
		for (String query : queries) {
			sendQuery(query);
		}
	}

	/**
	 * Comprueba si el fichero de salida para la base de datos de SQLite (*.db)
	 * existe. Si no existe, intentará crearlo.
	 */
	private boolean checkFile() {
		System.out.print("Checking file...");
		File file = new File(this.path);
		if (!file.exists()) {
			System.out.println("File not found.");
			System.out.println("Attempting to create...");
			try {
				boolean created = file.createNewFile();
				if (created) {
					System.out.println("File created!");
					return true;
				} else {
					System.err.println("Error creating file.");
				}
			} catch (IOException e) {
				System.err.println("Error attempring to create file.");
				e.printStackTrace();
			}
		} else {
			System.out.println("File found.");
		}
		return false;
	}

	/**
	 * Envía una query a la base de datos.
	 * 
	 * @param query
	 * @return
	 */
	public QueryResult sendQuery(String query) {
		try {
			getConnection();
			Statement s = this.connection.createStatement();
			s.execute(query);
			ResultSet results = s.getResultSet();
			if (results != null) {
				return RSConverter.toQueryResult(results);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return new QueryResult();
	}

	/**
	 * Comprueba la conexión con la base de datos.
	 */
	private void testConnection() {
		System.out.println("Testing connection...");
		getConnection();
	}

	/**
	 * Obtiene la conexión con la base de datos.
	 */
	private void getConnection() {
		System.out.println("Getting connection...");
		try {
			this.connection = DriverManager.getConnection(this.url);
		} catch (SQLException e) {
			System.err.println("Error getting connection.");
			e.printStackTrace();
		}
	}

	/**
	 * Cierra la conexión con la base de datos.
	 */
	private void closeConnection() {
		System.out.println("Closing connection...");
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (SQLException e) {
				System.err.println("Error closing connection.");
				e.printStackTrace();
			}
		}
	}
}
