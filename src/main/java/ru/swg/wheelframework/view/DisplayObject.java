/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import ru.swg.wheelframework.event.Events;
import ru.swg.wheelframework.event.event.GuiEvent;
import ru.swg.wheelframework.event.event.KeyEvent;
import ru.swg.wheelframework.event.event.MouseEvent;
import ru.swg.wheelframework.event.listener.GuiEventListener;
import ru.swg.wheelframework.event.listener.KeyEventListener;
import ru.swg.wheelframework.event.listener.MouseEventListener;

/**
 * Main class to display object
 */
public class DisplayObject implements GuiEventInterface, MouseEventInterface, KeyEventInterface {
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
	// Default GuiEventListener
	private final MouseEventListener mouseEventListener = new MouseEventListener(this);
	// Default GuiEventListener
	private final KeyEventListener keyEventListener = new KeyEventListener(this);

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
	public final int getAbsoluteX() {
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
	public final int getAbsoluteY() {
		return y + (parent == null ? 0 : parent.getAbsoluteY());
	}
	
	/**
	 * Get element width
	 */
	public final int getWidth() {
		return width;
	}
	
	/**
	 * Set element width
	 * 
	 * @param width
	 */
	public final void setWidth(final int width) {
		this.width = width;
	}
	
	/**
	 * Get element height
	 */
	public final int getHeight() {
		return height;
	}
	
	/**
	 * Set element height
	 * 
	 * @param height
	 */
	public final void setHeight(final int height) {
		this.height = height;
	}
	
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
	protected void setParent(final DisplayObject parent) {
		this.parent = parent;		
		
		if (parent != null) {
			registerListeners();
		} else {
			unregisterListeners();
		}
	}
	
	/**
	 * Get absolute bound rect
	 * 
	 * @return
	 */
	public final Rectangle getBoundRect() {
		return new Rectangle(getAbsoluteX(), getAbsoluteY(), width, height);
	}
	
	/**
	 * Register listeners
	 * 
	 */
	protected void registerListeners() {
		Events.addListener(GuiEvent.class, guiEventListener);
		Events.addListener(MouseEvent.class, mouseEventListener);
		Events.addListener(KeyEvent.class, keyEventListener);
	}
	
	/**
	 * Unregister listeners
	 * 
	 */
	protected void unregisterListeners() {
		Events.removeListener(GuiEvent.class, guiEventListener);
		Events.removeListener(MouseEvent.class, mouseEventListener);
		Events.removeListener(KeyEvent.class, keyEventListener);
	}

	// Gui events
	@Override
	public void paint(final Graphics2D graphics) { }
	
	// Mouse events
	@Override
	public void mouseClick(MouseEvent event) { }

	@Override
	public void mousePressed(MouseEvent event) { }

	@Override
	public void mouseReleased(MouseEvent event) { }
	
	// Key events
	@Override
	public void keyTyped(KeyEvent event) { }

	@Override
	public void keyPressed(KeyEvent event) { }

	@Override
	public void keyReleased(KeyEvent event) { }
}
