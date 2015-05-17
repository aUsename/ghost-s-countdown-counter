package ui;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
    
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 5621485351345206242L;
	public ClockPanel clockPanel;
    public TimePanel  timePanel;
    ImageIcon icon = new ImageIcon("background"+File.separator+"GameBackgroung.png");
 
    public GamePanel(){
    	setLayout(null);
    	
    }
    
    public void addComponent(){
   
    
    	
    	add(clockPanel);
    	add(timePanel);
    	
    	setBackground(Color.gray);
    	timePanel.setBounds(0,0,getWidth(),getHeight()/6);
    	clockPanel.setBounds(getWidth()*2/8,getHeight()/8,getHeight()*6/8,getHeight()*6/8);
    	clockPanel.pointers.setBounds(0,0,clockPanel.getWidth(),clockPanel.getHeight());
    	//repaint();
    	
    }
   
    @Override
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
	    Image image = icon.getImage(); 
    	g.drawImage(image, 0, 0, getWidth(),getHeight(),0,0,image.getWidth(null),image.getHeight(null),this);  
    }
    

}
