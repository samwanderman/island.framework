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
	// Element X
	private int x = 0;
	// Element Y
	private int y = 0;
	// Element height
	private int height = 0;
	// Element width
	private int width = 0;
	// Parent
	private DisplayObject parent = null;
	// Default GuiEventListener
	private final GuiEventListener guiEventListener = new GuiEventListener(this);
	
	/**
	 * Get x
	 */
	public final int getX() {
		return x;
	}
	
	/**
	 * Set x
	 * 
	 * @param x
	 */
	protected final void setX(final int x) {
		this.x = x;
	}

	/**
	 * Get absolute x
	 * 
	 * @return
	 */
	protected final int getAbsoluteX() {
		return x + (parent == null ? 0 : parent.getAbsoluteX());
	}

	/**
	 * Get y
	 */
	public final int getY() {
		return y;
	}

	/**
	 * Set y
	 * 
	 * @param y
	 */
	protected final void setY(final int y) {
		this.y = y;
	}

	/**
	 * Get absolute x
	 * 
	 * @return
	 */
	protected final int getAbsoluteY() {
		return y + (parent == null ? 0 : parent.getAbsoluteY());
	}
	
	/**
	 * Get element width
	 */
	protected final int getWidth() {
		return width;
	}
	
	/**
	 * Set element width
	 * 
	 * @param width
	 */
	protected final void setWidth(final int width) {
		this.width = width;
	}
	
	/**
	 * Get element height
	 */
	protected final int getHeight() {
		return height;
	}
	
	/**
	 * Set element height
	 * 
	 * @param height
	 */
	protected final void setHeight(final int height) {
		this.height = height;
	}
	
	/**
	 * Override this to paint element
	 * 
	 * @param graphics
	 */
	public void paint(final Graphics2D graphics) { }
	
	/**
	 * Get parent
	 * 
	 * @return
	 */
	protected final DisplayObject getParent() {
		return parent;
	}
	
	/**
	 * Set parent of this child
	 * 
	 * @param parent
	 */
	public final void setParent(final DisplayObject parent) {
		this.parent = parent;
		
		if (parent != null) {
			Events.addListener(GuiEvent.class, guiEventListener);
		} else {
			Events.removeListener(GuiEvent.class, guiEventListener);
		}
	}
}
