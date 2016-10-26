/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view.ui;

import ru.swg.wheelframework.core.Config;
import ru.swg.wheelframework.view.Color;
import ru.swg.wheelframework.view.DisplayObject;
import ru.swg.wheelframework.view.Graphics;

/**
 * Simple sprite
 */
public final class Sprite extends DisplayObject {
	// Element color - FIXME
	private Color color = Config.DEFAULT_BACKGROUND_COLOR;
	private float opacity = 1.0f;
	
	public final void setOpacity(final float opacity) {
		this.opacity = opacity;
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
	public final void paint(final Graphics graphics) {
		graphics.setColor(color);
		graphics.fillRect(getAbsoluteX(), getAbsoluteY(), getWidth(), getHeight());
	}
}
