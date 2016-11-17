/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.wheel.event.listener;

import ru.samwanderman.wheel.event.event.IKeyEvent;
import ru.samwanderman.wheel.event.event.KeyEvent;
import ru.samwanderman.wheel.view.DisplayObject;

/**
 * Key event listener
 */
public final class KeyEventListener implements Listener<KeyEvent> {
	// target
	private final IKeyEvent target;
	
	public KeyEventListener(final IKeyEvent target) {
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
		return this.target == (IKeyEvent) target;
	}
}
