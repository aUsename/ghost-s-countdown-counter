package game;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;

import javax.swing.ImageIcon;

public class HourPointer extends Pointer {
   
	
	public HourPointer(){
	  
	   super(2.8); 
	   angle = 360*Math.random();
	   length = 120;
	   width = 10;
<<<<<<< HEAD
	   image = new ImageIcon("button"+File.separator+"enter1.png").getImage();
=======
	   image = new ImageIcon("clock"+File.separator+"pointer.jpg").getImage();
  
>>>>>>> origin/master
   }
   
   public void draw(Graphics2D g){
	   
	  	 int tail = (int) (length/4);
		   
	 	  g.translate( g.getClipBounds().width/2, g.getClipBounds().height/2);
	 	  g.rotate(Math.toRadians(angle));
	 	  g.drawImage(image,-tail,(int)-width/2,(int)length,(int)width,0,0,image.getWidth(null),image.getHeight(null),null);
	 	 /*
	 	  g.setColor(Color.blue);
	      g.fillRect(-tail, (int)-width/2,   (int)length,   (int)width/2);
	      g.setColor(Color.red);
	      g.fillRect(-tail,  0, (int)length, (int)width/2);
	 	  */
	 	 // g.setComposite(AlphaComposite.SrcOver.derive(.2f));
	 	  g.rotate(Math.toRadians(-angle));
	 	  g.translate( -g.getClipBounds().width/2, -g.getClipBounds().height/2);
	  }

}
