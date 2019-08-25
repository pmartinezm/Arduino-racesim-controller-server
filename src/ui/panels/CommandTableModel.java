package ui.panels;

import javax.swing.table.AbstractTableModel;

public class CommandTableModel extends AbstractTableModel {
	private String[] columnNames = {"Name", "Keys"};
	private Object data[][] = {{"Nombre", "Teclas"}};
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
}
