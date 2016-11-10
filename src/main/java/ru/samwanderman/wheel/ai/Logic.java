/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.wheel.ai;

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
	 * Get find path algorithm
	 * 
	 * @return
	 */
	public static final PathFindInterface getFindPathAlgorithm() {
		return findPathAlgorithm;
	}
}
