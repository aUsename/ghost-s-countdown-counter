package ui;

import java.awt.Color;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JPanel;

public class IntroductionButton extends JButton {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 4618595990063205874L;
		String sorce = "button"+File.separator+"IntroductionButton0.png";
	    ImageIcon icon= new ImageIcon(sorce);
	    Image image =icon.getImage();
	    /**
	     * 
	     * @param a is the width of button
	     * @param b is the height of button
		 */
	    
		public IntroductionButton(int a,int b) {
		    
		   
			setOpaque(false);
		    icon.getImage();
		    setBorder(null);
		    // no changes to picture's content,enlarge or smaller 
			Image image1 = image.getScaledInstance(a, b,  Image.SCALE_DEFAULT);
			Image image2 = image.getScaledInstance(a-5, b-5,  Image.SCALE_DEFAULT);
			setSize(a,b);
	 	    setBackground(Color.white);
			setIcon(new ImageIcon(image1));
			setRolloverIcon(new ImageIcon(image2));
			
			
			// TODO Auto-generated constructor stub
		}
}