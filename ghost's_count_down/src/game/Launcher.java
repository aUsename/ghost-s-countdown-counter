package game;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import service.Set;
import ui.ChoicePanel;
import ui.Frame;
import ui.GamePanel;
import ui.RegisterPanel;
import ui.SetPanel;
import ui.SplashWindow;


public class Launcher implements KeyListener{
	
        boolean isOnGame = false;
	     
	    Mode  currentMode; 
	    boolean isSingleMode = true; 
	    RegisterPanel register;
	    
	    Frame f = new Frame();
	    
	  //  TimePanel timePanel;
	    
	    Container frame = f.getContentPane();
	    ChoicePanel choice;
	    GamePanel gamePanel; 
	    JPanel currentPanel = null;
	    
	    Set setter = new Set();
	    
	    
	    
	  
	    public Launcher(){
	        f.addKeyListener(this);	
	        choice = new ChoicePanel();
	    	setCurrentPanel(choice);
	        
	        choice.exit.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
	        	
	        });
	        
	        choice.single.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		// a  registerPanel
	        		register = new RegisterPanel();
	    	    	currentPanel.add(register);
	    	    	
	    	        register.confirm.addActionListener(new ActionListener(){

						@Override
						//register.check(image, observer)
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							String  s = register.getText();
							
							try {
								PlayerInfo  player = PlayerInfo.CreatPlayer(s);
								currentPanel.remove(register);
								startSingleMode(player);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
						}
	    	        	
	    	        });
	    	        

	        	}
	        });
	        
	        
	        choice.doub.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		startDoubleMode();
	        	}
	        });
	        
	        
	        choice.set.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		currentPanel.add(new SetPanel());
	        		
	        	}
	        });
	    }
	    
	    
	    

	    
	    
	    
	    
	    
	   
	    public  void  startSingleMode(PlayerInfo player){
	    	
	    	
	    
	    	
	    	isOnGame = true;
	    	gamePanel = new GamePanel();
	    	setCurrentPanel(gamePanel);
	    	Mode game = new SingleMode(setter,player);
	    	gamePanel.clockPanel = game.clockPanel;
	    	gamePanel.timePanel = game.timePanel;
	    	currentMode = game;
	    	isSingleMode = true;
	    	

	    	
	    	
	    	game.go();
	    }
	    
	    
	    




		public void startDoubleMode(){
	        
			gamePanel = new GamePanel();
	    	isOnGame = true;
	    	setCurrentPanel(gamePanel);
	    	Mode game = new DoubleMode(setter);
	    	game.clockPanel = game.clockPanel;
	    	gamePanel.timePanel = game.timePanel;	
	    	currentMode = game;
	    	isSingleMode = false;
	    	game.go();
	    }
	    
		
		
		
	    
		private void setCurrentPanel(JPanel panel) {
			// TODO Auto-generated method stub
	    	
	    	frame.remove(currentPanel);
		    currentPanel = panel; 
		    frame.add(currentPanel);
		}
	  
	    
	    
	    
	    
	    
	    
	    
	    public static void main(String[] args) {
		// TODO Auto-generated method stub
		    new SplashWindow();
		    new Launcher();
		    
	    }

	    
	    
	    public void comeBack(){
	    	if(isOnGame){
	    		currentMode.isAlive = false;
	    		setCurrentPanel(choice);
	    	}
	    }


	    
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}


		


		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode() == Set.shortcutup){
				setter.setVolumeOfMusic(1);
			}
			
            if(e.getKeyCode() == Set.shortcutdown){
            	setter.setVolumeOfMusic(-1);
			}
            
            if(e.getKeyCode() == Set.shortcutPause){
				currentMode.isPause =true;
			}
            
            if(e.getKeyCode() == Set.shortcutlaunch){
				
			}
            
            if(e.getKeyCode() == Set.shortcutback){
				
			}
            
            if(e.getKeyCode() == Set.shortcutback){
            	comeBack();
            }
              
            
		}

}
