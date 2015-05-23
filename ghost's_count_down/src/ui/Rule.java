package ui;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Rule extends JFrame implements MouseListener{
 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Background back;
	Background back1;
	Background back2;
	Button     close;
	JFrame     frame;
	
	int w,h;
	
	public Rule(){
	   frame = this;
	   w = 600;
	   h = 600;
	   setSize(w,h);
	   this.setUndecorated(true);
	   Toolkit kit = Toolkit.getDefaultToolkit();
	   java.awt.Dimension screenSize = kit.getScreenSize();
		
	   int screenWidth = screenSize.width;
	   int screenHeight = screenSize.height;
	   setLayout(null);
	   setLocation((screenWidth- w)/2, (screenHeight-h)/2);
	   
	   addMouseListener(this);
	   back1 = new Background("background"+File.separator+"rule1.jpg", w,h);
	   back2 = new Background("background"+File.separator+"rule2.jpg", w,h);
	   close = new Button("button"+File.separator+"close.png");
	   close.setFocusable(false);
	   close.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.dispose();
		}
		   
	   });
	 
	   back = back1;
	   add(back);
	   back.setBounds(0,0, w, h);
       back.add(close);
       close.setBounds(550,0,30,20);
       
	   setVisible(true);

	}
	
	private void setBack(Background b){
		remove(back);
		back = b;
		 back.add(close);
	      
		add(back);
		close.setBounds(550,0,30,20);
		back.setBounds(0,0,w,h);
		repaint();
	}
	
	
	class Button extends JButton{

		private static final long serialVersionUID = 1L;
        ImageIcon icon;
		
		Button(String s){
			setLayout(null);
			setBorder(null);
			setBackground(Color.BLACK);
			setOpaque(false);
			setSize(30,20);
        	icon = new ImageIcon(s);
        	setIcon(new ImageIcon(icon.getImage().getScaledInstance(30 ,20, Image.SCALE_DEFAULT)));	
        }
	       
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(back == back1)
		setBack(back2);
		else
	    setBack(back1);
		
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
