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
	private final List<DisplayObject> children = new ArrayList<>();
	
	public final boolean addChild(final DisplayObject child) {
		if (children.contains(child)) {
			return false;
		}
		
		child.setParent(this);
		return children.add(child);
	}
	
	public final boolean removeChild(final DisplayObject child) {
		if (!children.contains(child)) {
			return false;
		}
		
		boolean res = children.remove(child);
		child.setParent(null);
		return res;
	}
}
