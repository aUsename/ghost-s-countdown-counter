package ui;


import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Frame extends JFrame  {
<<<<<<< HEAD
	private static ImageIcon background;
	
=======
	
	int width=1100,height=700;
	
	public Frame(){
<<<<<<< HEAD
		
=======
	    setLayout(null);
	    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation((screen.width-width)/2,(screen.height-height)/2);
		setSize(width,height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	}
>>>>>>> origin/master
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		JFrame frame = new JFrame();
>>>>>>> origin/master
		Toolkit kit = Toolkit.getDefaultToolkit();
		java.awt.Dimension screenSize = kit.getScreenSize();
		
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

	
		setLayout(null);
		setLocation((screenWidth-1100)/2, (screenHeight-700)/2);
		setSize(1100, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		EnterPanel ep = new EnterPanel(width,height);
		ep.setOpaque(false);
		
		
		

		add(ep);
		ep.setBounds(0, 0, 1100, 700);

		
		
		setVisible(true);
		
	    
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

				new Frame();
	
	}

}
