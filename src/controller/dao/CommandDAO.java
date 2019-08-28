package controller.dao;

import java.util.ArrayList;
import java.util.List;

import controller.database.DBController;
import model.Command;

public class CommandDAO {
	private List<Command> commands;
	private static CommandDAO instance;

	public CommandDAO() {
		this.commands = new ArrayList<Command>();
		commands.add(new Command("Handbrake", "SPACE"));
		commands.add(new Command("Clutch", "LEFT SHIFT"));
	}

	public static CommandDAO getInstance() {
		if (instance == null) {
			instance = new CommandDAO();
		}
		return instance;
	}

	public List<Command> getCommands() {
		return commands;
	}

	public boolean addCommand(Command command) {
		return commands.add(command);
	}
	
	public boolean removeCommand(Command command) {
		return commands.remove(command);
	}
}
