package ui;


import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Frame extends JFrame  {
	
	int width=1100,height=700;
	
	public Frame(){
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		java.awt.Dimension screenSize = kit.getScreenSize();
		
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

	
		setLayout(null);
		setLocation((screenWidth-1100)/2, (screenHeight-700)/2);
		setSize(1100, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		


		
		
		//setVisible(true);
		
	    
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

				new Frame();
	
	}

}
