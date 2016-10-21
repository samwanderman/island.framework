/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.ai;

import java.util.LinkedList;

import ru.swg.wheelframework.view.figure.Point2D;

/**
 * Algorithms
 */
public final class Logic {
	// Default find path algorithm
	private static PathFindInterface findPathAlgorithm;
	
	// Default initialization
	static {
		findPathAlgorithm = new LeeFindPathAlgorithm();
	}
	
	/**
	 * Set find path algorithm
	 * 
	 * @param findPathAlgorithm
	 */
	protected static final void setFindPathAlgorithm(final PathFindInterface findPathAlgorithm) {
		Logic.findPathAlgorithm = findPathAlgorithm;
	}
	
	/**
	 * Find path
	 * 
	 * @param map
	 * @param startPoint
	 * @param finishPoint
	 * @return
	 */
	public static final LinkedList<Point2D> findPath(final int[][] map, final Point2D startPoint, final Point2D finishPoint) {
		return findPathAlgorithm.find(map, startPoint, finishPoint);
	}
}
