/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.event.listener;

import ru.swg.wheelframework.event.event.Event;

/**
 * Base listener interface
 */
public interface Listener<T extends Event> {
	void notify(final T event);
}
