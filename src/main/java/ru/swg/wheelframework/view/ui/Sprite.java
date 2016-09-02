/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view.ui;

import java.awt.Color;
import java.awt.Graphics2D;

import ru.swg.wheelframework.view.DisplayObject;

/**
 * Simple sprite
 */
public class Sprite extends DisplayObject {
	@Override
	public void paint(Graphics2D graphics) {
		super.paint(graphics);
		graphics.setColor(Color.BLUE);
		graphics.fillRect(0, 0, 100, 100);
	}
}
