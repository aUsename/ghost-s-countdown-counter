package ui;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class InvisibleButton extends JButton implements MouseListener{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	Image   ButtonImage = null;
	String  filePath = null;
	boolean opaque;
	
	public InvisibleButton(int w,int h){
		setBorder(null);
		setOpaque(false);
		setSize(w,h);
		this.addMouseListener(this);
       this.opaque = true;
	}
	
	public void paintComponent(Graphics g){
		if(opaque){
			filePath = "button/play0.png";
		    ButtonImage = new ImageIcon(filePath).getImage();
		    g.drawImage(ButtonImage,0,0,this.getWidth(),this.getHeight(),this);
		}
	
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
		setCursor(new   Cursor(Cursor.HAND_CURSOR));   
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		setCursor(new   Cursor(Cursor.DEFAULT_CURSOR)); 
	}
}
