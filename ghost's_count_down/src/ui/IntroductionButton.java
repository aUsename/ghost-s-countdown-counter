package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JPanel;

public class IntroductionButton extends JButton implements MouseListener {
	String button0 = "button"+File.separator+"introductionButton0.png";
    String button1 = "button"+File.separator+"introductionButton1.png";
    Image buttonImage = null;
    boolean isIn = false;
   
	public IntroductionButton() {
		
		setBorder(null);
		setOpaque(false);
		buttonImage = new ImageIcon(button0).getImage();
	}
	
	public void paintComponent(Graphics g){
		if(isIn)
			buttonImage = new ImageIcon(button1).getImage();
		else
			buttonImage = new ImageIcon(button0).getImage();
		g.drawImage(buttonImage,0,0,this.getWidth(),this.getHeight(),this);
//	   
		// TODO Auto-generated constructor stub
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
		isIn = true;
		repaint();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		isIn = false;
		repaint();
	}

}
