package ui.listeners.manageCommands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.keyRecorder.KeyRecorder;
import ui.controller.ManageCommandsController;

public class ClearShortcutListener implements ActionListener{
	private ManageCommandsController controller;

	public ClearShortcutListener(ManageCommandsController controller) {
		super();
		this.controller = controller;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		KeyRecorder rec = KeyRecorder.getInstance();
		rec.clear();
		controller.setShortcut(rec.getRecord());
	}

}
