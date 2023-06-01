package com.trenzalore;

import com.trenzalore.contents.Apple;
import com.trenzalore.contents.Game;
import com.trenzalore.contents.Snake;

public class App {

	public static void main(String[] args) {
		new Game(new Snake(3), new Apple());
	}
}
