package game;

import java.awt.Graphics2D;
import java.awt.Image;

public class Pointer {
	
   double circleTime;
   double angle;
   double length;
   double width;
   Image  image;

   
   
   public Pointer(double v){
	   this();
	   circleTime = v;
   }
   
   
   
   
   public Pointer(){
  	   angle = 270;
   }
   
   
   
   
   public void rotate(){
	   angle += (1/circleTime);
	   angle %= 360 ;
   }
 
   
   public void draw(Graphics2D g){}
   
   
   /**
    * @param r is the radius of clock
    * @return
   */
   public boolean isOverlap(double r){
	   
	   double spanOfAngle =  4*180*Math.atan(width/r/2);
	 
	   //System.out.println(spanOfAngle);
	   //System.out.println(angle);
	   if( angle - spanOfAngle < 90 && angle + spanOfAngle > 90){
		   return true;
	   }
	   
	   
	   return false;
   }
}
