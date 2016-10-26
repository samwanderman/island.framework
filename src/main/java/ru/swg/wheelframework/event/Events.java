/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.swg.wheelframework.event.event.Event;
import ru.swg.wheelframework.event.listener.Listener;
import ru.swg.wheelframework.view.DisplayObject;

/**
 * Class for events manipulating
 */
public final class Events {
	private static final Map<Class<? extends Event>, List<Listener<? extends Event>>> listeners = new HashMap<>();
	
	/**
	 * Add listener
	 * 
	 * @param eventType
	 * @param listener
	 * @return
	 */
	public static final boolean addListener(final Class<? extends Event> eventType, final Listener<? extends Event> listener) {
		List<Listener<? extends Event>> eventListeners = listeners.get(eventType);
		
		if (eventListeners == null) {
			eventListeners = new ArrayList<>();
		} else if (eventListeners.contains(listener)) {
			return false;
		}
		
		eventListeners.add(listener);
		listeners.put(eventType, eventListeners);
		
		return true;
	}
	
	/**
	 * Remove listener
	 * 
	 * @param eventType
	 * @param listener
	 * @return
	 */
	public static final boolean removeListener(final Class<? extends Event> eventType, final Listener<? extends Event> listener) {
		final List<Listener<? extends Event>> eventListeners = listeners.get(eventType);
		
		if (eventListeners == null) {
			return false;
		} else if (!eventListeners.contains(listener)) {
			return false;
		}
		
		eventListeners.remove(listener);
		listeners.put(eventType, eventListeners);
		
		return true;
	}
	
	/**
	 * Remove listener
	 * 
	 * @param eventType
	 * @param target
	 * @return
	 */
	public static final boolean removeListeners(final Class<? extends Event> eventType, final DisplayObject target) {
		final List<Listener<? extends Event>> eventListeners = listeners.get(eventType);
		
		if (eventListeners == null) {
			return false;
		}
		
		for (final Listener<? extends Event> listener: eventListeners) {
			if (listener.checkTarget(target)) {
				return removeListener(eventType, listener);
			}
		}
		
		return true;
	}

	/**
	 * dispatch event
	 * 
	 * @param event
	 */
	// FIXME - how to make it clear?
	public static final <T extends Event> void dispatch(final T event) {
		final List<Listener<? extends Event>> eventListeners = listeners.get(event.getClass());
		
		if (eventListeners == null) {
			return;
		}
		
		for (final Listener listener: eventListeners) {
			listener.notify(event);
		}
	}
}
