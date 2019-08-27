package ui.controller;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import controller.dao.CommandDAO;
import model.Command;
import ui.listeners.manageCommands.AddCommandListener;
import ui.listeners.manageCommands.ClearShortcutListener;
import ui.listeners.manageCommands.CommandSelectedListener;
import ui.listeners.manageCommands.RecordKeysListener;
import ui.listeners.manageCommands.RemoveCommandListener;
import ui.listeners.manageCommands.TxtValueListener;
import ui.panels.ManageCommandsPanel;

public class ManageCommandsController extends ManageCommandsPanel {
	public ManageCommandsController() {
		super();
		refreshTableData();
		setListeners();
		manageComponentBehaviour();
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
		btnAdd.addActionListener(new AddCommandListener(this));
		btnRemove.addActionListener(new RemoveCommandListener(this));
		list.addListSelectionListener(new CommandSelectedListener(this));
		txtName.addKeyListener(new TxtValueListener(this));
		txtKeys.addKeyListener(new TxtValueListener(this));
		txtKeys.addKeyListener(new RecordKeysListener(this));
		btnClearShortcut.addActionListener(new ClearShortcutListener(this));
	}

	public void addCommand() {
		Command command = new Command(txtName.getText(), txtKeys.getText());
		CommandDAO.getInstance().addCommand(command);
		refreshTableData();
		clearTxt();
	}

	public void removeCommand() {
		Command command = list.getSelectedValue();
		CommandDAO.getInstance().removeCommand(command);
		refreshTableData();
		clearTxt();
	}

	public void showSelectedCommand() {
		if (list.getSelectedIndex() != -1) {
			Command command = list.getSelectedValue();
			txtName.setText(command.getName());
			txtKeys.setText(command.getKeys());
		}
	}

	public void checkTxtValues() {
		manageBtnAddBehaviour();
	}

	public void manageComponentBehaviour() {
		manageBtnRemoveBehaviour();
		manageBtnAddBehaviour();
	}

	public void manageBtnAddBehaviour() {
		if (txtKeys.getText().isEmpty() || txtName.getText().isEmpty()) {
			btnAdd.setEnabled(false);
		} else {
			btnAdd.setEnabled(true);
		}
	}

	public void manageBtnRemoveBehaviour() {
		if (list.getSelectedValue() == null) {
			btnRemove.setEnabled(false);
		} else {
			btnRemove.setEnabled(true);
		}
	}

	private void clearTxt() {
		txtKeys.setText("");
		txtName.setText("");
	}

	public void setShortcut(ArrayList<KeyEvent> keys) {
		StringBuilder shortCut = new StringBuilder();

		for(int i = 0; i < keys.size(); i++) {
			KeyEvent key = keys.get(i);
			shortCut.append(KeyEvent.getKeyText(key.getKeyCode()));
			if(i != keys.size()-1) {
				shortCut.append(" + ");
			}
		}
		
		txtKeys.setText(shortCut.toString());
	}
}
