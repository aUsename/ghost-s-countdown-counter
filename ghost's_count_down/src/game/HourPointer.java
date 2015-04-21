package game;

import java.awt.Graphics;

public class HourPointer extends Pointer {
   public HourPointer(){
	   super(24*60);
   }
   
   public void draw(Graphics g){
   	  g.translate( g.getClipBounds().width/2, g.getClipBounds().height/2);
   	  //g.drawImage();
      g.translate(-g.getClipBounds().width/2,-g.getClipBounds().height/2);
   }
}
