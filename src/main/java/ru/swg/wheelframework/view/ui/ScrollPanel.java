/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view.ui;

import ru.swg.wheelframework.event.Events;
import ru.swg.wheelframework.event.event.KeyEvent;
import ru.swg.wheelframework.event.event.MouseEvent;
import ru.swg.wheelframework.event.event.SyncEvent;
import ru.swg.wheelframework.event.interfaces.KeyEventInterface;
import ru.swg.wheelframework.event.interfaces.MouseEventInterface;
import ru.swg.wheelframework.event.interfaces.SyncEventInterface;
import ru.swg.wheelframework.event.listener.KeyEventListener;
import ru.swg.wheelframework.event.listener.MouseEventListener;
import ru.swg.wheelframework.event.listener.SyncEventListener;
import ru.swg.wheelframework.view.DisplayContainer;
import ru.swg.wheelframework.view.DisplayObject;
import ru.swg.wheelframework.view.Padding;

/**
 * Scrolling panel
 */
public class ScrollPanel extends DisplayContainer implements MouseEventInterface, SyncEventInterface, KeyEventInterface {
	private final int MOUSE_DETECT_X_OFFSET = 40;
	private final int MOUSE_DETECT_Y_OFFSET = 40;
	private final int MAP_SPEED = 4;
	private final int KEY_SPEED = 10;
	
	private Padding padding = new Padding(0, 0, 0, 0);
	
	// listeners
	private final MouseEventListener mouseEventListener = new MouseEventListener(this);
	private final SyncEventListener syncEventListener = new SyncEventListener(this);
	private final KeyEventListener keyEventListener = new KeyEventListener(this);

	private final DisplayObject target;
	
	private int offsetX = 0;
	private int offsetY = 0;
	private int speed = 0;
	
	public ScrollPanel(final DisplayObject target, final int width, final int height) {
		super(width, height);
		this.target = target;
		addChild(target);
	}
	
	public final void setPadding(final Padding padding) {
		if (padding != null) {
			this.padding = padding;
		} else {
			this.padding = new Padding(0, 0, 0, 0);
		}
	}
	
	public final int getOffsetX() {
		return offsetX;
	}
	
	public final int getOffsetY() {
		return offsetY;
	}
	
	public final void setOffsetX(final int offsetX) {
		this.offsetX = offsetX;
	}
	
	public final void setOffsetY(final int offsetY) {
		this.offsetY = offsetY;
	}
	
	// listeners
	@Override
	protected final void registerListeners() {
		super.registerListeners();
		Events.addListener(MouseEvent.class, mouseEventListener);
		Events.addListener(SyncEvent.class, syncEventListener);
		Events.addListener(KeyEvent.class, keyEventListener);
	};
	
	@Override
	protected final void unregisterListeners() {
		super.unregisterListeners();
		Events.removeListener(MouseEvent.class, mouseEventListener);
		Events.removeListener(SyncEvent.class, syncEventListener);
		Events.removeListener(KeyEvent.class, keyEventListener);
	};
	
	@Override
	public final void keyTyped(final KeyEvent event) {
		switch (event.getCode()) {
		case 97:
			setTargetX(target.getX() + KEY_SPEED);
			break;
		case 100:
			setTargetX(target.getX() - KEY_SPEED);
			break;
		case 115:
			setTargetY(target.getY() - KEY_SPEED);
			break;
		case 119:
			setTargetY(target.getY() + KEY_SPEED);
			break;
		default:
		}
	}
	
	@Override
	public final void keyPressed(final KeyEvent event) { }
	@Override
	public final void keyReleased(final KeyEvent event) { }
	
	@Override
	public final void sync() {
		if (speed++ >= MAP_SPEED) {
			speed = 0;
			if (offsetX != 0) {
				setTargetX(target.getX() + offsetX);
			}
			
			if (offsetY != 0) {				
				setTargetY(target.getY() + offsetY);
			}
		}
	}
	
	@Override
	public final void mouseClick(final MouseEvent event) { }
	@Override
	public final void mousePressed(final MouseEvent event) { }
	@Override
	public final void mouseReleased(final MouseEvent event) { }
	
	@Override
	public final void mouseMoved(final MouseEvent event) {
		if ((event.getX() <= MOUSE_DETECT_X_OFFSET) && (event.getX() >= 0)) {
			offsetX = 1;
		} else if ((event.getX() >= getWidth() - MOUSE_DETECT_X_OFFSET) && (event.getX() < getWidth())) {
			offsetX = -1;
		} else {
			offsetX = 0;
		}

		if ((event.getY() <= MOUSE_DETECT_Y_OFFSET) && (event.getY() >= 0)) {
			offsetY = 1;
		} else if ((event.getY() >= getHeight() - MOUSE_DETECT_Y_OFFSET) && (event.getY() < getHeight())) {
			offsetY = -1;
		} else {
			offsetY = 0;
		}
	}
	
	@Override
	public final void mouseExited(final MouseEvent event) {
		offsetX = 0;
		offsetY = 0;
	}
	
	private final void setTargetX(final int x) {
		if (x >= padding.getLeft()) {
			target.setX(padding.getLeft());
		} else if (x >= getWidth() - target.getWidth() - padding.getRight()) {
			target.setX(getWidth() - target.getWidth() - padding.getRight());
		} else {
			target.setX(x);	
		}
	}
	
	private final void setTargetY(final int y) {
		if (y >= padding.getTop()) {
			target.setY(padding.getTop());
		} else if (y <= getHeight() - target.getHeight() - padding.getBottom()) {
			target.setY(getHeight() - target.getHeight() - padding.getBottom());
		} else {
			target.setY(y);	
		}
	}
}
