package ui;

import game.Sign;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;


public class SplashWindow extends JWindow implements Runnable{
	
	int w=400,h=270;
	
	String sorce = "background"+File.separator+"splash.jpg";
	ImageIcon  icon;
	Image      image;
    Thread     thread;
    Sign    s;
    
	public SplashWindow(Sign s){
		this.s =s ;
		setSize(w,h);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width-w)/2,(screen.height-h)/2);
		
		JPanel panel = new JPanel();
		icon = new ImageIcon(sorce);
		image = icon.getImage();
		image = image.getScaledInstance(w, h, Image.SCALE_DEFAULT);
		panel.add(new JLabel(new ImageIcon(image)));
		add(panel);
		
		setVisible(true);
		thread = new Thread(this);
		thread.start();
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		dispose();
		s.sign = true;
	}
	
	
   	
}
