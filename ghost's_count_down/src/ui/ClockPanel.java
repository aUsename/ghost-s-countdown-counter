package ui;

import java.awt.Graphics;

import game.Clock;

import javax.swing.JPanel;

public class ClockPanel extends JPanel {
	Clock clock;
	
	public ClockPanel(Clock c) {
		// TODO Auto-generated constructor stub
		clock = c ;
	}
	
	public void paint(Graphics g){
		
		clock.draw(g);
		
	}

}
