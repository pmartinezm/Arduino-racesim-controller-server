package util;

public class Log {
	public static void info(Object clazz, Object msg) {
		show(prepareMessage(clazz.getClass(), msg));
	}
	
	public static void info(Object msg) {
		show(msg.toString());
	}
	
	public static void error(Object clazz, Object msg) {
		showError(prepareMessage(clazz.getClass(), msg));
	}
	
	public static void error(Object msg) {
		showError(msg.toString());
	}
	
	private static void showError(Object msg) {
		System.err.println(msg.toString());
	}
	
	private static void show(Object msg) {
		System.out.println(msg.toString());
	}
	
	private static String prepareMessage(Class c, Object msg) {
		return "[" + c.getSimpleName() + "] " + msg.toString();
	}
}
