package com.trenzalore.contents;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Pause extends JLabel {

	public Pause() {
		setBounds(
				Config.PAUSE_LOCATION_X, 
				Config.PAUSE_LOCATION_Y, 
				Config.PAUSE_WIDTH, 
				Config.PAUSE_HEIGHT
			);
		setBackground(Config.PAUSE_BACKGROUND_COLOR);
		setFont(Config.PAUSE_FONT);
		setHorizontalAlignment(JLabel.CENTER);
		setForeground(Config.PAUSE_FONT_COLOR);
	}
}
