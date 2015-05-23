package ui;

import java.awt.Graphics;
import java.io.File;

import game.Clock;
import game.DoubleMode;
import game.Launcher;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ClockPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2382691159846648191L;
	Clock clock;
	public PointerPanel pointers;

	 ImageIcon down;
   	ImageIcon white;
   	ImageIcon black;
	public ClockPanel(Clock c) {
		
		setLayout(null);
		setOpaque(false);
		clock = c ;
		pointers = new PointerPanel(c);
		add(pointers);
		down = new ImageIcon("clock"+File.separator+"down.png");
        white = new ImageIcon("clock"+File.separator+"white.png");
   	    black = new ImageIcon("clock"+File.separator+"black.png");
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		clock.draw(g);
         
	    	if(Launcher.isOnGame && !Launcher.isSingleMode){
	        	if(DoubleMode.turnToLeft){
	        		g.translate(0, this.getHeight()/2);
	            	g.drawImage(white.getImage(), 0, -10, 20,10,0,0,white.getIconWidth(),white.getIconWidth(),null);
	            	g.translate(0,- this.getHeight()/2);
	        	}else{
	        		g.translate(this.getWidth(), this.getHeight()/2);
	            	g.drawImage(white.getImage(), -20, -10, 0,10,0,0,white.getIconWidth(),white.getIconWidth(),null);
	            	g.translate(-this.getWidth(),- this.getHeight()/2);
	        	}
	        }
	    	if(Launcher.isOnGame && Launcher.isSingleMode){
	    		g.translate(this.getWidth()/2, this.getHeight());
            	g.drawImage(down.getImage(), -10, -20, 10,0,0,0,down.getIconWidth(),down.getIconWidth(),null);
            	g.translate(-this.getWidth()/2,- this.getHeight());
	    	}
	}

}
