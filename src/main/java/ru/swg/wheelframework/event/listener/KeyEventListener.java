/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.event.listener;

import ru.swg.wheelframework.event.event.KeyEvent;
import ru.swg.wheelframework.event.interfaces.KeyEventInterface;
import ru.swg.wheelframework.view.DisplayObject;

/**
 * Key event listener
 */
public final class KeyEventListener implements Listener<KeyEvent> {
	// target
	private final KeyEventInterface target;
	
	public KeyEventListener(final KeyEventInterface target) {
		this.target = target;
	}
	
	@Override
	public final void notify(final KeyEvent event) {
		switch (event.getStatus()) {
		case KeyEvent.TYPED:
			target.keyTyped(event);
			break;
		case KeyEvent.PRESSED:
			target.keyPressed(event);
			break;
		case KeyEvent.RELEASED:
			target.keyReleased(event);
			break;
		}
	}

	@Override
	public final boolean checkTarget(final DisplayObject target) {
		return this.target == (KeyEventInterface) target;
	}
}
