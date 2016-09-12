/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.event.interfaces;

import ru.swg.wheelframework.event.event.KeyEvent;

/**
 * Key Event interface
 */
public interface KeyEventInterface {
	// on key type
	void keyTyped(final KeyEvent event);
	// on key pressed
	void keyPressed(final KeyEvent event);
	// on key released
	void keyReleased(final KeyEvent event);
}
