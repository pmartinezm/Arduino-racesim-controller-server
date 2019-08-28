package model;

import java.util.ArrayList;

public class QueryResult {
	private ArrayList<String> columnNames;
	private ArrayList<ArrayList<Object>> rows;

	public QueryResult() {
		this.columnNames = new ArrayList<String>();
		this.rows = new ArrayList<ArrayList<Object>>();
	}

	public void addColumn(String name) {
		columnNames.add(name);
	}

	public void addRow(ArrayList<Object> row) {
		rows.add(row);
	}

	public int rowCount() {
		return rows.size();
	}

	public int colCount() {
		return columnNames.size();
	}

	public ArrayList<Object> get(int index) {
			return rows.get(index);
	}
	
	public ArrayList<ArrayList<Object>> getRows() {
		return rows;
	}
	
	public ArrayList<String> getColNames() {
		return columnNames;
	}
}
