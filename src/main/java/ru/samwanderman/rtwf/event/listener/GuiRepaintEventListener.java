/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.rtwf.event.listener;

import ru.samwanderman.rtwf.event.event.GuiRepaintEvent;
import ru.samwanderman.rtwf.event.interfaces.GuiRepaintEventInterface;
import ru.samwanderman.rtwf.view.DisplayObject;

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
