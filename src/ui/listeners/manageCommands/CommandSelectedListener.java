package ui.listeners.manageCommands;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ui.controller.ManageCommandsController;

public class CommandSelectedListener implements ListSelectionListener{
	private ManageCommandsController controller;
	
	public CommandSelectedListener(ManageCommandsController controller) {
		this.controller = controller;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		controller.showSelectedCommand();
		controller.manageComponentBehaviour();
	}

}
