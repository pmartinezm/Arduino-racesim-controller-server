package view;

import java.io.IOException;

import com.fazecast.jSerialComm.SerialPort;

import SerialPort.COM;
import util.ConsoleIO;

public class CLI {
	private COM com;
	
	public CLI() {
		super();
		this.com = new COM();
		this.initialConfig();
	}

	private void initialConfig() {
		ConsoleIO.show("Select device to listen:");

		SerialPort[] devices = new COM().getComDevices();
		int opt = 0;
		for (SerialPort device : devices) {
			ConsoleIO.show(opt + " - " + device.getDescriptivePortName());
			opt++;
		}

		ConsoleIO.input("Device number: ");
		int deviceIndex = ConsoleIO.readInt();

		ConsoleIO.show("Preparing device " + devices[deviceIndex].getDescriptivePortName() + " to emulate SPACE.");
		
		this.com.connect(devices[deviceIndex]);
	}
}
