package ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import ui.controller.ManageCommandsController;
import ui.controller.MainUIController;
import ui.panels.ManageCommandsPanel;

public class ManageCommandsListener implements ActionListener{
	private MainUIController uic;

	public ManageCommandsListener(MainUIController uic) {
		this.uic = uic;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JDialog dialog = new JDialog(uic);
		dialog.setAutoRequestFocus(true);
		dialog.setAlwaysOnTop(true);
		dialog.setTitle("Manage commands");
		dialog.setContentPane(new ManageCommandsController());
		dialog.setResizable(false);
		dialog.pack();
		dialog.setVisible(true);
	}
}
