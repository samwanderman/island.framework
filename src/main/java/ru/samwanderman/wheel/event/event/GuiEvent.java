/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.wheel.event.event;

import ru.samwanderman.wheel.view.DisplayObject;
import ru.samwanderman.wheel.view.Graphics;

/**
 * Simple Gui event
 */
public final class GuiEvent implements Event {
	// Graphics object
	private final Graphics graphics;
	// Event target
	private final DisplayObject target;
	
	/**
	 * Constructor
	 * 
	 * @param target
	 * @param graphics
	 */
	public GuiEvent(final DisplayObject target, final Graphics graphics) {
		this.target = target;
		this.graphics = graphics;
	}
	
	/**
	 * Get grpahics object
	 * 
	 * @return
	 */
	public final Graphics getGraphics() {
		return graphics;
	}
	
	/**
	 * Get event target
	 * 
	 * @return
	 */
	public final DisplayObject getTarget() {
		return target;
	}
}
