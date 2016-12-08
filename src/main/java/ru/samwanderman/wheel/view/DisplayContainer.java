/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.wheel.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Main class to display container
 */
public class DisplayContainer extends DisplayObject implements DisplayContainerInterface {
	// Children array
	private final List<DisplayObject> children = new ArrayList<>();
	
	public DisplayContainer() { }
	
	/**
	 * Constructor
	 * 
	 * @param width
	 * @param height
	 */
	public DisplayContainer(final int width, final int height) {
		setWidth(width);
		setHeight(height);
	}
	
	/**
	 * Add child to parent
	 * 
	 * @param child
	 * @return
	 */
	public final boolean addChild(final DisplayObject child) {
		if (children.contains(child)) {
			return false;
		}
		
		child.setParent(this);
		final boolean res = children.add(child);
		updateChildren();
		return res;
	}
	
	/**
	 * Remove child from parent
	 * 
	 * @param child
	 * @return
	 */
	public boolean removeChild(final DisplayObject child) {
		if (!children.contains(child)) {
			return false;
		}
		final boolean res = children.remove(child);
		child.setParent(null);
		updateChildren();
		return res;
	}
	
	/**
	 * Get children
	 * 
	 * @return
	 */
	@Override
	public final List<DisplayObject> getChildren() {
		return children;
	}
	
	/**
	 * Update sort order after operations
	 */
	protected void updateChildren() {
		Collections.sort(children, new DisplayObjectComparator());
	}
}
