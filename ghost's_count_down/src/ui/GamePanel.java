package ui;


import game.DoubleMode;
import game.Launcher;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import service.Set;

public class GamePanel extends JPanel{
    
	
	private static final long serialVersionUID = 5621485351345206242L;
	public ClockPanel clockPanel;
    ImageIcon icon = new ImageIcon("background"+File.separator+"GameBackgroung.png");
   
    public JButton   pause;
  	public JButton   back;
  	public JButton   musicOn;
  	public JButton   soundOn;   
  	public JPanel panel;
  	
  	public ImageIcon iconPause   = new ImageIcon("button"+File.separator+"pause.png");
  	public ImageIcon iconUnpause = new ImageIcon("button"+File.separator+"play0.png");
  	public ImageIcon iconMusicOn = new ImageIcon("button"+File.separator+"bgmOn.png");
  	public ImageIcon iconMusicOff= new ImageIcon("button"+File.separator+"bgmOff.png");
  	public ImageIcon iconSoundOn = new ImageIcon("button"+File.separator+"soundSpecialOn.png");
  	public ImageIcon iconSoundOff= new ImageIcon("button"+File.separator+"soundSpecialOff.png");
  	public ImageIcon iconBack    = new ImageIcon("button"+File.separator+"return.png");
  	
  	
	 
  	
    public GamePanel(){
    	setLayout(null);
    	
     	pause    = new JButton();
     	back     = new JButton();
     	musicOn  = new JButton();
        soundOn  = new JButton();
         
         panel = new JPanel(); 
         panel.setOpaque(false);
         panel.setLayout(null);
         
         back.setBackground(Color.green);
         musicOn.setBackground(Color.green);
         pause.setBackground(Color.green);
         soundOn.setBackground(Color.green);
         
         panel.add(musicOn);
         panel.add(back);
         panel.add(pause);
         panel.add(soundOn);
        
    }
    
    public void addComponent(){
        add(panel);
    	add(clockPanel);
    	clockPanel.setBounds(getWidth()*3/16,getHeight()/8,getHeight()*6/8,getHeight()*6/8);
    	clockPanel.pointers.setBounds(0,0,clockPanel.getWidth(),clockPanel.getHeight());
    	
    	panel.setBounds(getWidth()*13/16,getHeight()*2/8,getWidth()/8,getHeight()/3);
    	 
    	//repaint();
    	pause.setBounds(0, 0,                        panel.getWidth(), panel.getHeight()/4);
    	back.setBounds(0, panel.getHeight()/4,      panel.getWidth(), panel.getHeight()/4);
    	musicOn.setBounds(0, 2*panel.getHeight()/4, panel.getWidth(), panel.getHeight()/4);
    	soundOn.setBounds(0, 3*panel.getHeight()/4, panel.getWidth(), panel.getHeight()/4);
    	
    	pause.setFocusable(false);
    	back.setFocusable(false);
    	musicOn.setFocusable(false);
    	soundOn.setFocusable(false);
    	
    	pause.setOpaque(false);
    	back.setOpaque(false);
    	musicOn.setOpaque(false);
    	soundOn.setOpaque(false);
    	
    	pause.setBorder(null);
    	back.setBorder(null);
    	musicOn.setBorder(null);
    	soundOn.setBorder(null);
    	
    	iconMusicOn  = new ImageIcon(iconMusicOn. getImage().getScaledInstance(panel.getWidth(), panel.getHeight()/4, Image.SCALE_DEFAULT));
    	iconMusicOff = new ImageIcon(iconMusicOff.getImage().getScaledInstance(panel.getWidth(), panel.getHeight()/4, Image.SCALE_DEFAULT));
    	iconSoundOn  = new ImageIcon(iconSoundOn.getImage().getScaledInstance(panel.getWidth(), panel.getHeight()/4, Image.SCALE_DEFAULT));
    	iconSoundOff = new ImageIcon(iconSoundOff.getImage().getScaledInstance(panel.getWidth(), panel.getHeight()/4, Image.SCALE_DEFAULT));
    	iconPause = new ImageIcon(iconPause.getImage().getScaledInstance(panel.getWidth(), panel.getHeight()/4, Image.SCALE_DEFAULT));
    	iconUnpause = new ImageIcon(iconUnpause.getImage().getScaledInstance(panel.getWidth(), panel.getHeight()/4, Image.SCALE_DEFAULT));
    	iconBack = new ImageIcon(iconBack.getImage().getScaledInstance(panel.getWidth(), panel.getHeight()/4, Image.SCALE_DEFAULT));
    	
    	pause.setIcon(iconPause);
    	back.setIcon(iconBack);
    	if(Set.isMusicOn){
    		musicOn.setIcon(iconMusicOn);
    	}else{
    		musicOn.setIcon(iconMusicOff);
    	}
    	if(Set.isSoundOn){
    		soundOn.setIcon(iconSoundOn);
    	}else{
    		soundOn.setIcon(iconSoundOff);
    	}
    }
   

    @Override
    public void paintComponent(Graphics g){
    	super.paintComponent(g);
	    Image image = icon.getImage(); 
    	g.drawImage(image, 0, 0, getWidth(),getHeight(),0,0,image.getWidth(null),image.getHeight(null),this);  
    	
    }

}
