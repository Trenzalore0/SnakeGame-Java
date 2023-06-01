package com.trenzalore.contents;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Snake extends SnakeBody {
	
	private Integer directionX = -Config.OBJECT_MOVED;
	
	private Integer directionY = Config.OBJECT_STOPED;
	
	private Integer lastDirectionX;
	
	private Integer lastDirectionY;
	
	private Integer minX, maxX;
	
	private Integer minY, maxY;
	
	private Integer lastX, lastY;
	
	private static List<SnakeBody> body = new ArrayList<SnakeBody>();
	
	public static Boolean hasBody = false;
	
	public Snake(Integer body) {
		super(Config.DEFAULT_SNAKE_X_POSITION, Config.DEFAULT_SNAKE_Y_POSITION);
		for (int i = 0; i < body; i++) {
			Snake.addBody(this);
		}
	}
	
	public Integer getDirectionX() {
		return directionX;
	}
	
	public Integer getDirectionY() {
		return directionY;
	}
	
	public void setDirectionsXYWithoutLasts(Integer X, Integer Y) {
		directionX = X;
		directionY = Y;
	}
	
	public void setDirectionsXY(Integer X, Integer Y) {
		lastDirectionX = directionX;
		lastDirectionY = directionY;
		
		directionX = X;
		directionY = Y;
	}
	
	public Snake setDirectionXY(Integer X, Integer Y) {
		if (directionX != X && directionY != Y) {			
			setDirectionsXY(X, Y);
		} else if (X == Config.OBJECT_STOPED && Y == Config.OBJECT_STOPED) {
			setDirectionsXY(X, Y);
		}
		
		return this;
	}
	
	public Integer getLastDirectionX() {
		return lastDirectionX;
	}
	
	public Integer getLastDirectionY() {
		return lastDirectionY;
	}
	
	public Integer getLastX() {
		return lastX;
	}
	
	public Integer getLastY() {
		return lastY;
	}
	
	public Snake setRangeX(Integer min, Integer max) {
		minX = min; maxX = max;
		return this;
	}
	
	public Snake setRangeY(Integer min, Integer max) {
		minY = min; maxY = max;
		return this;
	}
	
	public Boolean isStoped() {
		return getDirectionX() == Config.OBJECT_STOPED && getDirectionY() == Config.OBJECT_STOPED;
	}
	
	public void walk() {
		int X = getX(), Y = getY();
		
		if (getDirectionX() != Config.OBJECT_STOPED ^
				getDirectionY() != Config.OBJECT_STOPED
		) {	
			X = validatePosition(
				X + getDirectionX(), 
				maxX, minX
			);
			
			Y = validatePosition(
				Y + getDirectionY(), 
				maxY, minY
			);
		}
		
		lastX = X; lastY = Y;
		
		setLocation(X, Y);

		if (Snake.hasBody &&
			(getDirectionX() != Config.OBJECT_STOPED || getDirectionY() != Config.OBJECT_STOPED)) {
			List<SnakeBody> body = Snake.body; 
			
			body.stream().forEach(bodypart -> {
				if (this.getX() == bodypart.getX() && this.getY() == bodypart.getY()) {
					Game.gameOver();
				}
			});
			
			SnakeBody lastSnake = this;
			for (int i = 0; i < body.size(); i++) {
				lastSnake = body.get(i).walk(lastSnake);
			}
		}
	}

	private int validatePosition(int pos, int max, int min) {
		int result = pos;
		
		if ((pos + Config.DEFAULT_SIZE_OBJECTS) > max ) {
			result = min;
		} else if (pos < min) {
			result = max - Config.DEFAULT_SIZE_OBJECTS;
		}
		
		return result;
	}
	
	public static void addBody(SnakeBody head) {
		if (Snake.hasBody == false) {			
			Snake.hasBody = true;
		}
		SnakeBody toAdd = new SnakeBody(head.getX(), head.getY());
		List<SnakeBody> body = Snake.getBody();
		if (body.size() > 0) {
			SnakeBody last = body.get(body.size()-1);
			toAdd = new SnakeBody(last.getX(), last.getY());
		}
		
		Snake.body.add(toAdd);
	}
	
	public static List<SnakeBody> getBody() {
		return Snake.body;
	}
}
