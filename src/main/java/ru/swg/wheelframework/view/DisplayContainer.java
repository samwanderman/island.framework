/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for display container which can contain another displayable objects
 */
public class DisplayContainer extends DisplayObject {
	private List<DisplayObject> children = new ArrayList<>();
	
	/**
	 * Add new child
	 * 
	 * @param child
	 * @return
	 */
	public boolean addChild(DisplayObject child) {
		// If child already exists
		if (children.contains(child)) {
			return false;
		}
		
		boolean res = children.add(child);
		if (res) {
			child.setParent(this);
		}
		return res;
	}
	
	/**
	 * Remove child
	 * 
	 * @param child
	 * @return
	 */
	public boolean removeChild(DisplayObject child) {
		if (!children.contains(child)) {
			return false;
		}
		
		child.setParent(null);
		return children.remove(child);
	}
}
