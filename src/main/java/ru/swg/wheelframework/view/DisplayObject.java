/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view;

import java.awt.Graphics2D;

import ru.swg.wheelframework.event.Events;
import ru.swg.wheelframework.event.event.GuiEvent;
import ru.swg.wheelframework.event.listener.GuiEventListener;

/**
 * Base class for display object
 */
public class DisplayObject {
	// link to parent element
	private DisplayContainer parent = null;
	// Event listener
	private GuiEventListener guiEventListener = new GuiEventListener(this);
	
	/**
	 * Override for component painting
	 * 
	 * @param graphics
	 */
	public void paint(Graphics2D graphics) {
		// TODO
	}

	/**
	 * Set parent element
	 * 
	 * @param parent
	 */
	protected void setParent(DisplayContainer parent) {
		this.parent = parent;
		
		/**
		 * If element unattached - do not handle events
		 */
		if (parent != null) {
			Events.addListener(GuiEvent.class, guiEventListener);
		} else {
			Events.removeListener(GuiEvent.class, guiEventListener);
		}
	}
}
