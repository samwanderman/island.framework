/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view;

import java.util.Comparator;

/**
 * Display Object comparator
 */
public class DisplayObjectComparator implements Comparator<DisplayObject> {
	@Override
	public final int compare(final DisplayObject o1, final DisplayObject o2) {
		if (o1.getZ() > o2.getZ()) {
			return 1;
		}
		
		if (o1.getZ() < o2.getZ()) {
			return -1;
		}
		
		return 0;
	}
}
