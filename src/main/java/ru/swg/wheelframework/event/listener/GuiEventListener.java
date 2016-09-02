/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.event.listener;

import ru.swg.wheelframework.event.event.GuiEvent;
import ru.swg.wheelframework.view.DisplayObject;

/**
 * Gui event listener
 */
public class GuiEventListener implements Listener<GuiEvent> {
	private DisplayObject target = null;
	
	public GuiEventListener(DisplayObject target) {
		this.target = target;
	}

	/**
	 * Handle event
	 * 
	 * @param event
	 */
	@Override
	public void notify(GuiEvent event) {
		target.paint(event.getGraphics());
	}
}
