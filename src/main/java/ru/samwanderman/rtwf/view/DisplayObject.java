/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.rtwf.view;

import ru.samwanderman.rtwf.event.Events;
import ru.samwanderman.rtwf.event.event.GuiEvent;
import ru.samwanderman.rtwf.event.event.GuiRepaintEvent;
import ru.samwanderman.rtwf.event.event.KeyEvent;
import ru.samwanderman.rtwf.event.event.MouseEvent;
import ru.samwanderman.rtwf.event.event.SyncEvent;
import ru.samwanderman.rtwf.event.interfaces.GuiEventInterface;
import ru.samwanderman.rtwf.event.interfaces.GuiRepaintEventInterface;
import ru.samwanderman.rtwf.event.interfaces.KeyEventInterface;
import ru.samwanderman.rtwf.event.interfaces.MouseEventInterface;
import ru.samwanderman.rtwf.event.interfaces.SyncEventInterface;
import ru.samwanderman.rtwf.event.listener.GuiEventListener;
import ru.samwanderman.rtwf.event.listener.GuiRepaintEventListener;
import ru.samwanderman.rtwf.event.listener.KeyEventListener;
import ru.samwanderman.rtwf.event.listener.MouseEventListener;
import ru.samwanderman.rtwf.event.listener.SyncEventListener;
import ru.samwanderman.rtwf.view.figure.Rectangle;

/**
 * Main class to display object
 */
public class DisplayObject implements GuiEventInterface {
	// Element X
	private int x = 0;
	// Element Y
	private int y = 0;
	// Element z
	private int z = 0;
	// Element height
	private int height = 0;
	// Element width
	private int width = 0;
	// Parent
	private DisplayObject parent = null;

	/**
	 * Constructor
	 * 
	 */
	public DisplayObject() { }
	
	/**
	 * Constructor
	 * 
	 * @param width
	 * @param height
	 */
	public DisplayObject(final int width, final int height) {
		this.width = width;
		this.height = height;
	}
	
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
	public void setX(final int x) {
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
	public void setY(final int y) {
		this.y = y;
	}
	
	/**
	 * Set z
	 * 
	 * @param z
	 */
	protected final void setZ(final int z) {
		this.z = z;
	}
	
	/**
	 * Get z coord
	 * 
	 * @return
	 */
	public final int getZ() {
		return z;
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
	public int getWidth() {
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
	public int getHeight() {
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
	public final DisplayObject getParent() {
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
			if (this instanceof GuiEventInterface) {
				Events.addListener(GuiEvent.class, new GuiEventListener((GuiEventInterface) this));
			}
			
			if (this instanceof GuiRepaintEventInterface) {
				Events.addListener(GuiRepaintEvent.class, new GuiRepaintEventListener((GuiRepaintEventInterface) this));
			}
			
			if (this instanceof KeyEventInterface) {
				Events.addListener(KeyEvent.class, new KeyEventListener((KeyEventInterface) this));
			}
			
			if (this instanceof MouseEventInterface) {
				Events.addListener(MouseEvent.class, new MouseEventListener((MouseEventInterface) this));
			}
			
			if (this instanceof SyncEventInterface) {
				Events.addListener(SyncEvent.class, new SyncEventListener((SyncEventInterface) this));
			}
		} else {
			if (this instanceof GuiEventInterface) {
				Events.removeListeners(GuiEvent.class, this);
			}
			
			if (this instanceof GuiRepaintEventInterface) {
				Events.removeListeners(GuiRepaintEvent.class, this);
			}
			
			if (this instanceof KeyEventInterface) {
				Events.removeListeners(KeyEvent.class, this);
			}
			
			if (this instanceof MouseEventInterface) {
				Events.removeListeners(MouseEvent.class, this);
			}
			
			if (this instanceof SyncEventInterface) {
				Events.removeListeners(SyncEvent.class, this);
			}
		}
	}
	
	/**
	 * Get absolute bound rect
	 * 
	 * @return
	 */
	public Rectangle getBoundRect() {
		return new Rectangle(getAbsoluteX(), getAbsoluteY(), width, height);
	}

	// Gui events
	@Override
	public void paint(final Graphics graphics) { }
	
	protected void update() {
		Events.dispatch(new GuiRepaintEvent());
	}
}
