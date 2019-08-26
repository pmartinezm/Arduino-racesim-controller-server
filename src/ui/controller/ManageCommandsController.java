package ui.controller;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.CommandDAO;
import model.Command;
import ui.actions.AddCommandAction;
import ui.actions.CommandSelectedAction;
import ui.actions.RemoveCommandAction;
import ui.panels.ManageCommandsPanel;

public class ManageCommandsController extends ManageCommandsPanel {
	public ManageCommandsController() {
		super();
		refreshTableData();
		setListeners();
	}

	private DefaultTableModel createModel() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("Keys");
		return model;
	}

	private void refreshTableData() {
		List<Command> commands = CommandDAO.getInstance().getCommands();
		DefaultListModel<Command> model = new DefaultListModel<Command>();

		for (Command command : commands) {
			model.addElement(command);
		}
		list.setModel(model);
	}

	private void setListeners() {
		btnAdd.addActionListener(new AddCommandAction(this));
		btnRemove.addActionListener(new RemoveCommandAction(this));
		list.addListSelectionListener(new CommandSelectedAction(this));
	}

	public void addCommand() {
		Command command = new Command(txtName.getText(), txtKeys.getText());
		CommandDAO.getInstance().addCommand(command);
		refreshTableData();
	}

	public void removeCommand() {
		Command command = list.getSelectedValue();
		CommandDAO.getInstance().removeCommand(command);
		refreshTableData();
	}

	public void showSelectedCommand() {
		if (list.getSelectedIndex() != -1) {
			Command command = list.getSelectedValue();
			txtName.setText(command.getName());
			txtKeys.setText(command.getKeys());
		}
	}
}
