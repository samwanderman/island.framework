/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class to display container
 */
public class DisplayContainer extends DisplayObject {
	// Children array
	private final List<DisplayObject> children = new ArrayList<>();
	
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
		return children.add(child);
	}
	
	/**
	 * Remove child from parent
	 * 
	 * @param child
	 * @return
	 */
	public final boolean removeChild(final DisplayObject child) {
		if (!children.contains(child)) {
			return false;
		}
		
		boolean res = children.remove(child);
		child.setParent(null);
		return res;
	}
	
	/**
	 * Get children
	 * 
	 * @return
	 */
	public final List<DisplayObject> getChildren() {
		return children;
	}
}
