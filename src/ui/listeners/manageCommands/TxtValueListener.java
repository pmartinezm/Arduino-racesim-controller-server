package ui.listeners.manageCommands;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ui.controller.ManageCommandsController;

public class TxtValueListener implements KeyListener {
	private ManageCommandsController controller;
	
	public TxtValueListener(ManageCommandsController controller) {
		this.controller = controller;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		controller.manageBtnAddBehaviour();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	
	
}
