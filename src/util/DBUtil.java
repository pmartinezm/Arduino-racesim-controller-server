package util;

public class DBUtil {
	public static String CREATE_COMMANDS_TABLE = "create table commands (name varchar(50) not null, keys varchar(100) not null)";
	public static String INSERT_COMMAND = "insert into commands (name, keys) values ('%s', '%s')";
	public static String GET_COMMANDS = "select * from commands";
}
