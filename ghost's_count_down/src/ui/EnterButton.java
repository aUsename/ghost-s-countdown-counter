package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class EnterButton extends JLabel {
	Image ButtonImage = null;
	String filePath = null;
	public boolean isIn = false;
	

	
	public EnterButton(){
		setBounds(315, 450, 415, 220);
	}
	
	
	public void paintComponent(Graphics g){
		if(!isIn){
			filePath = "button/enter.png";
			ButtonImage = new ImageIcon(filePath).getImage();
		}else{
			filePath = "button/enter0.png";
			ButtonImage = new ImageIcon(filePath).getImage();
		}
		
		g.drawImage(ButtonImage,0,0,this.getWidth(),this.getHeight(),this);
	}

}
