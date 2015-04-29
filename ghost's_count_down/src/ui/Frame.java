package ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame  {
	private static ImageIcon background;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();		
		frame.setLayout(null);

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
		
		
	}

}
