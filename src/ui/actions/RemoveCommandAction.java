package ui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.controller.ManageCommandsController;

public class RemoveCommandAction implements ActionListener{
	private ManageCommandsController controller;
	
	

	public RemoveCommandAction(ManageCommandsController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		controller.removeCommand();
	}

}
