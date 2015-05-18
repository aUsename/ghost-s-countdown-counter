package ui;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SetButton extends JButton {

    /**
	 * 
	 */
	private static final long serialVersionUID = -749014324455300879L;

	String sorce = "button"+File.separator+"set.png";
    
    //
    ImageIcon icon= new ImageIcon(sorce);
	//
    Image image =icon.getImage();
    /**
     * 
     * @param a is the width of button
     * @param b is the height of button
     */
    public SetButton(int a,int b) {
    	
    	setOpaque(false);
	    icon.getImage();
	    setBorder(null
	    		);
	    // no changes to picture's content,enlarge or smaller 
		Image image1 = image.getScaledInstance(a, b,  Image.SCALE_DEFAULT);
		Image image2 = image.getScaledInstance(a-5, b-5,  Image.SCALE_DEFAULT);
		
		
		// change the content
	    // ����
		//
		setBackground(null);
		setIcon(new ImageIcon(image1));
		setRolloverIcon(new ImageIcon(image2));
		setBorder(null);
		setSize(a,b);
	
		
	}

	
   // just for test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         JFrame f = new JFrame();
         f.setLayout(null);
         f.setSize(400,400);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         JPanel p =new JPanel();
         p.setLayout(null);
         p.setBackground(Color.green);
         f.add(p);
         p.setBounds(0, 0, f.getWidth(), f.getHeight());
         f.setVisible(true);
         SetButton button = new  SetButton(200,150);
         p.add(button);
         button.setBounds(100,100,200,150);
	}

}
