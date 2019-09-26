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
import util.DBUtil;
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
			instance.loadDb();
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
		System.out.println("DB - Creating database...");
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
		System.out.print("DB - Checking file...");
		File file = new File(this.path);
		if (!file.exists()) {
			System.out.println("DB - File not found.");
			System.out.println("DB - Attempting to create...");
			try {
				boolean created = file.createNewFile();
				if (created) {
					System.out.println("DB - File created!");
					return true;
				} else {
					System.err.println("DB - Error creating file.");
				}
			} catch (IOException e) {
				System.err.println("DB - Error attempring to create file.");
				e.printStackTrace();
			}
		} else {
			System.out.println("DB - File found.");
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
		System.out.println("DB - Testing connection...");
		getConnection();
	}

	/**
	 * Obtiene la conexión con la base de datos.
	 */
	private void getConnection() {
		System.out.println("DB - Getting connection...");
		try {
			this.connection = DriverManager.getConnection(this.url);
		} catch (SQLException e) {
			System.err.println("DB - Error getting connection.");
			e.printStackTrace();
		}
	}

	/**
	 * Cierra la conexión con la base de datos.
	 */
	private void closeConnection() {
		System.out.println("DB - Closing connection...");
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (SQLException e) {
				System.err.println("DB - Error closing connection.");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Check if db exists. If not, it will be created.
	 */
	private void loadDb() {
		boolean needsConfig = createDatabase("./arcs.dll");
		if(needsConfig) {
			System.out.println("DB - Configuring new database...");
			ArrayList<String> queries = new ArrayList<String>();
			queries.add(DBUtil.CREATE_COMMANDS_TABLE);
			DBController.getInstance().configureDatabase(queries);
		}
	}
}
