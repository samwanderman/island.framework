/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.log;

/**
 * Simple Logger class
 */
public class Log {
	// Log levels
	public static final int NONE = 0;
	public static final int INFO = 1;
	public static final int DEBUG = 2;
	public static final int WARN = 3;
	public static final int ERROR = 4;
	public static final int ALL = 5;
	
	// Current log level
	private static int level = ALL;
	
	/**
	 * Level id to level name
	 * 
	 * @param level
	 * @return
	 */
	private static String levelToString(int level) {
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
	
	/**
	 * Set current log level
	 * 
	 * @param level
	 */
	public static void setLevel(int level) {
		Log.level = level;
	}
	
	/**
	 * Base function for logging
	 * 
	 * @param level
	 * @param message
	 */
	private static void log(int level, String message) {
		if (level >= Log.level) {
			System.out.println(levelToString(level) + ": " + message);
		}
	}
	
	/**
	 * Alias for info
	 * 
	 * @param message
	 */
	public static void info(String message) {
		log(INFO, message);
	}

	/**
	 * Alias for debug
	 * 
	 * @param message
	 */
	public static void debug(String message) {
		log(DEBUG, message);
	}
	
	/**
	 * Alias for error
	 * 
	 * @param message
	 */
	public static void error(String message) {
		log(ERROR, message);
	}
}
