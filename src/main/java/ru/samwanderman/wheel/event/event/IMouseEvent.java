/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.wheel.event.event;

/**
 * Mouse event interface
 */
public interface IMouseEvent {
	// on mouse click
	void mouseClick(final MouseEvent event);
	// on mouse pressed
	void mousePressed(final MouseEvent event);
	// on mouse released
	void mouseReleased(final MouseEvent event);
	// on mouse move
	void mouseMoved(final MouseEvent event);
	// on mouse exit
	void mouseExited(final MouseEvent event);
}
