package game;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class Clock {
	    
	public MinutePointer minute = new MinutePointer();
	public SecondPointer second = new SecondPointer();
	public HourPointer   hour = new HourPointer();
	public DeadArea deadArea = new DeadArea();
	Ball   ball ;
	int    number;
	Image  image = new ImageIcon("clock"+File.separator+"Clock.png").getImage();
	//Image  lineofimage = new ImageIcon("line.jpg").getImage();
	
	
	
	
	public Clock(Ball b,int n){
		
		ball =b;
		number = n;
		
	}


	
	public void draw(Graphics gp) {
		
		Graphics2D g = (Graphics2D) gp; 
	    g.drawImage(image, 0, 0, g.getClipBounds().width, g.getClipBounds().height,
	    		    0, 0, image.getWidth(null), image.getHeight(null), null);
	}



	public void drawShadow(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
