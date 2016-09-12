/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.event.listener;

import ru.swg.wheelframework.event.event.SyncEvent;
import ru.swg.wheelframework.event.interfaces.SyncEventInterface;

/**
 * Sync event listener
 */
public final class SyncEventListener implements Listener<SyncEvent> {
	// event target
	private final SyncEventInterface target;
	
	/**
	 * Constructor
	 * 
	 * @param target
	 */
	public SyncEventListener(final SyncEventInterface target) {
		this.target = target;
	}
	
	@Override
	final public void notify(final SyncEvent event) {
		target.onSync();
	}
}
