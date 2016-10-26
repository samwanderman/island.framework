/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.event.listener;

import ru.swg.wheelframework.event.event.Event;
import ru.swg.wheelframework.view.DisplayObject;

/**
 * Base listener interface
 */
public interface Listener<T extends Event> {
	/**
	 * Notify event
	 * 
	 * @param event
	 */
	void notify(final T event);
	
	/**
	 * Check target
	 * 
	 * @param target
	 * @return
	 */
	boolean checkTarget(final DisplayObject target);
}
