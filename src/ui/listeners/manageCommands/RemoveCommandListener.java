package ui.listeners.manageCommands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.controller.ManageCommandsController;

public class RemoveCommandListener implements ActionListener{
	private ManageCommandsController controller;
	
	

	public RemoveCommandListener(ManageCommandsController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		controller.removeCommand();
	}

}
