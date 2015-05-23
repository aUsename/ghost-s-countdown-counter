package ui;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import service.Set;

public class SetPanel extends JFrame {

	
    Set setter;
	private static final long serialVersionUID = 1L;
	Background            background;
	public Button         soundButton ;
	public Button         shortcutButton ;
	public Button         confirmButton;
	public Button         cancelButton;
	public SoundPanel     soundPanel ;
	public ShortcutPanel  shortcutPanel ;
	JPanel                currentPanel;
	
	int w,h;
	SetPanel setPanel = this;
	
 	public SetPanel(int w,int h,Set set){
 		setter = set;
 		this.setUndecorated(true);
 		this.setAlwaysOnTop(true);
		setSize(w,h);
		Toolkit kit = Toolkit.getDefaultToolkit();
		java.awt.Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		setLayout(null);
		setLocation((screenWidth-w)/2, (screenHeight-h)/2);
		setLayout(null);
		setVisible(true);
		// background
		this.w =w;
		this.h =h;
		background = new Background("background"+File.separator+"setBackground.jpg",w,h);
		add(background);
		background.setBounds(0, 0, w, h);
		
		// the button
		//soundButton.setContentAreaFilled(false);
		soundButton = new Button(w/8,h/8,"button"+File.separator+"sound.png");
		background.add(soundButton);
		soundButton.setBounds(w/4, h/40, w/8, h/8);
		
		shortcutButton = new Button(w/7,h/7,"button"+File.separator+"shortcut.png");
		background.add(shortcutButton);
		shortcutButton.setBounds(w*5/8, h/40, w/8, h/8);
		
		confirmButton = new Button(w/8,h/8,"button"+File.separator+"confirm.png");
		background.add(confirmButton);
		confirmButton.setBounds(w/4, h*13/16, w/8, h/8);
		
		cancelButton = new Button(w/8,h/8,"button"+File.separator+"cancel.png");
		background.add(cancelButton);
		cancelButton.setBounds(w*5/8, h*13/16, w/8, h/8);
		
		// the panel
		currentPanel = null;
		
		shortcutPanel = new ShortcutPanel(w*6/8,h*5/8);
		shortcutPanel.setBounds(w/8,h/8,w*6/8,h*5/8);
		
		soundPanel = new SoundPanel(w*6/8,h*5/8);
        
		repaint();
		// action
		soundButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setCurrentPanel(soundPanel);
			}
			
		});
	
		shortcutButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setCurrentPanel(shortcutPanel);
			}
			
			
		});
		
		cancelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
			
			
		});
		
		confirmButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				confirm();
			}
			
			
		});
		
	}

 	private void setCurrentPanel(JPanel p){
 		if(currentPanel!= null)
 			background.remove(currentPanel);
 		background.add(p);
 		currentPanel = p;
 		p.setBounds(w/8,h/8,w*6/8,h*5/8);
 		background.repaint();
 	}
 	
 	private void confirm(){
 		int temp;
 		temp = soundPanel.soundBar.getNumber();
 		setter.setVolumeOfSound(temp);
 		
 		temp = soundPanel.musicBar.getNumber();
 		setter.setVolumeOfMusic(temp);
 		
 		//
 		//
 		
 		String s;
 		s = shortcutPanel.upText.getText();
 		if(s.length()==1)
 			setter.setShortcutUp(s.charAt(0));
 		
 		s = shortcutPanel.downText.getText();
 		if(s.length()==1)
 			setter.setShortcutDown(s.charAt(0)); 
 		
 		s = shortcutPanel.launchText.getText();
 		if(s.length()==1)
 			setter.setShortcutLaunch(s.charAt(0)); 		
 		
 		s = shortcutPanel.backText.getText();
 		if(s.length()==1)
 			setter.setShortcutBack(s.charAt(0));
 		
 		s = shortcutPanel.pauseText.getText();
 		if(s.length()==1)
 			setter.setShortcutPause(s.charAt(0));
 		
 		
 		if(soundPanel.turnOffMusic.isSelected()){
 			setter.setMusic(false);
 		}else{
 			setter.setMusic(true);
 		}
 		
 		if(soundPanel.turnOffSound.isSelected()){
 			setter.setSound(false);
 		}else{
 			setter.setSound(true);
 		}
 		
 	}
 	
 	class SoundPanel extends JPanel{
 		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		MobileBar soundBar;
 		MobileBar musicBar;	
 		
 		ButtonGroup musicGroup;
 		ButtonGroup soundGroup;
 		JCheckBox   turnOnMusic;
 		JCheckBox   turnOffMusic;
 		JCheckBox   turnOnSound;
 		JCheckBox   turnOffSound; 
 		
 		JLabel sound;
 		JLabel music;
 		JLabel soundOn;
 		JLabel musicOn;
 		
 		
		SoundPanel(int w,int h){ 
 			setSize(w,h);
	    	setLayout(null);
	    	setOpaque(false);
	    	
	    	sound = new JLabel("音效音量");
	    	music = new JLabel("音乐音量");
	    	soundOn = new JLabel("音效开关");
	    	musicOn  = new  JLabel("音乐开关");
	    	
	    	soundBar = new MobileBar(w/2,h/8);
	    	musicBar = new MobileBar(w/2,h/8);
	    	
	    	musicGroup = new ButtonGroup();
	 		soundGroup = new ButtonGroup();

	 		turnOnMusic = new JCheckBox();
	 		turnOffMusic = new JCheckBox() ;
	 		turnOnSound = new JCheckBox();
	 		turnOffSound = new JCheckBox() ; 
	 		
	 		
	    	
	    	add(musicBar);
	    	add(soundBar);
	    	add(sound);
	    	add(music);
	    	add(soundOn);
	    	add(musicOn);
	    	
	    	add(turnOnMusic);
	    	add(turnOffMusic);
	    	add(turnOnSound);
	    	add(turnOffSound);
	    	
	    	
	    	sound.setBounds(w/8, h/8, w/8, h/8);
	    	music.setBounds(w/8, h*3/8, w/8, h/8);
	    	musicBar.setBounds(w*3/8,h/8,w/2,h/8);
	    	soundBar.setBounds(w*3/8, h*3/8, w/2, h/8);
	    	
	        musicOn.setBounds(w/8, h*5/8, w/8, h/8);
	    	soundOn.setBounds(w/8, h*7/8, w/8, h/8);
	    	turnOnMusic.setBounds(w*3/8, h*5/8, w/4, h/8);
	    	turnOffMusic.setBounds(w*6/8, h*5/8, w/4, h/8);
	    	turnOnSound.setBounds(w*3/8, h*7/8, w/4, h/8);
	    	turnOffSound.setBounds(w*6/8, h*7/8, w/4, h/8);
	    	
	    	turnOffMusic.setOpaque(false);
	    	turnOnMusic.setOpaque(false);
	    	turnOffSound.setOpaque(false);
	    	turnOnSound.setOpaque(false);
	    	
	    	musicGroup.add(turnOffMusic);
	    	musicGroup.add(turnOnMusic);
	    	soundGroup.add(turnOffSound);
	    	soundGroup.add(turnOnSound);
 		}
 		
 		
 	}

 	
 	
 	class ShortcutPanel extends JPanel{
 	     /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JLabel upLabel;
 	     JLabel downLabel;
 	     JLabel backLabel;
 	     JLabel pauseLabel;
 	     JLabel launchLabel;
 	     
 	     JTextArea upText;
 	     JTextArea downText;
 	     JTextArea pauseText;
 	     JTextArea backText;
 	     JTextArea launchText;
 	  
 	     ShortcutPanel(int w,int h){
 	    	 setSize(w,h);
 	    	 setLayout(null);
 	    	 setOpaque(false);
 	    	 
 	    	 upLabel = new JLabel("音量增");
 	    	 downLabel = new JLabel("音量减");
 	    	 backLabel = new JLabel("返回");
 	    	 pauseLabel = new JLabel("暂停");
 	    	 launchLabel = new JLabel("发射");
 	    	 
 	    	 upText = new JTextArea("");
 	    	 downText = new JTextArea("");
 	    	 backText = new JTextArea("");
 	    	 launchText = new JTextArea("");
 	    	 pauseText = new JTextArea("");
 	    	 
 	    	 
 	    	 
 	    	 add(upLabel);
 	    	 add(upText);
 	    	 add(downLabel);
 	    	 add(downText);
 	    	 add(pauseLabel);
 	    	 add(pauseText);
 	    	 add(backLabel);
 	    	 add(backText);
 	    	 add(launchLabel);
 	    	 add(launchText);
 	    	 
 	    	 int wl = w/5;
 	    	 int hl = h/10;
 	    	 
 	    	 upLabel.setBounds(wl,hl,wl,hl);
    	     downLabel.setBounds(wl,3*hl,wl,hl);
    	     pauseLabel.setBounds(wl,5*hl,wl,hl);
    	     backLabel.setBounds(wl,7*hl,wl,hl);
    	     launchLabel.setBounds(wl,9*hl,wl,hl);
    	     
    	     upText.setBounds(2*wl,hl,2*wl,hl);
    	     downText.setBounds(2*wl,3*hl,2*wl,hl);
    	     pauseText.setBounds(2*wl,5*hl,2*wl,hl);
    	     backText.setBounds(2*wl,7*hl,2*wl,hl);
    	     launchText.setBounds(2*wl,9*hl,2*wl,hl);
 	     }
 	}
	
 	
 	
 	class Button extends JButton{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String sorce;
	    ImageIcon icon;
	    Image image ;
	    /**
	     * @param a is the width of button
	     * @param b is the height of button
	     * @param name is the name of the picture
	     */
	    public Button(int a,int b,String name) {
	    	sorce = name;
	    	icon= new ImageIcon(sorce);
	    	image =icon.getImage();
	    	
	    	setContentAreaFilled(false);  
		    icon.getImage();
		    setBorder(null);
		    // no changes to picture's content,enlarge or smaller 
			Image image1 = image.getScaledInstance(a, b,  Image.SCALE_DEFAULT);
			Image image2 = image.getScaledInstance(a-10, b-10,  Image.SCALE_DEFAULT);
			
			setBackground(Color.pink);
			setIcon(new ImageIcon(image1));
			setRolloverIcon(new ImageIcon(image2));
			
			setSize(a,b);
		}
	    
	    
	}
	
    public static void main(String[] args){
    	new SetPanel(400, 400, new Set());
    }
    
}
