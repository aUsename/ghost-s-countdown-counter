package ui;

<<<<<<< HEAD
=======
import java.awt.Dimension;
>>>>>>> origin/master
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
<<<<<<< HEAD
		JFrame frame = new JFrame();
		Toolkit kit = Toolkit.getDefaultToolkit();
		java.awt.Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
=======
<<<<<<< HEAD
=======
		JFrame frame = new JFrame();		
		frame.setLayout(null);
>>>>>>> origin/master

		frame.setLayout(null);
		frame.setLocation((screenWidth-1100)/2, (screenHeight-700)/2);
		frame.setSize(1100, 700);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		EnterPanel ep = new EnterPanel();
		ep.setOpaque(false);

		frame.setSize(1100, 700);				
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		background = new ImageIcon("button/enterBackground.png");
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, 1100, 700);
		
		
		

		frame.add(ep);
		ep.setBounds(0, 0, 1100, 700);
		
		ep.setLayout(null);
		EnterButton eb = new EnterButton();
//<<<<<<< HEAD
		
		
//=======
		eb.setBounds(315, 450, 415, 220);		
		ep.add(eb);
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
//>>>>>>> origin/master
		frame.setVisible(true);
>>>>>>> origin/master
		
		Frame frame = new Frame();	
		
		EnterPanel ep = new EnterPanel(frame.getWidth(),frame.getHeight());
        frame.add(ep);
	
	}

}
