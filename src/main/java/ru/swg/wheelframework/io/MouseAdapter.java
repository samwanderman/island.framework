/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.io;

import ru.swg.wheelframework.event.Events;
import ru.swg.wheelframework.event.event.MouseEvent;
import ru.swg.wheelframework.view.DisplayObject;

/**
 * Mouse Adapter - translate java standart mouse events to framework mouse events
 */
public final class MouseAdapter extends java.awt.event.MouseAdapter {
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
    public void mousePressed(final java.awt.event.MouseEvent e) {
		Events.dispatch(new MouseEvent(target, e.getButton(), MouseEvent.PRESSED, e.getX(), e.getY()));
	}
	
	@Override
    public void mouseReleased(final java.awt.event.MouseEvent e) {
		Events.dispatch(new MouseEvent(target, e.getButton(), MouseEvent.RELEASED, e.getX(), e.getY()));
	}
}
