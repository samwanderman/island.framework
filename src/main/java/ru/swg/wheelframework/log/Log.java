/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.log;

/**
 * Simple Logger class
 */
public final class Log {
	public static final int NONE = 0;
	public static final int INFO = 1;
	public static final int DEBUG = 2;
	public static final int WARN = 3;
	public static final int ERROR = 4;
	public static final int ALL = 5;
	
	private static int level = ALL;
	
	private static String levelToString(final int level) {
		switch (level) {
		case INFO:
			return "INFO";
		case DEBUG:
			return "DEBUG";
		case WARN: 
			return "WARN";
		case ERROR:
			return "ERROR";
		case ALL: 
			return "ALL";
		default:
			return "UNKNOWN LEVEL";
		}
	}
	
	public static void setLevel(final int level) {
		Log.level = level;
	}
	
	private static void log(final int level, final String message) {
		if (level <= Log.level) {
			System.out.println(levelToString(level) + ": " + message);
		}
	}
	
	public static void info(final String message) {
		log(INFO, message);
	}

	public static void debug(final String message) {
		log(DEBUG, message);
	}
	
	public static void error(final String message) {
		log(ERROR, message);
	}
}
