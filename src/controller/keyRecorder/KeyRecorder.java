package controller.keyRecorder;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyRecorder {
	private ArrayList<KeyEvent> keys;
	private static KeyRecorder instance;
	
	public static KeyRecorder getInstance() {
		if(instance == null) {
			instance = new KeyRecorder();
		}
		return instance;
	}
	
	public KeyRecorder() {
		this.keys = new ArrayList<KeyEvent>();
	}
	
	public void addKey(KeyEvent key) {
		keys.add(key);
	}
	
	public void clear() {
		keys.clear();
	}
	
	public ArrayList<KeyEvent> getRecord() {
		return keys;
	}
}
