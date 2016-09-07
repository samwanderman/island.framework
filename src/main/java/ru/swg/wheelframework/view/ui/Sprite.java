/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view.ui;

import java.awt.Color;
import java.awt.Graphics2D;

import ru.swg.wheelframework.core.Config;
import ru.swg.wheelframework.event.event.MouseEvent;
import ru.swg.wheelframework.log.Log;
import ru.swg.wheelframework.view.DisplayObject;
import ru.swg.wheelframework.view.MouseEventInterface;

/**
 * Simple sprite
 */
public final class Sprite extends DisplayObject implements MouseEventInterface {
	// Element color - FIXME
	private Color color = Config.DEFAULT_BACKGROUND_COLOR;
	
	@Override
	public void setParent(final DisplayObject parent) {
		super.setParent(parent);
	}
	
	/**
	 * Set element color
	 * 
	 * @param color
	 */
	public final void setColor(final Color color) {
		this.color = color;
	}

	@Override
	public final void paint(final Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillRect(getAbsoluteX(), getAbsoluteY(), getWidth(), getHeight());
	}
	
	@Override
	public void mouseClick(MouseEvent event) {
		Log.info("mouse click");
	}

	@Override
	public void mousePressed(MouseEvent event) {
		Log.info("mouse pressed");
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		Log.info("mouse released");
	}
}
