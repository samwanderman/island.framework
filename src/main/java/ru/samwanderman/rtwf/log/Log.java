/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.rtwf.log;

/**
 * Simple Logger class
 */
public final class Log {
	// No logging
	public static final int NONE = 0;
	// show info messages
	public static final int INFO = 1;
	// show debug messages and info
	public static final int DEBUG = 2;
	// show warnings, debug and info
	public static final int WARN = 3;
	// show errors, warnings, debug and info
	public static final int ERROR = 4;
	// show all messages
	public static final int ALL = 5;
	
	// Current log level
	private static int level = ALL;
	
	/**
	 * Level id to string
	 * 
	 * @param level
	 * @return
	 */
	private static final String levelToString(final int level) {
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
	 * Set log level
	 * 
	 * @param level
	 */
	protected static final void setLevel(final int level) {
		Log.level = level;
	}
	
	/**
	 * Inner log function
	 * 
	 * @param level
	 * @param message
	 */
	private static final void log(final int level, final String message) {
		if (level <= Log.level) {
			System.out.print(levelToString(level) + ": " + message);
		}
	}
	
	/**
	 * Inner log function
	 * 
	 * @param message
	 */
	public static final void log(final String message) {
		System.out.print(message);
	}
	
	/**
	 * Print info
	 * 
	 * @param message
	 */
	public static final void info(final String message) {
		log(INFO, message + "\r\n");
	}

	/**
	 * Print debug
	 * 
	 * @param message
	 */
	public static final void debug(final String message) {
		log(DEBUG, message + "\r\n");
	}
	
	/**
	 * Print error
	 * 
	 * @param message
	 */
	public static final void error(final String message) {
		log(ERROR, message + "\r\n");
	}
}
