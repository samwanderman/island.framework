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
	private Graphics2D graphics;
	private DisplayObject target;
	
	public GuiEvent(final DisplayObject target, final Graphics2D graphics) {
		this.target = target;
		this.graphics = graphics;
	}
	
	public Graphics2D getGraphics() {
		return graphics;
	}
	
	public DisplayObject getTarget() {
		return target;
	}
}
