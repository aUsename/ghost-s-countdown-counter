package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EnterPanel extends JPanel {
	
	public void paint(Graphics g){
		  super.paint(g);
		  ImageIcon imgIcon = new ImageIcon("button/enterBackground.png");
		  Image img = imgIcon.getImage();
		  g.drawImage(img,0,0,1100,700,null);
		  
	  }
}
