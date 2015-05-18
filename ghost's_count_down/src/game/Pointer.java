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
	   
	   circleTime = v;
   }
   
   
   
   
   
   
   public void rotate(){
	   angle += (2/circleTime);
	   angle %= 360 ;
   }
 
   
   public void draw(Graphics2D g){}
   
   
   /**
    * @param r is the radius of clock
    * @return
   */
   public boolean isOverlap(double r,  double launchAngle){
	   
	   double spanOfAngle =  4*180*Math.atan(width/r/2);
	 
	   
	   //System.out.println(spanOfAngle);
	   //System.out.println(angle);
	   if( (angle - spanOfAngle) < launchAngle &&  (angle + spanOfAngle)%360 > launchAngle ){
		   return true;
	   }
	   
	   
	   return false;
   }
}
