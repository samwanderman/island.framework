/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.event.event;

import ru.swg.wheelframework.view.DisplayObject;

/**
 * Class for mouse event
 */
public class MouseEvent implements Event {
	// pressed
	public static final int PRESSED = 1;
	// released
	public static final int RELEASED = 2;
	// clicked
	public static final int CLICKED = 3;
	// moved
	public static final int MOVED = 4;
	// exited
	public static final int EXITED = 5;

	// event target
	private final DisplayObject target;
	// Button number
	private final int num;
	// Event status
	private final int status;
	// x pos
	private final int x;
	// y pos
	private final int y;
	
	/**
	 * Constructor
	 * 
	 * @param target
	 * @param num
	 * @param status
	 * @param x
	 * @param y
	 */
	public MouseEvent(final DisplayObject target, final int num, final int status, final int x, final int y) {
		this.target = target;
		this.num = num;
		this.status = status;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructor for move action
	 * 
	 * @param target
	 * @param status
	 * @param x
	 * @param y
	 */
	public MouseEvent(final DisplayObject target, final int status, final int x, final int y) {
		this.target = target;
		num = 0;
		this.status = status;
		this.x = x;
		this.y = y;		
	}
	
	/**
	 * Get target
	 * 
	 * @return
	 */
	public final DisplayObject getTarget() {
		return target;
	}
	
	/**
	 * Get status
	 * 
	 * @return
	 */
	public final int getStatus() {
		return status;
	}
	
	/**
	 * Get num
	 * 
	 * @return
	 */
	public final int getNum() {
		return num;
	}
	
	/**
	 * Get x
	 * 
	 * @return
	 */
	public final int getX() {
		return x;
	}
	
	/**
	 * Get y
	 * 
	 * @return
	 */
	public final int getY() {
		return y;
	}
}
