/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.event.listener;

import ru.swg.wheelframework.event.Events;
import ru.swg.wheelframework.event.event.GuiEvent;
import ru.swg.wheelframework.view.DisplayContainerInterface;
import ru.swg.wheelframework.view.DisplayObject;

/**
 * Gui event listener
 */
public final class GuiEventListener implements Listener<GuiEvent> {
	// Target
	private final DisplayObject target;
	
	/**
	 * Default constructor
	 * 
	 * @param target
	 */
	public GuiEventListener(final DisplayObject target) {
		this.target = target;
	}
	
	@Override
	public final void notify(final GuiEvent event) {
		if (target != event.getTarget()) {
			return;
		}
		
		target.paint(event.getGraphics());
		
		/**
		 * If object is container - send events to all children
		 * 
		 */
		if (target instanceof DisplayContainerInterface) {
			final DisplayContainerInterface _target = (DisplayContainerInterface) target;
			for (final DisplayObject child: _target.getChildren()) {
				final GuiEvent childEvent = new GuiEvent(child, event.getGraphics());
				Events.dispatch(childEvent);
			}
		}
	}
}
