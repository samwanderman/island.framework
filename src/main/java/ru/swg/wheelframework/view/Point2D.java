/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view;

/**
 * Simple point class
 */
public class Point2D {
	// x
	private int x;
	// y
	private int y;
	
	/**
	 * Constructor
	 * 
	 * @param x
	 * @param y
	 */
	public Point2D(final int x, final int y) {
		this.x = x;
		this.y = y;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		final Point2D other = (Point2D) obj;
		if (x != other.x) {
			return false;
		}
		
		if (y != other.y) {
			return false;
		}
		
		return true;
	}
}
