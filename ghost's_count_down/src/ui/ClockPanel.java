package ui;

import java.awt.Graphics;

import game.Clock;

import javax.swing.JPanel;

public class ClockPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2382691159846648191L;
	Clock clock;
	public PointerPanel pointers;

	
	public ClockPanel(Clock c) {
		
		setLayout(null);
		setOpaque(false);
		clock = c ;
		pointers = new PointerPanel(c);
		add(pointers);
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		clock.draw(g);
	}

}
