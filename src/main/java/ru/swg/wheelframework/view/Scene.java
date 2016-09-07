/**
 * @author Potapov Sergei (sam-wanderman@yandex.ru)
 */
package ru.swg.wheelframework.view;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Game Scene
 */
public final class Scene extends JFrame {
	private static final long serialVersionUID = -4421670693048202427L;
	
	/**
	 * Constructor
	 * 
	 * @param gameBoard
	 * @param title
	 * @param width
	 * @param height
	 */
    public Scene(final String title, final DisplayObject gameBoard, final int width, final int height) {
    	final Component frameworkAdapter = new FrameworkAdapter(gameBoard);
    	final JFrame frame = new JFrame();
		frame.setSize(new Dimension(width, height));
		frame.setTitle(title);
		frame.getContentPane().add(frameworkAdapter);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setVisible(true);		
    }
}
