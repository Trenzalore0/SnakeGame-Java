package com.trenzalore.contents;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game  extends JFrame {

	private static Snake snake;
	
	private static Apple apple;
	
	private static Pause pause;
	
	private static Points points;
	
	private static Boolean end = false;
	
	private Control control;

	public Game(Snake snake, Apple apple) {
		Game.snake = snake;
		Game.apple = apple;
		
		Game.pause = new Pause();
		Game.points = new Points();
		
		setPresets();
		
		while (end != true) {
			fill();
			try {				
				Thread.sleep(Config.GAME_FPS);
			} catch (Exception e) {}
		}
	}
	
	private void setPresets() {
		setTitle(Config.GAME_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Config.GAME_WIDTH + 15, Config.GAME_HEIGHT + 39);
		setLocation(
			Config.GAME_lOCATION_X, 
			Config.GAME_LOCATION_Y
		);
		setLayout(null);
		setResizable(false);
	
		snake.setRangeX(0, Config.GAME_WIDTH);
		snake.setRangeY(50, Config.GAME_HEIGHT);
		
		control = new Control(snake, pause);
		
		add(points);
		add(apple);
		add(snake);
		add(pause);
		addKeyListener(control);
		setVisible(true);
	}
	
	public static void unPause() {
		if (!Game.pause.getText().isEmpty()) {			
			Game.pause.setText("");
			Game.pause.setOpaque(false);
		}
	}
	
	public static void gameOver() {
		end = true;
	}
	
	private void fill() {
		Game.snake.walk();
		
		if (Game.snake.getX() == Game.apple.getX() && Game.snake.getY() == Game.apple.getY()) {
			Game.apple.randomNewLocation();
			Snake.addBody(Game.snake);
			Game.points.addPoint();
		}
		
		if (Snake.hasBody) {
			for (SnakeBody body : Snake.getBody()) {
				if (!body.hasAdded()) {
					add(body);
					body.changeHasAdded();
				}
			}
		}
	}	
}
