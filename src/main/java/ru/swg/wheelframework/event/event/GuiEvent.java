/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.event.event;

import java.awt.Graphics2D;

import ru.swg.wheelframework.view.DisplayObject;

/**
 * Simple Gui event
 */
public final class GuiEvent implements Event {
	// Graphics object
	private final Graphics2D graphics;
	// Event target
	private final DisplayObject target;
	
	/**
	 * Constructor
	 * 
	 * @param target
	 * @param graphics
	 */
	public GuiEvent(final DisplayObject target, final Graphics2D graphics) {
		this.target = target;
		this.graphics = graphics;
	}
	
	/**
	 * Get grpahics object
	 * 
	 * @return
	 */
	public final Graphics2D getGraphics() {
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
