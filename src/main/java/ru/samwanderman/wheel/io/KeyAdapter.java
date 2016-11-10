/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.wheel.io;

import java.awt.event.KeyListener;

import ru.samwanderman.wheel.event.Events;
import ru.samwanderman.wheel.event.event.KeyEvent;

/**
 * Key adapter
 */
public final class KeyAdapter implements KeyListener {
	@Override
	public final void keyTyped(final java.awt.event.KeyEvent e) {
		Events.dispatch(new KeyEvent(e.getKeyChar(), KeyEvent.TYPED));
	}
	
	@Override
	public final void keyPressed(final java.awt.event.KeyEvent e) {
		Events.dispatch(new KeyEvent(e.getKeyChar(), KeyEvent.PRESSED));
	}

	@Override
	public final void keyReleased(final java.awt.event.KeyEvent e) {
		Events.dispatch(new KeyEvent(e.getKeyChar(), KeyEvent.RELEASED));
	}
}
