package ui.listeners.manageCommands;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controller.keyRecorder.KeyRecorder;
import ui.controller.ManageCommandsController;

public class RecordKeysListener implements KeyListener {
	private KeyRecorder rec;
	private ManageCommandsController controller;
	
	public RecordKeysListener(ManageCommandsController controller) {
		this.rec = KeyRecorder.getInstance();
		this.controller = controller;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		rec.addKey(e);
		controller.setShortcut(rec.getRecord());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
