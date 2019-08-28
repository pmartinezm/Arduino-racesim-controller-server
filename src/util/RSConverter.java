package util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import model.QueryResult;

public class RSConverter {
	public static QueryResult toQueryResult(ResultSet rs) {
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
}
