package ui;

import java.awt.*;

import javax.swing.*;



public class Background extends JPanel {
	Image image;
	
	public Background(String s,int w,int h) {
		// TODO Auto-generated constructor stub
		setLayout(null);
		image = new ImageIcon(s).getImage();
		setSize(w,h);
	}

	 
	@Override	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(),getHeight(),0,0,image.getWidth(null),image.getHeight(null),this);       
	    }
	

}
