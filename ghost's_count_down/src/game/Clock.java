package game;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Clock {
	    
	MinutePointer minute = new MinutePointer();
	SecondPointer second = new SecondPointer();
	HourPointer hour = new HourPointer();
	Ball ball ;
	int  number;
	Image  image = new ImageIcon("clock.jpg").getImage();
	Image  lineofimage = new ImageIcon("line.jpg").getImage();
	
	//deadArea[0] ,the shadow area starts with
	//deadArea[1] ,the range of area 
	Double[] deadArea = new Double[2];
	boolean  drawLine = false;
	

	public void updateShadow(){
	
		drawLine = true;
		
		if(deadArea[0]==null){
			deadArea[0] = 90.0;
			deadArea[1] = 0.0;
		}
		else{
			
		}
	}
	
	
	
	public Clock(Ball b,int n){
		ball =b;
		number = n;
		deadArea[0] = null;
		deadArea[1] = 0.0;
	}


	public void drawShadow(Graphics g){
		
	}
	
	
	
	
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.translate( g.getClipBounds().width/2, g.getClipBounds().height/2);
	  //if(drawLine)  g.drawImge(imageofline);
	  //g.drawImage(image);
		drawShadow(g);
	    g.translate(-g.getClipBounds().width/2,-g.getClipBounds().height/2);
	   
		minute.draw(g);
		hour.draw(g);
		second.draw(g);
		if(number>0)
			ball.draw(g);
		
	}
}
