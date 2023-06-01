package com.trenzalore.contents;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public interface Config {
	
	// ----------------- game  -----------------
	
	final public Toolkit SCREEN = Toolkit.getDefaultToolkit();

	final public Integer GAME_FPS = 50;
	
	final public Integer GAME_WIDTH = 500;
	
	final public Integer GAME_HEIGHT = 500;
	
	final public String GAME_TITLE = "Snake Game";
	
	final public Integer GAME_lOCATION_X = (int) Config.SCREEN.getScreenSize().getWidth() / 2 - Config.GAME_WIDTH / 2;
	
	final public Integer GAME_LOCATION_Y = (int) Config.SCREEN.getScreenSize().getHeight() / 2 - Config.GAME_HEIGHT / 2;
	
	final public Integer FONT_SIZE = 50;

	// ----------------- pause label  -----------------
	
	final public String PAUSE_TEXT = "Pause";
	
	final public Integer PAUSE_LOCATION_X = 0;
	
	final public Integer PAUSE_LOCATION_Y = Config.GAME_HEIGHT / 2 - Config.GAME_HEIGHT / 4;
	
	final public Integer PAUSE_WIDTH = Config.GAME_WIDTH;
	
	final public Integer PAUSE_HEIGHT = Config.GAME_HEIGHT / 2;
	
	final public Color PAUSE_BACKGROUND_COLOR = Color.BLACK;
	
	final public Font PAUSE_FONT = new Font("Cosmic", Font.PLAIN, Config.FONT_SIZE);
	
	final public Color PAUSE_FONT_COLOR = Color.WHITE;
	
	// ----------------- snake panel  -----------------
	
	final public Integer DEFAULT_SIZE_OBJECTS = 10;
	
	final public Integer DEFAULT_SNAKE_X_POSITION = 300;
	
	final public Integer DEFAULT_SNAKE_Y_POSITION = 200;
	
	final public Color SNAKE_COLOR = Color.BLACK; // new Color(123, 50, 250);
	
	final public Integer OBJECT_MOVED = Config.DEFAULT_SIZE_OBJECTS;
	
	final public Integer OBJECT_STOPED = 0;
	
	// ----------------- apple panel  -----------------
	
	final public Color APPLE_COLOR = Color.RED;
}
