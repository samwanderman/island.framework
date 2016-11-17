/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.wheel.event.event;

/**
 * Key Event interface
 */
public interface IKeyEvent {
	// on key type
	void keyTyped(final KeyEvent event);
	// on key pressed
	void keyPressed(final KeyEvent event);
	// on key released
	void keyReleased(final KeyEvent event);
}
