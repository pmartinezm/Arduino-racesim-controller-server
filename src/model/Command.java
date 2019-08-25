package model;

public class Command {
	private String name;
	private String keys;
	
	
	public Command(String name, String keys) {
		super();
		this.name = name;
		this.keys = keys;
	}
	
	public String getName() {
		return name;
	}

	public String getKeys() {
		return keys;
	}
}
