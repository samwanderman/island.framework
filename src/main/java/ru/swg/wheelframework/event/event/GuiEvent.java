/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.event.event;

import ru.swg.wheelframework.view.DisplayObject;
import ru.swg.wheelframework.view.GraphicsAdapter;

/**
 * Simple Gui event
 */
public final class GuiEvent implements Event {
	// Graphics object
	private final GraphicsAdapter graphics;
	// Event target
	private final DisplayObject target;
	
	/**
	 * Constructor
	 * 
	 * @param target
	 * @param graphics
	 */
	public GuiEvent(final DisplayObject target, final GraphicsAdapter graphics) {
		this.target = target;
		this.graphics = graphics;
	}
	
	/**
	 * Get grpahics object
	 * 
	 * @return
	 */
	public final GraphicsAdapter getGraphics() {
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
