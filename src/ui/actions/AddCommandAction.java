package ui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.controller.ManageCommandsController;

public class AddCommandAction implements ActionListener {
	private ManageCommandsController controller;

	public AddCommandAction(ManageCommandsController controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		controller.addCommand();
	}

}
