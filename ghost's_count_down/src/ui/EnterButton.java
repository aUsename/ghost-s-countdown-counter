package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class EnterButton extends JButton{
	
	
	Image   ButtonImage = null;
	String  filePath = null;

	public boolean isIn = false;
	public boolean isPressed = false;
		

	
	public  EnterButton(){
	
		setBorder(null);
		setOpaque(false);
		filePath = "button/enter0.png";
		ButtonImage = new ImageIcon(filePath).getImage();
		this.setBounds(0, 0, 415, 220);


	}
	
	
	public void paintComponent(Graphics g){
		
		
		if(isPressed){
			filePath = "button/enter2.png";
			ButtonImage = new ImageIcon(filePath).getImage();
		}
		else if(!isIn){
			filePath = "button/enter0.png";
			ButtonImage = new ImageIcon(filePath).getImage();
		}else{
			filePath = "button/enter1.png";
			ButtonImage = new ImageIcon(filePath).getImage();
		}
		
		g.drawImage(ButtonImage,0,0,this.getWidth(),this.getHeight(),this);
	}

	
}

