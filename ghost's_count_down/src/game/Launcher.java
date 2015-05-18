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
	    public static boolean      isSingleMode = true; 
	    Frame        frame        = new Frame();
	    ChoicePanel  choicePanel;
	    GamePanel    gamePanel; 
	    JPanel       currentPanel = null;
	    Set          setter       = new Set();
	    PlayerInfo   player;
	    
	    Upgrade      upgrade;
	  
	    RegisterPanel registerPanel;
        SoundEffect  soundButton;
        SoundEffect  soundLaunch;
        SoundEffect  soundBeat;
        SoundEffect  soundFail;
        SoundEffect  soundWin;
        int       currentLocation ;

         /**
          *location == 0.00 ; enterPanel
          *location == 1.10 ; choicePanel.singleButton
          *location == 1.20 ; choicePanel.doubleButton
          *location == 1.30 ; choicePanel.setButton
          *location == 1.40 ; choicePanel.exitButton
          *location == 1.31 ; setPanel
          *location == 1.11 ; registerPanel
          *location == 2.10 ; upgradePanel
          *location == 2.20 ; gamePanel
          */
	    
        
        
	    public Launcher(){
	        currentLocation = 0;
	        
	    	new SplashWindow().start();
            frame.setVisible(true);
            frame.addKeyListener(this);
            Music mu = new Music("music"+File.separator+"background.wav"); 
            
            soundButton = new SoundEffect("music"+File.separator+"button.wav");
            soundLaunch = new SoundEffect("music"+File.separator+"launch.wav");
            soundBeat    = new SoundEffect("music"+File.separator+"beat.wav");
            soundFail   = new SoundEffect("music"+File.separator+"fall.wav");
            soundWin    = new SoundEffect("music"+File.separator+"win.wav");
            
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
	    	currentLocation = 1;
			choicePanel = new ChoicePanel(frame.getContentPane().getWidth(), frame.getContentPane().getHeight());		
	        setCurrentPanel(choicePanel);
	        new Thread(choicePanel).start();
	        choicePanel.grabFocus();
	        choicePanel.addKeyListener(this);
	        choicePanel.exit.addKeyListener(this);
	        choicePanel.single.addKeyListener(this);
	        choicePanel.doub.addKeyListener(this);
	        choicePanel.intr.addKeyListener(this);
	        
	        choicePanel.exit.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Thread(soundButton).start();
					System.exit(0);
				}
	        	
	        });
    
	        
	        choicePanel.intr.addActionListener(new ActionListener(){


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
	    	currentLocation = 3;
	    	upgrade = new Upgrade(this);
	    	
	    	new Thread(upgrade).start();
	    	
	    }
	   


		public void startDoubleMode(){
	        currentLocation = 4;
			gamePanel = new GamePanel();
	    	isOnGame = true;
	    	setCurrentPanel(gamePanel);
	    	gamePanel.addKeyListener(this);
	    	gamePanel.grabFocus();
	    	Mode game = new DoubleMode(setter,this);
	    	gamePanel.clockPanel = game.clockPanel;
	    
	    	currentMode = game;
	    	isSingleMode = false;
	    	gamePanel.addComponent(); 
	    	
	     	gamePanel.pause.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					DoubleMode.isPause = !DoubleMode.isPause;
					if(DoubleMode.isPause){
						gamePanel.pause.setIcon(gamePanel.iconUnpause);
					}else{
						gamePanel.pause.setIcon(gamePanel.iconPause);
					}
					gamePanel.pause.repaint();
				}
	    		
	    	});
	    	gamePanel.back.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					comeback();
				}
	    		
	    	});
	    	gamePanel.musicOn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
             		setter.setMusic(!Set.isMusicOn);
             		if(!Set.isMusicOn){
						gamePanel.musicOn.setIcon(gamePanel.iconMusicOff);
					}else{
						gamePanel.musicOn.setIcon(gamePanel.iconMusicOn);
					}
					gamePanel.musicOn.repaint();
				}
	    		
	    	});
	    	gamePanel.soundOn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setter.setSound(!Set.isSoundOn);
					if(!Set.isSoundOn){
						gamePanel.soundOn.setIcon(gamePanel.iconSoundOff);
					}else{
						gamePanel.soundOn.setIcon(gamePanel.iconSoundOn);
					}
					gamePanel.soundOn.repaint();
				}
	    		
	    	});
	    	
	    	
	    	new Thread(game).start();
	    }
		
	    
		
		private void register(){
			currentLocation = 2;
		    registerPanel = new RegisterPanel();
		    registerPanel.idField.addKeyListener(this);
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
				
				currentLocation = 1;
				Mode.isPause = false;
				currentMode.isTerminated = true;
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
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				if(isOnGame){
					if(isSingleMode)
						currentMode.launch();
					else{
						if(!((DoubleMode)currentMode).turnToLeft){
							currentMode.launch();
						}
					}
						
				}
			}else if(e.getKeyCode()==KeyEvent.VK_A){
			    if(isOnGame && !isSingleMode){
			    	if(((DoubleMode)currentMode).turnToLeft){
			    		currentMode.launch();
			    	}
			    }
			}
			
			if(e.getKeyCode()== Set.shortcutPause){
				if(isOnGame){
					Mode.isPause = !Mode.isPause;
					if(Mode.isPause){
						gamePanel.pause.setIcon(gamePanel.iconUnpause);
					}else{
						gamePanel.pause.setIcon(gamePanel.iconPause);
					}
					gamePanel.pause.repaint();
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
		    if(e.getKeyCode() == KeyEvent.VK_ENTER){
		    	if(currentLocation == 0){
		    		new Thread(soundButton).start();
					enterChoices();
		    	}else if(currentLocation == 1){
		    		new Thread(soundButton).start();
					register();
		    	}else if(currentLocation == 2){
		    		String name = registerPanel.getText();
					try {
						player = PlayerInfo.CreatPlayer(name);
						registerPanel.frame.dispose();
						upgrade();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}else if(currentLocation == 3){
		    		upgrade.startSingleMode(player.bestGrade);
		    		upgrade.up.frame.dispose();
		    	}else if(currentLocation == 4){
		    		
		    	}
		    }
		}

		
		
}
