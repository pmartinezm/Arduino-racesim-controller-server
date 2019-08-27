package ui.listeners.manageCommands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.controller.ManageCommandsController;

public class AddCommandListener implements ActionListener {
	private ManageCommandsController controller;

	public AddCommandListener(ManageCommandsController controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		controller.addCommand();
	}

}
