package ui;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class EnterButton extends JButton implements MouseListener{
	
	
	Image   ButtonImage = null;
	String  filePath = null;

	public boolean isIn = false;
	public boolean isPressed = false;

	
	public  EnterButton(){
	
		setBorder(null);
		setOpaque(false);
		filePath = "button/enter0.png";
		ButtonImage = new ImageIcon(filePath).getImage();

	}
	
	
	public void paintComponent(Graphics g){
		
	
			filePath = "button/EnterButton.png";
			ButtonImage = new ImageIcon(filePath).getImage();
		
		
		g.drawImage(ButtonImage,0,0,this.getWidth(),this.getHeight(),this);
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
			setCursor(new   Cursor(Cursor.HAND_CURSOR));   
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		   setCursor(new   Cursor(Cursor.DEFAULT_CURSOR)); 
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}

