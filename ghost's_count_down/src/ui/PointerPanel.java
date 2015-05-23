package ui;

import game.Clock;
import game.DeadArea;
import game.DoubleMode;
import game.HourPointer;
import game.Launcher;
import game.MinutePointer;
import game.SecondPointer;
import game.SingleMode;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PointerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2811371393748329324L;
	HourPointer hour;
	MinutePointer minute;
	SecondPointer second;
	DeadArea      deadArea ;
	
	ImageIcon[]     icon ;
	ImageIcon win ;
	ImageIcon fail ;
	ImageIcon white;
	
	
	public PointerPanel(Clock c){
		
		setOpaque(false);
		hour = c.hour;
		minute = c.minute;
		second =c.second ;
		deadArea = c.deadArea;
		
		icon = new ImageIcon[5];
		ImageIcon icon1 = new ImageIcon("clock"+File.separator+"1.png");
		ImageIcon icon2 = new ImageIcon("clock"+File.separator+"2.png");
		ImageIcon icon3 = new ImageIcon("clock"+File.separator+"3.png");
		ImageIcon icon4 = new ImageIcon("clock"+File.separator+"4.png");
		ImageIcon icon5 = new ImageIcon("clock"+File.separator+"5.png");
		
		icon[0] = icon1 ; 
		icon[1] = icon2 ; 
		icon[2] = icon3 ; 
		icon[3] = icon4 ; 
		icon[4] = icon5 ; 
		
		win = new ImageIcon("clock"+File.separator+"win.png");
		fail= new ImageIcon("clock"+File.separator+"fail.png");
		white = new ImageIcon("clock"+File.separator+"white.png");
	}
	
	public void paintComponent(Graphics gp){
		super.paintComponent(gp);
		Graphics2D  g =  (Graphics2D) gp;		
		deadArea.drawShadow(g);				
		hour.  draw(g);
		minute.draw( g);
		second.draw(g);
		
		/*if(Launcher.isOnGame && !Launcher.isSingleMode){
			if(!DoubleMode.turnToLeft){
				g.translate(g.getClipBounds().getWidth(),g.getClipBounds().getHeight());
			    g.drawImage(white.getImage(), 0, 0, 20,20,0,0,white.getIconWidth(),white.getIconWidth(),null);
			    g.translate(g.getClipBounds().getWidth(),g.getClipBounds().getHeight());
			}
			
		}*/
		
		if(SingleMode.restTime < 5000  && SingleMode.restTime > 500  && Launcher.isSingleMode) {
			int i = (int) SingleMode.restTime/1000;
			g.translate(g.getClipBounds().getWidth()/2, g.getClipBounds().getHeight()/2);
		    g.drawImage(icon[i].getImage(), -100, -100, 100, 100, 
		        0,0,icon[i].getIconWidth(),icon[i].getIconHeight(), null);
		    g.translate(-g.getClipBounds().getWidth()/2, -g.getClipBounds().getHeight()/2);
		}
		
		if(SingleMode.toDraw){
			if(SingleMode.isAlive){
				g.translate(g.getClipBounds().getWidth()/2, g.getClipBounds().getHeight()/2);
				g.drawImage( win.getImage(), -280, -280, 280, 280, 
				        0,0, win.getIconWidth(), win.getIconHeight(), null);
				g.translate(-g.getClipBounds().getWidth()/2, -g.getClipBounds().getHeight()/2);
			}
			else {
				g.translate(g.getClipBounds().getWidth()/2, g.getClipBounds().getHeight()/2);
				g.drawImage( fail.getImage(), -280, -280, 280, 280, 
				        0,0, fail.getIconWidth(), fail.getIconHeight(), null);
				g.translate(-g.getClipBounds().getWidth()/2, -g.getClipBounds().getHeight()/2);
			}
		}
		
		if(DoubleMode.toDraw){
			if(DoubleMode.FormerWin){			
				g.drawImage( win.getImage(), 0, 0, 220, 500, 
				        0,0, win.getIconWidth(), win.getIconHeight(), null);
			}
			else if(DoubleMode.LaterWin){		
				g.drawImage( win.getImage(), 280, 0,500, 500, 
				        0,0, win.getIconWidth(), win.getIconHeight(), null);			
			}
		}
	}
	
}
