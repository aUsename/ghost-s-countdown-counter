package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;

import javax.swing.ImageIcon;

public class HourPointer extends Pointer {
   public HourPointer(){
	  
	   super(24*60); angle = 45;
	   length = 200;
	   width = 5;
	   image = new ImageIcon("clock"+File.separator+"pointer.jpg").getImage();
   }
   
   public void draw(Graphics g){
	   /*
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
      */
	   
	   int  x,y;
	   x = (int) (    length  + width ); 
	   y = (int) (    length  - width );
	   
	 
	   int tail = (int) (length/4);
	   
	  Graphics2D g2d = (Graphics2D)g;
	  g2d.translate( g.getClipBounds().width/2, g.getClipBounds().height/2);
	  g2d.rotate(Math.toRadians(angle));
	  g2d.drawImage(image,-tail,(int)-width,(int)length,(int)width,0,0,image.getWidth(null),image.getHeight(null),null);
	  g.translate( g.getClipBounds().width/2, g.getClipBounds().height/2);
   }
}
