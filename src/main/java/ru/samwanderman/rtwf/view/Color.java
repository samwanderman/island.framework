package ru.samwanderman.rtwf.view;

/**
 * Class for colors
 */
public final class Color {
	public static final Color GRAY = new Color(127, 127, 127);
	public static final Color GREEN = new Color(0, 255, 0);
	
	private int r;
	private int g;
	private int b;
	
	/**
	 * Empty constructor
	 */
	public Color() { }
	
	/**
	 * Constructor
	 * 
	 * @param r
	 * @param g
	 * @param b
	 */
	public Color (final int r, final int g, final int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	/**
	 * Get red
	 * 
	 * @return
	 */
	public final int getR() {
		return r;
	}
	
	/**
	 * Set red
	 * 
	 * @param r
	 */
	public final void setR(final int r) {
		this.r = r;
	}
	
	/**
	 * Get green
	 * 
	 * @return
	 */
	public final int getG() {
		return g;
	}
	
	/**
	 * Set green
	 * 
	 * @param g
	 */
	public final void setG(final int g) {
		this.g = g;
	}
	
	/**
	 * Get blue
	 * 
	 * @return
	 */
	public final int getB() {
		return b;
	}
	
	/**
	 * Set blue
	 * 
	 * @param b
	 */
	public final void setB(final int b) {
		this.b = b;
	}
}
