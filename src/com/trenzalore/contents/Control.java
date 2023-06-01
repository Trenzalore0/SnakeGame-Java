package com.trenzalore.contents;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.trenzalore.contents.audios.AudioBemtivi;
import com.trenzalore.contents.audios.AudioBemtiviDeath;

public class Control implements KeyListener {
	
	private Snake snake;
	
	private Pause pause;
	
	private File eat = new AudioBemtivi();
	
	private File death = new AudioBemtiviDeath();
	
	public Control(Snake snake, Pause pause) {
		this.snake = snake;
		this.pause = pause;
	}
	
	private void play (File audio) {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audio);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
		} catch(Exception e) {
		}
	}
	
	public void playBemtivi() {
		play(eat);
	}
	
	public void playBemtiviDeath() {
		play(death);
	}
	
	private void validate(Integer x, Integer y) {
		if (snake.isStoped()) {
			snake.setDirectionsXYWithoutLasts(x, y);
		} else {
			snake.setDirectionXY(x, y);
		}
		Game.unPause();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		/**
		 * 
		 *  right: 39 68
		 *  left:  37 65
		 *  top:   38 87
		 *  down:  40 83
		 *  
		 *  pause: 32 80
		 *  
		 **/
		
		switch (e.getKeyCode()) {
			case 39:
			case 68:
				this.validate(Config.OBJECT_MOVED, Config.OBJECT_STOPED);
				break;
			case 37:
			case 65:
				this.validate(-Config.OBJECT_MOVED, Config.OBJECT_STOPED);
				break;
			case 38:
			case 87:
				this.validate(Config.OBJECT_STOPED, -Config.OBJECT_MOVED);
				break;
			case 40:
			case 83:
				this.validate(Config.OBJECT_STOPED, Config.OBJECT_MOVED);
				break;
			case 32:
			case 80:
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
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
