package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JPanel;

import service.Music;
import service.Set;
import service.SoundEffect;
import ui.ChoicePanel;
import ui.EnterPanel;
import ui.Frame;
import ui.GamePanel;
import ui.RegisterPanel;
import ui.SetPanel;
import ui.SplashWindow;


public class Launcher implements KeyListener{
	
	
        boolean      isOnGame     = false; 
	    Mode         currentMode; 
	    boolean      isSingleMode = true; 
	    Frame        frame        = new Frame();
	    ChoicePanel  choicePanel;
	    GamePanel    gamePanel; 
	    JPanel       currentPanel = null;
	    Set          setter       = new Set();
	    PlayerInfo   player;
	    int          currentLocation;
	    Upgrade      upgrade;
	  
        SoundEffect  soundButton;
        SoundEffect  soundLaunch;
	    
	    public Launcher(){
	    
	    	new SplashWindow().start();
            frame.setVisible(true);
            frame.addKeyListener(this);
            
            Music mu = new Music("music"+File.separator+"background.wav"); 
            new  Thread(mu).start();
            soundButton = new SoundEffect("music"+File.separator+"button.wav");
            soundLaunch = new SoundEffect("music"+File.separator+"launch.wav");
            
	        EnterPanel ep = new EnterPanel(frame.getWidth(),frame.getHeight());
	        setCurrentPanel(ep);
	        ep.eb.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Thread(soundButton).start();
					enterChoices();
				}
        	
	        });
	    }
	    
	    
	    
	    
	    private void enterChoices() {
					// TODO Auto-generated method stub
			choicePanel = new ChoicePanel(frame.getContentPane().getWidth(), frame.getContentPane().getHeight());		
	        setCurrentPanel(choicePanel);
	        choicePanel.grabFocus();
	        choicePanel.addKeyListener(this);
	        choicePanel.exit.addKeyListener(this);
	        choicePanel.single.addKeyListener(this);
	        choicePanel.doub.addKeyListener(this);
	        choicePanel.set.addKeyListener(this);
	        
	        choicePanel.exit.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Thread(soundButton).start();
					System.exit(0);
				}
	        	
	        });
    
	        
	        choicePanel.set.addActionListener(new ActionListener(){


				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Thread(soundButton).start();
					new SetPanel(choicePanel.getWidth()/3,choicePanel.getHeight()/2,setter);
				    
				}
	        	
	        });

	        
	        choicePanel.single.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Thread(soundButton).start();
					register();
				}
	        	
	        });
	        
	        
	        choicePanel.doub.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Thread(soundButton).start();
					startDoubleMode();
				}
	        	
	        });
	    }

	    void upgrade(){
	    	if(upgrade!=null){
	    		upgrade.up.frame.dispose();
	    	}
	    	upgrade = new Upgrade(this);
	    	
	    	new Thread(upgrade).start();
	    	
	    }
	   


		public void startDoubleMode(){
	        
			gamePanel = new GamePanel();
	    	isOnGame = true;
	    	setCurrentPanel(gamePanel);
	    	gamePanel.addKeyListener(this);
	    	gamePanel.grabFocus();
	    	Mode game = new DoubleMode(setter,this);
	    	gamePanel.clockPanel = game.clockPanel;
	    	gamePanel.timePanel = game.timePanel;	
	    	currentMode = game;
	    	isSingleMode = false;
	    	gamePanel.addComponent();   	
	    	new Thread(game).start();
	    }
		
	    
		
		private void register(){
			RegisterPanel registerPanel = new RegisterPanel();
			registerPanel.registerButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String name = registerPanel.getText();
					try {
						player = PlayerInfo.CreatPlayer(name);
						registerPanel.frame.dispose();
						upgrade();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			});
		}
	    
		void setCurrentPanel(JPanel panel) {
			// TODO Auto-generated method stub
	    	if(currentPanel!=null)
	    		frame.remove(currentPanel);
		    currentPanel = panel; 
		    frame.add(currentPanel);
		    currentPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		    frame.repaint();
		}
	  
	
		void comeback() {
			// TODO Auto-generated method stub
			if(isOnGame){
				currentMode.isAlive = false;
				currentMode.isOnGame = false;
				            isOnGame = false;
				setCurrentPanel(choicePanel);
				if(upgrade != null)
			    this.upgrade.up.frame.dispose();	
			}
		}
	    

		
	    public static void main(String[] args) {
		// TODO Auto-generated method stub
		    new Launcher();
	    }




		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}




		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()==Set.shortcutLaunch){
				if(isOnGame){
				    
					currentMode.launch();
				}
				else if(currentPanel == choicePanel){
					
				}
			}
			if(e.getKeyCode()== Set.shortcutPause){
				if(isOnGame){
					Mode.isPause = !Mode.isPause;
				}
				
			}
			
			if(e.getKeyCode() == Set.shortcutBack){
				comeback();
			}
			if(e.getKeyCode()== Set.shortcutUp){
				setter.setVolumeOfSound(+1);
				
			}
			if(e.getKeyCode()== Set.shortcutDown){
				setter.setVolumeOfMusic(-1);
				
			}
		}


 

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		
		
}
