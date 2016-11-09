/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.rtwf.view;

/**
 * Simple padding
 */
public final class Padding {
	private int left;
	private int right;
	private int top;
	private int bottom;
	
	public Padding(final int left, final int top, final int right, final int bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}
	
	public final int getLeft() {
		return left;
	}
	
	public final int getRight() {
		return right;
	}
	
	public final int getTop() {
		return top;
	}
	
	public final int getBottom() {
		return bottom;
	}
}
