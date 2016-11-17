/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.wheel.view.ui;

import ru.samwanderman.wheel.event.event.IKeyEvent;
import ru.samwanderman.wheel.event.event.IMouseEvent;
import ru.samwanderman.wheel.event.event.ISyncEvent;
import ru.samwanderman.wheel.event.event.KeyEvent;
import ru.samwanderman.wheel.event.event.MouseEvent;
import ru.samwanderman.wheel.view.DisplayContainer;
import ru.samwanderman.wheel.view.DisplayObject;
import ru.samwanderman.wheel.view.Padding;

/**
 * Scrolling panel
 */
public class ScrollPanel extends DisplayContainer implements IMouseEvent, ISyncEvent, IKeyEvent {
	private final int MOUSE_DETECT_X_OFFSET = 40;
	private final int MOUSE_DETECT_Y_OFFSET = 40;
	private final int MAP_SPEED = 4;
	private final int KEY_SPEED = 10;

	private final DisplayObject target;
	
	private int offsetX = 0;
	private int offsetY = 0;
	private int speed = 0;
	
	private Padding padding = new Padding(0, 0, 0, 0);
	
	public ScrollPanel(final DisplayObject target, final int width, final int height) {
		super(width, height);
		this.target = target;
		addChild(target);
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
	
	public final void setPadding(final Padding padding) {
		this.padding = padding;
		if (target != null) {
			target.setX(padding.getLeft());
			target.setY(padding.getTop());
		}
	}
	
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
		} else if (x <= getWidth() - target.getWidth() - padding.getRight() - padding.getLeft()) {
			target.setX(getWidth() - target.getWidth() - padding.getRight() - padding.getLeft());
		} else {
			target.setX(x);
		}
	}
	
	private final void setTargetY(final int y) {
		if (y >= padding.getTop()) {
			target.setY(padding.getTop());
		} else if (y <= getHeight() - target.getHeight() - padding.getBottom() - padding.getTop()) {
			target.setY(getHeight() - target.getHeight() - padding.getBottom() - padding.getTop());
		} else {
			target.setY(y);
		}
	}
}
