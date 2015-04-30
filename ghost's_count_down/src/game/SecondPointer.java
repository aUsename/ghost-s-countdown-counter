package game;

import java.awt.Graphics;
import java.io.File;

import javax.swing.ImageIcon;

public class SecondPointer extends Pointer {
	
    public SecondPointer(){
    	super(1);
    	image = new ImageIcon("clock"+File.separator+"pointer.jpg").getImage();
    }
    
    public void draw(Graphics g){
       int  x1,y1,x2,y2;
 	   x1 = (int) (    length*Math.cos(Math.toRadians(angle))  + width*Math.sin(Math.toRadians(angle)) ); 
 	   y1 = (int) (    length*Math.sin(Math.toRadians(angle))  - width*Math.cos(Math.toRadians(angle)) );
 	   
 	   x2 = (int) (    length*Math.cos(Math.toRadians(angle))  - width*Math.sin(Math.toRadians(angle)) ); 
 	   y2 = (int) (    length*Math.sin(Math.toRadians(angle))  + width*Math.cos(Math.toRadians(angle)) );
 	   
 	   int tail = (int) (length/4);
 	   int  tailX,tailY;
 	   tailX = (int) (  -  tail*Math.cos(Math.toRadians(angle))   ); 
 	   tailY = (int) (  -  tail*Math.sin(Math.toRadians(angle))   );
 	   
 	   
 	   
    	  g.translate( g.getClipBounds().width/2, g.getClipBounds().height/2);
    	  g.drawImage(image, tailX, tailY, x1,y1, 0, 0, image.getWidth(null),image.getWidth(null), null);
       g.drawImage(image, tailX, tailY, x2,y2, 0, 0, image.getWidth(null),image.getWidth(null), null);
       g.translate(-g.getClipBounds().width/2,-g.getClipBounds().height/2);
    }
}
