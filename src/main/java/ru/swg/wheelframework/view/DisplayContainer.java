/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class to display container
 */
public class DisplayContainer extends DisplayObject implements DisplayContainerInterface {
	// Children array
	private final List<DisplayObject> children = new ArrayList<>();
	
	/**
	 * Add child to parent
	 * 
	 * @param child
	 * @return
	 */
	protected final boolean addChild(final DisplayObject child) {
		if (children.contains(child)) {
			return false;
		}
		
		child.setParent(this);
		return children.add(child);
	}
	
	/**
	 * Add multiple children to parent
	 * 
	 * @param children
	 * @return
	 */
	/*public final boolean addChildren(final List<DisplayObject> children) {
		if (ListUtil.containsSingle(this.children, children)) {
			return false;
		}
		
		for (final DisplayObject child: children) {
			child.setParent(this);	
		}
		
		return children.addAll(children);
	}*/
	
	/**
	 * Remove child from parent
	 * 
	 * @param child
	 * @return
	 */
	protected final boolean removeChild(final DisplayObject child) {
		if (!children.contains(child)) {
			return false;
		}
		
		final boolean res = children.remove(child);
		child.setParent(null);
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
}
