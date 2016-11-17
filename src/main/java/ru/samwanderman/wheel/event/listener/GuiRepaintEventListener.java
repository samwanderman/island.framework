/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.wheel.event.listener;

import ru.samwanderman.wheel.event.event.GuiRepaintEvent;
import ru.samwanderman.wheel.event.event.IGuiRepaintEvent;
import ru.samwanderman.wheel.view.DisplayObject;

/**
 * Gui repaint event listener
 */
public class GuiRepaintEventListener implements Listener<GuiRepaintEvent> {
	// target
	private final IGuiRepaintEvent target;
	
	/**
	 * Constructor
	 * 
	 * @param target
	 */
	public GuiRepaintEventListener(final IGuiRepaintEvent target) {
		this.target = target;
	}
	
	@Override
	public final void notify(final GuiRepaintEvent event) {
		target.onRepaint();
	}

	@Override
	public final boolean checkTarget(final DisplayObject target) {
		return this.target == (IGuiRepaintEvent) target;
	}
}
