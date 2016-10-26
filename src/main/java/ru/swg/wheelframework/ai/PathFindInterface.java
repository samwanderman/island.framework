/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.ai;

import java.util.LinkedList;

import ru.swg.wheelframework.view.figure.Point2D;

/**
 * Interface for Path finding interface
 */
public interface PathFindInterface {
	/**
	 * Find path from startPoint to endPoint
	 * 
	 * @param map
	 * @param startPoint
	 * @param finishPoint
	 * @return
	 */
	LinkedList<Point2D> find(final int[][] map, final Point2D startPoint, final Point2D finishPoint);
	
	/**
	 * Find new end point
	 * 
	 * @param srcMap
	 * @param startPoint
	 * @param finishPoint
	 * @return
	 */
	Point2D findNewEndPoint(final int[][] srcMap, final Point2D startPoint, final Point2D finishPoint);
}
