package ui.controller;

import java.awt.Color;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.dao.CommandDAO;
import model.Command;
import ui.MainUI;
import ui.listeners.ManageCommandsListener;

public class MainUIController extends MainUI {

	public MainUIController() {
		blink();
		attatchActions();
		refreshActiveCommands();
	}
	
	public void createDialog(String title, JPanel panel) {
		JDialog d = new JDialog(this);
		d.setTitle(title);
	}
	
	private void attatchActions() {
		mntmManage.addActionListener(new ManageCommandsListener(this));
	}

	private void blink() {
		lblStatusdisplay.setText("TESTING");
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						lblStatusdisplay.setForeground(Color.RED);
						Thread.sleep(500);
						lblStatusdisplay.setForeground(Color.BLACK);
						Thread.sleep(500);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	private void refreshActiveCommands() {
		List<Command> commands = CommandDAO.getInstance().getCommands();
		
		for (Command command : commands) {
			JLabel label = new JLabel(command.getName());
			panel.add(label);
		}
	}
}
