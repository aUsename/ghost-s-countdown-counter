package ui;


import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Frame extends JFrame  {
	
	public static int width=1100;
	public static int height=700;
	
	public Frame(){
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		java.awt.Dimension screenSize = kit.getScreenSize();
		
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

	
		setLayout(null);
		setLocation((screenWidth-width)/2, (screenHeight-height)/2);
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

				new Frame();
	
	}

}
