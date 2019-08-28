package util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import model.QueryResult;

public class RSConverter {
	public static <T> QueryResult toQueryResult(ResultSet rs) {
		try {
			QueryResult qr = new QueryResult();
			int cols = rs.getMetaData().getColumnCount();

			for (int i = 1; i <= cols; i++) {
				qr.addColumn(rs.getMetaData().getColumnName(i));
			}

			while (rs.next()) {
				ArrayList<Object> row = new ArrayList<Object>();
				for (int i = 1; i <= cols; i++) {
					row.add(rs.getObject(i));
				}
				qr.addRow(row);
			}
			return qr;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<HashMap<Object, Object>> toMapList(ResultSet rs) throws SQLException {
		ArrayList<HashMap<Object, Object>> rows = new ArrayList<HashMap<Object, Object>>();

		int columns = rs.getMetaData().getColumnCount();

		while (rs.next()) {
			HashMap<Object, Object> row = new HashMap<Object, Object>();

			for (int i = 1; i <= columns; i++) {
				row.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
			}
			rows.add(row);
		}

		return rows;
	}

	public static ArrayList<HashMap<String, Object>> toAl(ResultSet rs) {
		try {
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>(50);
			while (!rs.isClosed() && rs.next()) {
				HashMap<String, Object> row = new HashMap<String, Object>(columns);
				for (int i = 1; i <= columns; i++) {
					row.put(md.getColumnName(i), rs.getObject(i));
				}
				list.add(row);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
