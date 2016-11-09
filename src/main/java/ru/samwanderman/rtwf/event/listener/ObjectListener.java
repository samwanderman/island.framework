/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.samwanderman.rtwf.event.listener;

/**
 * Object listener
 */
public interface ObjectListener<T> {
	void on(final T object);
}
