/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.rtwf.event.listener;

import ru.samwanderman.rtwf.event.event.KeyEvent;
import ru.samwanderman.rtwf.event.interfaces.KeyEventInterface;
import ru.samwanderman.rtwf.view.DisplayObject;

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
