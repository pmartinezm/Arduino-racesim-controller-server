package controller.dao;

import java.util.ArrayList;
import java.util.List;

import controller.database.DBController;
import model.Command;
import model.QueryResult;
import util.DBUtil;

public class CommandDAO {
	private static CommandDAO instance;

	public CommandDAO() {
//		this.commands = new ArrayList<Command>();
//		commands.add(new Command("Handbrake", "SPACE"));
//		commands.add(new Command("Clutch", "LEFT SHIFT"));
	}

	public static CommandDAO getInstance() {
		if (instance == null) {
			instance = new CommandDAO();
		}
		return instance;
	}

	public List<Command> getCommands() {
		String query = DBUtil.GET_COMMANDS;
		QueryResult qr = DBController.getInstance().sendQuery(query);
		ArrayList<Command> commands = new ArrayList<Command>();

		if (qr.rowCount() > 0) {
			for (ArrayList<Object> row : qr.getRows()) {
				commands.add(new Command((String) row.get(0), (String) row.get(1)));
			}
		}

		return commands;
	}

	public boolean addCommand(Command command) {
		String query = String.format(DBUtil.INSERT_COMMAND, command.getName(), command.getKeys());
		DBController.getInstance().sendQuery(query);
		return true;
		// return commands.add(command);
	}

	public boolean removeCommand(Command command) {
		// return commands.remove(command);
		return false;
	}
}
