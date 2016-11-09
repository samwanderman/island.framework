/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.rtwf.view.ui;

import ru.samwanderman.rtwf.core.Config;
import ru.samwanderman.rtwf.view.Color;
import ru.samwanderman.rtwf.view.DisplayObject;
import ru.samwanderman.rtwf.view.Graphics;

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
