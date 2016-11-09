/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.rtwf.event.listener;

import ru.samwanderman.rtwf.event.Events;
import ru.samwanderman.rtwf.event.event.MouseEvent;
import ru.samwanderman.rtwf.event.interfaces.MouseEventInterface;
import ru.samwanderman.rtwf.view.DisplayContainerInterface;
import ru.samwanderman.rtwf.view.DisplayObject;

/**
 * Mouse event listener
 */
public final class MouseEventListener implements Listener<MouseEvent> {
	// Target
	private final MouseEventInterface target;

	/**
	 * Constructor
	 * 
	 * @param target
	 */
	public MouseEventListener(final MouseEventInterface target) {
		this.target = target;
	}
	
	@Override
	public final void notify(final MouseEvent event) {
		if (target != event.getTarget()) {
			return;
		}
		
		switch (event.getStatus()) {
		case MouseEvent.CLICKED:
			target.mouseClick(event);
			break;
		case MouseEvent.PRESSED:
			target.mousePressed(event);
			break;
		case MouseEvent.RELEASED:
			target.mouseReleased(event);
			break;
		case MouseEvent.MOVED:
			target.mouseMoved(event);
			break;
		case MouseEvent.EXITED:
			target.mouseExited(event);
		}
		
		// If object is container - send events to all children
		if (target instanceof DisplayContainerInterface) {
			final DisplayContainerInterface _target = (DisplayContainerInterface) target;
			final int x = event.getX(), y = event.getY();
			for (final DisplayObject child: _target.getChildren()) {
				if (child.getBoundRect().contains(x, y)) {
					Events.dispatch(new MouseEvent(child, event.getNum(), event.getStatus(), x, y));
				}
			}
		}
	}

	@Override
	public final boolean checkTarget(final DisplayObject target) {
		return this.target == (MouseEventInterface) target;
	}
}
