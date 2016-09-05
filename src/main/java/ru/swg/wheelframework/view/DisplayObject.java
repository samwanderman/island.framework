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
	// Parent
	private DisplayObject parent = null;
	// Default GuiEventListener
	private final GuiEventListener guiEventListener = new GuiEventListener(this);
	
	/**
	 * Override this to paint element
	 * 
	 * @param graphics
	 */
	public void paint(final Graphics2D graphics) { }
	
	/**
	 * Set parent of this child
	 * 
	 * @param parent
	 */
	protected final void setParent(final DisplayObject parent) {
		this.parent = parent;
		
		if (parent != null) {
			Events.addListener(GuiEvent.class, guiEventListener);
		} else {
			Events.removeListener(GuiEvent.class, guiEventListener);
		}
	}
}
