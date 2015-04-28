package game;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class HourPointer extends Pointer {
   public HourPointer(){
	   super(24*60);
	   
	   image = new ImageIcon("hourpointer.jpg").getImage();
   }
   
   public void draw(Graphics g){
   	  g.translate( g.getClipBounds().width/2, g.getClipBounds().height/2);
   	  //g.drawImage();
      g.translate(-g.getClipBounds().width/2,-g.getClipBounds().height/2);
   }
}
