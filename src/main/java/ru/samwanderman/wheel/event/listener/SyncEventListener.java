/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.wheel.event.listener;

import ru.samwanderman.wheel.event.event.SyncEvent;
import ru.samwanderman.wheel.event.interfaces.SyncEventInterface;
import ru.samwanderman.wheel.view.DisplayObject;

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
		target.sync();
	}

	@Override
	public final boolean checkTarget(final DisplayObject target) {
		return this.target == (SyncEventInterface) target;
	}
}
