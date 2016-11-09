/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.rtwf.event.event;

/**
 * Key event
 */
public class KeyEvent implements Event {
	// pressed
	public static final int PRESSED = 1;
	// released
	public static final int RELEASED = 2;
	// clicked
	public static final int TYPED = 3;

	// Key code
	private final int code;
	// Event status
	private final int status;
	
	/**
	 * Constructor
	 * 
	 * @param code
	 * @param status
	 */
	public KeyEvent(final int code, final int status) {
		this.code = code;
		this.status = status;
	}
	
	/**
	 * Get code
	 * 
	 * @return
	 */
	public final int getCode() {
		return code;
	}
	
	/**
	 * Get status
	 * 
	 * @return
	 */
	public final int getStatus() {
		return status;
	}
}
