package ui.actions;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ui.controller.ManageCommandsController;

public class CommandSelectedAction implements ListSelectionListener{
	private ManageCommandsController controller;
	
	public CommandSelectedAction(ManageCommandsController controller) {
		this.controller = controller;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		controller.showSelectedCommand();
	}

}
