package game;

import java.awt.Graphics;
import java.awt.Image;

public class Ball {
    double x;
    double y;
    double r;
    Image image;
    
    public Ball(double xc,double yc,double rc){
    	x  =xc;
    	y = yc;
    	r = rc;
    }
    
    public void draw(Graphics g){
    	 g.translate( g.getClipBounds().width/2, g.getClipBounds().height/2);
   	  //g.drawImage();
   	    g.drawImage(image, 0, 0,null);
   	    g.translate(-g.getClipBounds().width/2,-g.getClipBounds().height/2);
    }
    
}
