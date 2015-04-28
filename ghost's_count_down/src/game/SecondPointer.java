package game;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class SecondPointer extends Pointer {
	
    public SecondPointer(){
    	super(1);
    	image = new ImageIcon("secondpointer.jpg").getImage();
    }
    
    public void draw(Graphics g){
    	g.translate( g.getClipBounds().width/2, g.getClipBounds().height/2);
      //g.drawImage();
        g.translate(-g.getClipBounds().width/2,-g.getClipBounds().height/2);
     
    }
}
