package SerialPort;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;

import com.fazecast.jSerialComm.SerialPort;

import util.ConsoleIO;

public class COM {
	private SerialPort sp;

	public COM() {
		super();
	}

	public SerialPort[] getComDevices() {
		return this.sp.getCommPorts();
	}

	public void connect(SerialPort device) {
		device.openPort();
		device.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);

		InputStream is = device.getInputStream();

		ConsoleIO.show("Listening device. Press Ctrl + C to stop server.");

		while (true) {
			try {
				Robot r = new Robot();
				int reading = is.read();
				ConsoleIO.show(reading + "");

				if (reading == 72) {
					r.keyPress(KeyEvent.VK_SPACE);
				} else if (reading == 0) {
					r.keyRelease(KeyEvent.VK_SPACE);
				}
			} catch (IOException | AWTException e) {
				e.printStackTrace();
			}
		}
	}

	private void displayInfo(SerialPort sp) {
		System.out.println(sp);
		System.out.println(" Descriptive port name: " + sp.getDescriptivePortName());
		System.out.println(" Baud rate:             " + sp.getBaudRate());
		System.out.println(" Port description:      " + sp.getPortDescription());
		System.out.println(" System port name:      " + sp.getSystemPortName());
		System.out.println(" Open:                  " + sp.isOpen());
		System.out.println(" Parity:                " + sp.getParity());
		System.out.println();
	}
}
