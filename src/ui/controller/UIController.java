package ui.controller;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JPanel;

import ui.UI;
import ui.listeners.ManageCommandsListener;

public class UIController extends UI {

	public UIController() {
		blink();
		attatchActions();
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
}
