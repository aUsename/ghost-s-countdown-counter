package ui;

import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class RegisterPanel extends JPanel {
		public JButton confirm;
		Image BackgroundLogin;


		public void paintComponent(Graphics g) {
			g.drawImage(BackgroundLogin, 0, 0, this);       
	    }
				
		public RegisterPanel() {
		   	setSize(500,700);
		    setVisible(true);
	        setLayout(null);
	        
			BufferedImage bufferedLogin = null; 
			try{
				bufferedLogin = ImageIO.read(new File("background"+File.separator+"login.png"));
			}catch(IOException ex){
				ex.printStackTrace();
			}
		
			BackgroundLogin = bufferedLogin;
			
		
	   	}
		 
		
	/*public static void main(String[] args){
		RegisterPanel a = new RegisterPanel();
	    JFrame  f =new JFrame();
	    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    f.setLocation((screen.width-500)/2,(screen.height-700)/2);
		f.setSize(500,700);
	    f.setVisible(true);
	    f.add(a);
	}*/	
		
		
}
