package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DoubleButton extends JButton implements MouseListener{
	
		String button0 = "button"+File.separator+"DoubleButton0.png";
	    String button1 = "button"+File.separator+"DoubleButton1.png";
	    Image buttonImage = null;
	    boolean isIn = false;
	    
		public DoubleButton() {
			setLayout(null);
			setOpaque(false);
			buttonImage = new ImageIcon(button0).getImage();
			
		}
		
		public void paintComponent(Graphics g){
			if(isIn)
				buttonImage = new ImageIcon(button1).getImage();
			else
				buttonImage = new ImageIcon(button0).getImage();
			g.drawImage(buttonImage,0,0,this.getWidth(),this.getHeight(),this);
//		    setBorder(null);
//			setOpaque(false);
//		    icon.getImage();
//		    setBorder(null
//		    		);
//		    // no changes to picture's content,enlarge or smaller 
//			Image image1 = image.getScaledInstance(a, b,  Image.SCALE_DEFAULT);
//			Image image2 = image.getScaledInstance(a-5, b-5,  Image.SCALE_DEFAULT);
//			
//			
//			// change the content
//		    // ����
//			//
//			setBackground(null);
//			setIcon(new ImageIcon(image1));
//			setRolloverIcon(new ImageIcon(image2));
//			
//			setSize(a,b);
			// TODO Auto-generated constructor stub
		
		// TODO Auto-generated constructor stub
//		setBorder(null);
//		setOpaque(false);
//	    icon.getImage();
//	    setBorder(null);
//	    // no changes to picture's content,enlarge or smaller 
//		Image image1 = image.getScaledInstance(a, b,  Image.SCALE_DEFAULT);
//		Image image2 = image.getScaledInstance(a-10, b-10,  Image.SCALE_DEFAULT);
//		
//		
//		// change the content
//	    // ����
//		//
//		setBackground(Color.white);
//		setIcon(new ImageIcon(image1));
//		setRolloverIcon(new ImageIcon(image2));
//		
//		setSize(a,b);
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
