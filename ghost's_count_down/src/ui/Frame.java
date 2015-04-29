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
	    setLayout(null);
	    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation((screen.width-width)/2,(screen.height-height)/2);
		setSize(width,height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Frame frame = new Frame();	
		
		EnterPanel ep = new EnterPanel(frame.getWidth(),frame.getHeight());
        frame.add(ep);
	
	}

}
