package com.trenzalore.contents;

import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Apple extends JPanel {
	
	final private Random random = new Random();
	
	public Apple() {
		setBackground(Config.APPLE_COLOR);
		setOpaque(true);
		setBounds(
			getRandomPos(Config.GAME_WIDTH), 
			getRandomPos(50, Config.GAME_HEIGHT), 
			Config.DEFAULT_SIZE_OBJECTS, 
			Config.DEFAULT_SIZE_OBJECTS
		);
	}
	
	public Integer getRandomPos(Integer max) {
		Integer x = random.nextInt(max);
		while (x % Config.DEFAULT_SIZE_OBJECTS != 0) {
			x = random.nextInt(max);
		}
		return x;
	}
	
	public Integer getRandomPos(Integer min, Integer max) {
		Integer x = random.nextInt(min, max);
		while (x % Config.DEFAULT_SIZE_OBJECTS != 0) {
			x = random.nextInt(min, max);
		}
		return x;
	}
	
	public void randomNewLocation() {
		setLocation(
			getRandomPos(Config.GAME_WIDTH), 
			getRandomPos(50, Config.GAME_HEIGHT)
		);
	}
}
