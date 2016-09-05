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
	// Element X
	private int x = 0;
	// Element Y
	private int y = 0;
	// Element height
	private int height = 0;
	// Element width
	private int width = 0;
	// Element color - FIXME
	private Color color = Config.DEFAULT_BACKGROUND_COLOR;
		
	@Override
	public final void paint(final Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillRect(x, y, x + width, y + height);
	}
	
	/**
	 * Set x coord
	 * 
	 * @param x
	 */
	public final void setX(final int x) {
		this.x = x;
	}
	
	/**
	 * Set y coord
	 * 
	 * @param y
	 */
	public final void setY(final int y) {
		this.y = y;
	}
	
	/**
	 * Set element width
	 * 
	 * @param width
	 */
	public final void setWidth(final int width) {
		this.width = width;
	}
	
	/**
	 * Set element height
	 * 
	 * @param height
	 */
	public final void setHeight(final int height) {
		this.height = height;
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
