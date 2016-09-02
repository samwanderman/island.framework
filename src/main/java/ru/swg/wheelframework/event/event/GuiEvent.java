/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.event.event;

import java.awt.Graphics2D;

/**
 * Basic GUI event
 */
public class GuiEvent implements Event {
	private Graphics2D graphics;
	
	/**
	 * Constructor
	 * 
	 * @param graphics
	 */
	public GuiEvent(Graphics2D graphics) {
		this.graphics = graphics;
	}
	
	/**
	 * Get graphics from event
	 * 
	 * @return
	 */
	public Graphics2D getGraphics() {
		return graphics;
	}
}
