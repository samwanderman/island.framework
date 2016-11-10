/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.wheel.event.listener;

import ru.samwanderman.wheel.event.Events;
import ru.samwanderman.wheel.event.event.GuiEvent;
import ru.samwanderman.wheel.event.interfaces.GuiEventInterface;
import ru.samwanderman.wheel.view.DisplayContainerInterface;
import ru.samwanderman.wheel.view.DisplayObject;

/**
 * Gui event listener
 */
public final class GuiEventListener implements Listener<GuiEvent> {
	// Target
	private final GuiEventInterface target;
	
	/**
	 * Default constructor
	 * 
	 * @param target
	 */
	public GuiEventListener(final GuiEventInterface target) {
		this.target = target;
	}
	
	@Override
	public final void notify(final GuiEvent event) {
		// If wrong target - exit
		if (target != event.getTarget()) {
			return;
		}

		target.paint(event.getGraphics());
		
		// If object is container - send events to all children
		if (target instanceof DisplayContainerInterface) {
			final DisplayContainerInterface _target = (DisplayContainerInterface) target;
			for (final DisplayObject child: _target.getChildren()) {
				Events.dispatch(new GuiEvent(child, event.getGraphics()));
			}
		}
	}

	@Override
	public final boolean checkTarget(final DisplayObject target) {
		return this.target == (GuiEventInterface) target;
	}
}
