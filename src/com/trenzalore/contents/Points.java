package com.trenzalore.contents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Points extends JPanel {

	private Integer counterPoints = 0;
	
	private JLabel label;
	
	public Points() {
		setLayout(null);
		label = new JLabel();
		label.setText("Points: " + counterPoints.toString());
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Cosmic", Font.BOLD, 20));
		label.setBounds(10, 0, 100, 50);
		
		setBounds(0, 0, 500 , 50);
		setOpaque(true);
		setBackground(Color.DARK_GRAY);
		
		this.add(label);
	}
	
	public void addPoint() {
		counterPoints++;
		label.setText("Points: " + counterPoints.toString());
	}
	
	public void resetPoints() {
		counterPoints = 0;
	}
}
