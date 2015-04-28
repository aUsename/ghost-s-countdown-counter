package game;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class MinutePointer extends Pointer {
	
	public MinutePointer(){
		super(60);
		image = new ImageIcon("minutepointer.jpg").getImage();
	}

	
	

	public void draw(Graphics g){
		
	    g.translate( g.getClipBounds().width/2, g.getClipBounds().height/2);
	  //g.drawImage(image,);
	    g.drawImage(image, 0, 0,null);
	    g.translate(-g.getClipBounds().width/2,-g.getClipBounds().height/2);
	   
    }
}
