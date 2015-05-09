package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EnterPanel extends JPanel {
	
	public EnterButton eb;
	
	public EnterPanel(int w,int h){
	    
		setLayout(null);
		setOpaque(false);
		//setBounds(0, 0, w, h);
		eb = new EnterButton();
		add(eb);
		eb.setBounds(315, 450, 415, 220);

	}
	
	public void paint(Graphics g){
          
		  ImageIcon imgIcon = new ImageIcon("background/enterBackground.png");
		  Image img = imgIcon.getImage();
		  g.drawImage(img,0,0,getWidth(),getHeight(),0,0,img.getWidth(null),img.getHeight( null),null);		  
		  super.paintChildren(g);
	  }
	 

}
