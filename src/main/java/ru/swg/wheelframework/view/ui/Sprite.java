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
public class Sprite extends DisplayObject {
	// Element X
	private int x;
	// Element Y
	private int y;
	// Element height
	private int height;
	// Element width
	private int width;
	// Element color - FIXME
	private Color color;
	
	/**
	 * Constructor
	 */
	public Sprite() {
		super();
		x = 0;
		y = 0;
		height = 0;
		width = 0;
		color = Config.DEFAULT_BACKGROUND_COLOR;
	}
	
	@Override
	public void paint(final Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillRect(x, y, x + width, y + height);
	}
	
	/**
	 * Set x coord
	 * 
	 * @param x
	 */
	public void setX(final int x) {
		this.x = x;
	}
	
	/**
	 * Set y coord
	 * 
	 * @param y
	 */
	public void setY(final int y) {
		this.y = y;
	}
	
	/**
	 * Set element width
	 * 
	 * @param width
	 */
	public void setWidth(final int width) {
		this.width = width;
	}
	
	/**
	 * Set element height
	 * 
	 * @param height
	 */
	public void setHeight(final int height) {
		this.height = height;
	}
	
	/**
	 * Set element color
	 * 
	 * @param color
	 */
	public void setColor(final Color color) {
		this.color = color;
	}
}
