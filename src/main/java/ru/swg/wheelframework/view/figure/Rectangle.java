package ru.swg.wheelframework.view.figure;

/**
 * Class for rectangle
 */
public final class Rectangle {
	private final int x;
	private final int y;
	private final int width;
	private final int height;
	
	/**
	 * Constructor
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Rectangle(final int x, final int y, final int width, final int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Get x
	 * 
	 * @return
	 */
	public final int getX() {
		return x;
	}

	/**
	 * Get y
	 * 
	 * @return
	 */
	public final int getY() {
		return y;
	}
	
	/**
	 * Get width
	 * 
	 * @return
	 */
	public final int getWidth() {
		return width;
	}
	
	/**
	 * Get height
	 * 
	 * @return
	 */
	public final int getHeight() {
		return height;
	}
	
	/**
	 * Check if rect contains point
	 * 
	 * @param point
	 * @return
	 */
	public final boolean contains(final Point2D point) {
		return (x <= point.getX()) && (x + width > point.getX()) && (y <= point.getY()) && (y + height > point.getY());
	}
	
	/**
	 * Check if rect contains coords
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public final boolean contains(final int x, final int y) {
		return (this.x <= x) && (this.x + width > x) && (this.y <= y) && (this.y + height > y);
	}
	
	/**
	 * Check if rect contains another rect
	 * 
	 * @param rect
	 * @return
	 */
	public final boolean contains(final Rectangle rect) {
		return (x <= rect.getX()) && (x + width > rect.getX() + rect.getWidth()) && (y <= rect.getY()) && (y + height > rect.getY() + rect.getHeight()); 
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
		result = prime * result + x;
		result = prime * result + y;
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		final Rectangle other = (Rectangle) obj;
		if (height != other.height) {
			return false;
		}
		
		if (width != other.width) {
			return false;
		}
		
		if (x != other.x) {
			return false;
		}
		
		if (y != other.y) {
			return false;
		}
		
		return true;
	}
}
