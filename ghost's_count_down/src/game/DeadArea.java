package game;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class DeadArea {
	
	Double start = null;
	Double angle = 0.0;
	
	
	public void trim(){
		angle = 2*angle/3;
	}
	
	public void drawShadow(Graphics gp){
		
		if(start!=null){
			Graphics2D g = (Graphics2D) gp;
		    g.setColor(Color.black);
	        g.setComposite(AlphaComposite.SrcOver.derive(0.5f));
	        g.fillArc(0, 0, (int)g.getClipBounds().getWidth(),  (int) g.getClipBounds().getHeight(),
	    		                start.intValue(), angle.intValue());
	        g.setComposite(AlphaComposite.SrcOver.derive(1.0f));
		}
	    
	}
     
	
	public boolean updateShadow(){
		
		if(start==null){
			start = 270.0;
			angle = 1.0;
		}else{
			start = (start+360) %360;
			
		    if(angle>=360)
		    	return false;
		    
		    else if( start<=270  &&  start+angle<=270 ){
				
		    	if( start+90 >= 270-start-angle ){
		    		angle = 270 - start; 
				}else {
					angle = angle + start + 90;
					start = 270.0;
				}
			}
		    
			else if( start<270  && start+angle>270 ){
				return false;
			}
		    
			else if( start>=270 && start+angle<=630){
				
				if(start+angle < 360){
					angle = angle + start - 270;
					start = 270.0;
				}else if( 630-angle-start > start - 270){
					angle = angle + start - 270;
					start = 270.0;
				}else{
					angle = 630 - start; 
				}
				
			}

			else if( start>=270 && start+angle>= 630 ){
				return false;
			}
		}
		
		return true;
	
	}
	
	
	public boolean updateShadowDouble(boolean isLeft){
		if(isLeft){
			if(start==null){
				start = 180.0;
				angle = 1.0;
			}
			else{
				start = (start+360) %360;
				if(angle>=360)
			    	return false;
				
				else if( start<=180  &&  start+angle<=180 ){
					
			    	if( start+ 180 >= 180-start-angle ){
			    		angle = 180 - start; 
					}else {
						angle = angle + start + 180;
						start = 180.0;
					}
				}
				
				else if( start<180  && start+angle>180 ){
					return false;
				}
				
				else if( start>=180  && start+angle<= 540){
					
					if(start+angle < 360){
						angle = angle + start - 180;
						start = 180.0;
					}else if( 540-angle-start > start - 180){
						angle = angle + start - 180;
						start = 180.0;
					}else{
						angle = 540 - start; 
					}
					
				}
				
				else if( start>=180 && start+angle>= 540 ){
					return false;
				}
			}
			
			return true;
		}
		
		
		else{
			if(start==null){
				start = 180.0;
				angle = 1.0;
			}
			else{
				start = (start+360) % 360;
				if(angle>=360)
			    	return false;
				if(start+angle > 360){
					return false;
				}
				else if(start+angle <= 360){
					
					if(360-start-angle <= start ){
						angle = 360 - start;
					}else{
						angle = angle + start;
						start = 0.0;
					}
				}
			}
		}
		
		return true;
	}
	
}