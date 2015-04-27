package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class EnterButton extends JLabel implements MouseListener {
	Image ButtonImage = null;
	String filePath = null;
	static boolean isIn = false;
	
	public void ButtonStart(){
		filePath = "graphics/button/enter0.png";
		ButtonImage = new ImageIcon(filePath).getImage();
		this.setBounds(300, 500, 415, 95);
	}
	
	public void paintComponent(Graphics g){
		if(!isIn){
			filePath = "graphics/button/enter0.png";
			ButtonImage = new ImageIcon(filePath).getImage();
		}else{
			filePath = "graphics/button/enter1.png";
			ButtonImage = new ImageIcon(filePath).getImage();
		}
		g.drawImage(ButtonImage,0,0,this.getWidth(),this.getHeight(),this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
