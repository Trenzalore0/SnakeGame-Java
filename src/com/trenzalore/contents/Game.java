package com.trenzalore.contents;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Game  extends JFrame implements ActionListener {

	private static Snake snake;
	
	private static Apple apple;
	
	private static Pause pause;
	
	private static Points points;
	
	private static Boolean end = false;
	
	private Control control;
	
	private JPanel mainPanel;
	
	private Timer timer;

	public Game(Snake snake, Apple apple) {
		Game.snake = snake;
		Game.apple = apple;
		
		Game.pause = new Pause();
		Game.points = new Points();
		
		setPresets();
		
		timer = new Timer(Config.GAME_FPS, this);
		timer.start();
	}
	
	private void setPresets() {
		setTitle(Config.GAME_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(Config.GAME_WIDTH, Config.GAME_HEIGHT));
		
		mainPanel.setLayout(null);
		setResizable(false);
	
		snake.setRangeX(0, Config.GAME_WIDTH);
		snake.setRangeY(50, Config.GAME_HEIGHT);
		
		control = new Control(snake, pause);
		
		mainPanel.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
		mainPanel.getActionMap().put("upAction", control.getUpAction());
		
		mainPanel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
		mainPanel.getActionMap().put("downAction", control.getDownAction());
		
		mainPanel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
		mainPanel.getActionMap().put("leftAction", control.getLeftAction());
		
		mainPanel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
		mainPanel.getActionMap().put("rightAction", control.getRightAction());
		
		mainPanel.getInputMap().put(KeyStroke.getKeyStroke(' '), "pauseAction");
		mainPanel.getActionMap().put("pauseAction", control.getPauseAction());
		
		mainPanel.add(points);
		mainPanel.add(apple);
		mainPanel.add(snake);
		mainPanel.add(pause);
		add(mainPanel);
		pack();
		setLocationRelativeTo(null);
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
	
	public void actionPerformed(ActionEvent e) {
		if (end != true) {			
			Game.snake.walk();
			
			if (Game.snake.getX() == Game.apple.getX() && Game.snake.getY() == Game.apple.getY()) {
				Game.apple.randomNewLocation();
				Snake.addBody(Game.snake);
				Game.points.addPoint();
			}
			
			if (Snake.hasBody) {
				for (SnakeBody body : Snake.getBody()) {
					if (!body.hasAdded()) {
						mainPanel.add(body);
						body.changeHasAdded();
					}
				}
			}
		}
	}	
}
