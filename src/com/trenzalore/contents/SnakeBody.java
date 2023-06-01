package com.trenzalore.contents;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SnakeBody extends JPanel {
	
	protected Integer lastX, lastY;
	
	private Boolean hasAdded = false;
	
	public Integer getLastX() {
		return lastX;
	}
	
	public Integer getLastY() {
		return lastY;
	}

	public SnakeBody(Integer defaultX, Integer defaultY) {
		setBackground(Config.SNAKE_COLOR);
		setOpaque(true);
		setBorder(BorderFactory.createLineBorder(Color.cyan));
		setBounds(defaultX, defaultY, Config.DEFAULT_SIZE_OBJECTS, Config.DEFAULT_SIZE_OBJECTS);
	}
	
	public Boolean hasAdded() {
		return hasAdded;
	}
	
	public SnakeBody changeHasAdded() {
		hasAdded = !hasAdded;
		return this;
	}
	
	protected SnakeBody walk(SnakeBody last) {
		lastX = getX(); lastY = getY();
		setLocation(last.getLastX(), last.getLastY());
		return this;
	}
}
