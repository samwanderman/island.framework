/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.wheel.event.event;

import ru.samwanderman.wheel.view.Graphics;

/**
 * Interface for gui event handling
 */
public interface IGuiEvent {
	void paint(final Graphics graphics);
}
