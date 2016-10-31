/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.animation;

import ru.swg.wheelframework.event.interfaces.AnimationInterface;
import ru.swg.wheelframework.event.listener.ObjectListener;

/**
 * Animation interface
 */
public class Animation implements AnimationInterface {
	private boolean running = false;
	private ObjectListener<Object> onSuccess = null;
	private ObjectListener<Object> onError = null;
	
	public Animation() { }
	
	public Animation(final ObjectListener<Object> onSuccess, final ObjectListener<Object> onError) {
		this.onSuccess = onSuccess;
		this.onError = onError;
	}
	
	@Override
	public final void start() {
		running = true;
	}

	@Override
	public final void stop() {
		running = false;
	}

	@Override
	public final void restart() {
		stop();
		start();
	}

	@Override
	public void run() { }

	@Override
	public final boolean isRunning() {
		return running;
	}
}
