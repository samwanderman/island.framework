/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view;

import java.util.List;

/**
 * DisplayContainer interface
 */
public interface DisplayContainerInterface {
	// Get all children
	List<? extends DisplayObject> getChildren();
}
