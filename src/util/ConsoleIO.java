package util;

import java.util.Scanner;

public class ConsoleIO {
	private static Scanner s;
	public static void show(String msg) {
		s = new Scanner(System.in);
		System.out.println(msg);
	}
	
	public static void error(String msg) {
		System.err.println("[ERROR] " + msg);
	}
	
	public static int readInt() {
		return s.nextInt();
	}
	
	public static void input(String msg) {
		System.out.print(">" + msg);
	}
}
