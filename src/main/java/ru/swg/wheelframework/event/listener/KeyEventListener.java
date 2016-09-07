/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.event.listener;

import ru.swg.wheelframework.event.event.KeyEvent;
import ru.swg.wheelframework.view.KeyEventInterface;

/**
 * Key event listener
 */
public class KeyEventListener implements Listener<KeyEvent> {
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
}
