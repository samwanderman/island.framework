/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view;

import java.awt.Graphics2D;

import ru.swg.wheelframework.event.Events;
import ru.swg.wheelframework.event.event.GuiEvent;
import ru.swg.wheelframework.event.listener.GuiEventListener;

/**
 * Main class to display object
 */
public class DisplayObject {
	private DisplayObject parent = null;
	
	private final GuiEventListener guiEventListener = new GuiEventListener(this);
	
	public void paint(final Graphics2D graphics) { }
	
	public void setParent(final DisplayObject parent) {
		this.parent = parent;
		
		if (parent != null) {
			Events.addListener(GuiEvent.class, guiEventListener);
		} else {
			Events.removeListener(GuiEvent.class, guiEventListener);
		}
	}
}
