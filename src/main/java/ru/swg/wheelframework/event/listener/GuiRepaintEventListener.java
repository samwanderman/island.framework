/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.event.listener;

import ru.swg.wheelframework.event.event.GuiRepaintEvent;
import ru.swg.wheelframework.event.interfaces.GuiRepaintEventInterface;
import ru.swg.wheelframework.view.DisplayObject;

/**
 * Gui repaint event listener
 */
public class GuiRepaintEventListener implements Listener<GuiRepaintEvent> {
	// target
	private final GuiRepaintEventInterface target;
	
	/**
	 * Constructor
	 * 
	 * @param target
	 */
	public GuiRepaintEventListener(final GuiRepaintEventInterface target) {
		this.target = target;
	}
	
	@Override
	public final void notify(final GuiRepaintEvent event) {
		target.onRepaint();
	}

	@Override
	public final boolean checkTarget(final DisplayObject target) {
		return this.target == (GuiRepaintEventInterface) target;
	}
}
