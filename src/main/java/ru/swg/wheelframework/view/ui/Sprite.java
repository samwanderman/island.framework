/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view.ui;

import java.awt.Color;
import java.awt.Graphics2D;

import ru.swg.wheelframework.core.Config;
import ru.swg.wheelframework.view.DisplayObject;

/**
 * Simple sprite
 */
public final class Sprite extends DisplayObject {
	// Element color - FIXME
	private Color color = Config.DEFAULT_BACKGROUND_COLOR;
		
	@Override
	public final void paint(final Graphics2D graphics) {
		super.paint(graphics);
		graphics.setColor(color);
		final int x = getParent().getX() + getX(), y = getParent().getY() + getY(); 
		graphics.fillRect(x, y, x + getWidth(), y + getHeight());
	}
	
	/**
	 * Set element color
	 * 
	 * @param color
	 */
	public final void setColor(final Color color) {
		this.color = color;
	}
}
