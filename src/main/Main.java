package main;
import java.awt.EventQueue;

import ui.MainUI;
import ui.controller.MainUIController;
import util.Log;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log.info(this, "Starting ARCS: Arduino Racesim Controller Server...");
					MainUIController frame = new MainUIController();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
