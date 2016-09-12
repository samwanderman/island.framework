/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.event.interfaces;

import ru.swg.wheelframework.event.event.MouseEvent;

/**
 * Mouse event interface
 */
public interface MouseEventInterface {
	// on mouse click
	void mouseClick(final MouseEvent event);
	// on mouse pressed
	void mousePressed(final MouseEvent event);
	// on mouse released
	void mouseReleased(final MouseEvent event);
}
