package ui;

import game.Clock;
import game.DeadArea;
import game.HourPointer;
import game.MinutePointer;
import game.SecondPointer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PointerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2811371393748329324L;
	HourPointer hour;
	MinutePointer minute;
	SecondPointer second;
	DeadArea deadArea ;
	public PointerPanel(Clock c){
		setOpaque(false);
		hour = c.hour;
		minute = c.minute;
		second =c.second ;
		deadArea = c.deadArea;
	}
	
	public void paintComponent(Graphics gp){
		super.paintComponent(gp);
		Graphics2D  g =  (Graphics2D) gp;		
		deadArea.drawShadow(g);				
		hour.  draw(g);
		minute.draw( g);
		second.draw(g);
		
	}
	
}
