package ru.swg.wheelframework.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Line2D;

import ru.swg.wheelframework.view.figure.Rectangle;

/**
 * Graphics adapter
 */
public final class GraphicsAdapter {
	private final Graphics2D g2d;
	
	public GraphicsAdapter(final Graphics g2d) {
		this.g2d = (Graphics2D) g2d;
	}
	
	public final void setColor(final Color color) {
		g2d.setColor(color);
	}

	public final void fillRect(final int x, final int y, final int width, final int height) {
		g2d.fillRect(x, y, width, height);
	}
	
	public final void drawImage(final Image image, final int x, final int y) {
		g2d.drawImage(image, x, y, null);
	}
	
	public final void drawLine(final int x1, final int y1, final int x2, final int y2) {
		g2d.draw(new Line2D.Float(x1, y1, x2, y2));
	}
	
	public final void draw(final Rectangle rect) {
		g2d.draw(new java.awt.Rectangle(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight()));
	}
	
	public final void drawRect(final int x, final int y, final int width, final int height) {
		g2d.draw(new java.awt.Rectangle(x, y, width, height));
	}
}
