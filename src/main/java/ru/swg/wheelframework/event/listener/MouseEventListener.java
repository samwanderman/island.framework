/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.event.listener;

import ru.swg.wheelframework.event.Events;
import ru.swg.wheelframework.event.event.MouseEvent;
import ru.swg.wheelframework.view.DisplayContainerInterface;
import ru.swg.wheelframework.view.DisplayObject;
import ru.swg.wheelframework.view.MouseEventInterface;

/**
 * Mouse event listener
 */
public class MouseEventListener implements Listener<MouseEvent> {
	// Target
	private final DisplayObject target;

	/**
	 * Constructor
	 * 
	 * @param target
	 */
	public MouseEventListener(final DisplayObject target) {
		this.target = target;
	}
	
	@Override
	public final void notify(final MouseEvent event) {
		if (target != event.getTarget()) {
			return;
		}
		
		if (target instanceof MouseEventInterface) {
			final MouseEventInterface _target = (MouseEventInterface) target;
			switch (event.getStatus()) {
			case MouseEvent.CLICKED:
				_target.mouseClick(event);
				break;
			case MouseEvent.PRESSED:
				_target.mousePressed(event);
				break;
			case MouseEvent.RELEASED:
				_target.mouseReleased(event);
				break;
			}
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
}
