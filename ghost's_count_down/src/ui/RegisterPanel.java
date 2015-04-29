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
	    public static RegisterPanel registerPanel;

		public void paintComponent(Graphics g) {
			g.drawImage(BackgroundLogin, 0, 0, this);       
	    }
				
		public RegisterPanel() {
		   	registerPanel.setSize(1100,700);
		    registerPanel.setVisible(true);
	        this.setLayout(null);
			BufferedImage bufferedLogin = null; 
			try{
				bufferedLogin = ImageIO.read(new File("background"+File.separator+"login.png"));
			}catch(IOException ex){
				ex.printStackTrace();
			}
		
			BackgroundLogin = bufferedLogin;

			registerPanel.setVisible(true);
	}
		        
		
	public static void main(String[] args){
		RegisterPanel a = new RegisterPanel();
	}	
		
		
}
