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

/**
 * Events class
 */
public class Events {
	private static Map<Class<? extends Event>, List<Listener<? extends Event>>> listeners = new HashMap<>();
	
	/**
	 * Add event listener
	 * 
	 * @param eventType
	 * @param listener
	 * @return
	 */
	public static boolean addListener(Class<? extends Event> eventType, Listener<? extends Event> listener) {
		List<Listener<? extends Event>> eventListeners = listeners.get(eventType);
		if (eventListeners == null) {
			eventListeners = new ArrayList<>();
		}
		
		if (eventListeners.contains(listener)) {
			return false;
		}
		
		boolean res = eventListeners.add(listener);
		listeners.put(eventType, eventListeners);
		return res;
	}
	
	/**
	 * Remove event listener
	 * 
	 * @param eventType
	 * @param listener
	 * @return
	 */
	public static boolean removeListener(Class<? extends Event> eventType, Listener<? extends Event> listener) {
		List<Listener<? extends Event>> eventListeners = listeners.get(eventType);
		if (eventListeners == null) {
			return false;
		}
		
		if (!eventListeners.contains(listener)) {
			return false;
		}
		
		boolean res = eventListeners.remove(listener);
		listeners.put(eventType, eventListeners);
		return res;
	}
}
