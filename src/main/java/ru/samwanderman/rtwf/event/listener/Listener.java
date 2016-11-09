/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.rtwf.event.listener;

import ru.samwanderman.rtwf.event.event.Event;
import ru.samwanderman.rtwf.view.DisplayObject;

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
