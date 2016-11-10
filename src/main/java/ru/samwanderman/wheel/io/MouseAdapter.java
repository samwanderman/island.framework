/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.wheel.io;

import ru.samwanderman.wheel.event.Events;
import ru.samwanderman.wheel.event.event.MouseEvent;
import ru.samwanderman.wheel.view.DisplayObject;

/**
 * Mouse Adapter - translate java standart mouse events to framework mouse
 * events
 */
public class MouseAdapter extends java.awt.event.MouseAdapter {
	// main event target
	private final DisplayObject target;

	/**
	 * Constructor
	 * 
	 * @param target
	 */
	public MouseAdapter(final DisplayObject target) {
		this.target = target;
	}

	@Override
	public void mouseClicked(final java.awt.event.MouseEvent e) {
		Events.dispatch(new MouseEvent(target, e.getButton(), MouseEvent.CLICKED, e.getX(), e.getY()));
	}

	@Override
	public final void mousePressed(final java.awt.event.MouseEvent e) {
		Events.dispatch(new MouseEvent(target, e.getButton(), MouseEvent.PRESSED, e.getX(), e.getY()));
	}

	@Override
	public final void mouseReleased(final java.awt.event.MouseEvent e) {
		Events.dispatch(new MouseEvent(target, e.getButton(), MouseEvent.RELEASED, e.getX(), e.getY()));
	}

	@Override
	public void mouseMoved(final java.awt.event.MouseEvent e) {
		Events.dispatch(new MouseEvent(target, MouseEvent.MOVED, e.getX(), e.getY()));
	}

	@Override
	public final void mouseExited(final java.awt.event.MouseEvent e) {
		Events.dispatch(new MouseEvent(target, MouseEvent.EXITED, e.getX(), e.getY()));
	}
	
	@Override
	public final void mouseDragged(final java.awt.event.MouseEvent e) {
		Events.dispatch(new MouseEvent(target, MouseEvent.MOVED, e.getX(), e.getY()));
	}
}
