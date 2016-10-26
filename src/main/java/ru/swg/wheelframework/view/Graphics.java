package ru.swg.wheelframework.view;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import ru.swg.wheelframework.view.figure.Rectangle;

/**
 * Graphics adapter
 */
public final class Graphics {
	public static final int COMPOSITE_ALPHA = 1;
	public static final int COMPOSITE_SRC = 2;
	
	private final Graphics2D g2d;
	
	public Graphics(final java.awt.Graphics g2d) {
		this.g2d = (Graphics2D) g2d;
	}
	
	public final void setComposite(final int composite) {
		switch (composite) {
		case COMPOSITE_ALPHA:
			g2d.setComposite(AlphaComposite.Clear);
			break;
		case COMPOSITE_SRC:
			g2d.setComposite(AlphaComposite.Src);
			break;
		default:
		}
	}
	
	public final void setColor(final Color color) {
		g2d.setColor(new java.awt.Color(color.getR(), color.getG(), color.getB()));
	}

	public final void fillRect(final int x, final int y, final int width, final int height) {
		g2d.fillRect(x, y, width, height);
	}
	
	public final void drawImage(final Image image, final Integer x, final Integer y) {
		g2d.drawImage(image.getContent(), x, y, null);
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
