package com.trenzalore.contents;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class Control {
	
	private Snake snake;
	
	private Pause pause;

	public Control(Snake snake, Pause pause) {
		this.snake = snake;
		this.pause = pause;
	}
	
	private void setXY(Integer x, Integer y) {
		if (snake.isStoped()) {
			snake.setDirectionsXYWithoutLasts(x, y);
		} else {
			snake.setDirectionXY(x, y);
		}
		Game.unPause();
	}
	
	public Action getUpAction() {
		return new UpAction();
	}
	
	public Action getDownAction() {
		return new DownAction();
	}
	
	public Action getLeftAction() {
		return new LeftAction();
	}
	
	public Action getRightAction() {
		return new RightAction();
	}
	
	public Action getPauseAction() {
		return new PauseAction();
	}
	
	@SuppressWarnings("serial")
	private class UpAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			setXY(Config.OBJECT_STOPED, -Config.OBJECT_MOVED);
		}
	}
	
	@SuppressWarnings("serial")
	private class DownAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			setXY(Config.OBJECT_STOPED, Config.OBJECT_MOVED);
		}
	}
	
	@SuppressWarnings("serial")
	private class LeftAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			setXY(-Config.OBJECT_MOVED, Config.OBJECT_STOPED);
		}
	}
	
	@SuppressWarnings("serial")
	private class RightAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			setXY(Config.OBJECT_MOVED, Config.OBJECT_STOPED);
		}
	}
	
	@SuppressWarnings("serial")
	private class PauseAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (pause.getText().isBlank()) {							
				pause.setOpaque(true);
				pause.setText(Config.PAUSE_TEXT);
				snake.setDirectionsXY(Config.OBJECT_STOPED, Config.OBJECT_STOPED);
			} else {
				Game.unPause();
				snake.setDirectionsXYWithoutLasts(
					snake.getLastDirectionX(), 
					snake.getLastDirectionY()
				);
			}
		}
	}
}
