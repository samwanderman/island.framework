/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.wheel.animation;

import ru.samwanderman.wheel.event.interfaces.AnimationInterface;
import ru.samwanderman.wheel.event.listener.ObjectListener;

/**
 * Animation interface
 */
public class Animation implements AnimationInterface {
	private boolean running = false;
	private ObjectListener successCallback = null;
	private ObjectListener errorCallback = null;
	
	public Animation() { }
	
	public Animation(final ObjectListener successCallback, final ObjectListener errorCallback) {
		this.successCallback = successCallback;
		this.errorCallback = errorCallback;
	}
	
	@Override
	public void start() {
		running = true;
	}

	@Override
	public void stop() {
		running = false;
	}

	@Override
	public final void restart() {
		stop();
		start();
	}
	
	@Override
	public void reset() { }

	@Override
	public void run() { }

	@Override
	public final boolean isRunning() {
		return running;
	}
	
	protected final ObjectListener getSuccessCallback() {
		return successCallback;
	}
	
	protected final ObjectListener getErrorCallback() {
		return errorCallback;
	}
}
