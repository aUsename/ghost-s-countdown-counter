package game;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import service.Set;
import ui.ChoicePanel;
import ui.EnterPanel;
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
	    	Sign s = new Sign(); 
	    	new SplashWindow(s);
	    	f.addKeyListener(this);	
	        
	    	 while(true){
	        	if(s.sign){
	        		f.setVisible(true);
	        		break;
	        	}
	        }	   
	    	 
	        EnterPanel ep = new EnterPanel(frame.getWidth(),frame.getHeight());
	        
	        /*ep.eb.addMouseListener(new MouseListener(){
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		// TODO Auto-generated method stub
                    enterChoices();    System.out.print("fd");  		
	        	}

	        	@Override
	        	public void mousePressed(MouseEvent e) {
	        		// TODO Auto-generated method stub
	        		ep.eb.isPressed = true;
	        		ep.eb.repaint();
	        	}

	        	@Override
	        	public void mouseReleased(MouseEvent e) {
	        		// TODO Auto-generated method stub
	        		ep.eb.isPressed = false;
	        		ep.eb.repaint();
	        		
	        	}

	        	@Override
	        	public void mouseEntered(MouseEvent e) {
	        		// TODO Auto-generated method stub
	        		ep.eb.isIn  = true;
	        		ep.eb.repaint();
	        		
	        	}

	
	        	@Override
	        	public void mouseExited(MouseEvent e) {
	        		// TODO Auto-generated method stub
	        		ep.eb.isIn = false;
	        		ep.eb.repaint();
	        	}
	        });
	          */
	        
	        
	        ep.eb.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					enterChoices();
					
				}
	        	
	        });
	        
	        setCurrentPanel(ep);
	       	           
	    }
	    
	    
	    
	    public void enterChoices(){
	    	choice = new ChoicePanel(f.getWidth(),f.getHeight());
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
	        	/*	
	        	 * // a  registerPanel
	        		register = new RegisterPanel();
	    	    	currentPanel.add(register);
	    	    	
	    	        register.confirm.addActionListener(new ActionListener(){

						@Override
						//register.check(image, observer)
				        	public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							String  s = null;
							
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
                  */
	        	
	        	startSingleMode(null);
	        	}
	        	
	        		
	        });
	        
	        
	        choice.doub.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		startDoubleMode();
	        	}
	        });
	        
	       /* 
	        choice.set.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		currentPanel.add(new SetPanel());
	        		
	        	}
	        });*/
	        
	    }
	    

	        
	   
	    public  void  startSingleMode(PlayerInfo player){
	    	
	    	
	    
	    	
	    	isOnGame = true;
	    	gamePanel = new GamePanel();
	    	setCurrentPanel(gamePanel);
	    	Mode game = new SingleMode(setter,player);
	    	
	    	gamePanel.clockPanel = game.clockPanel;
	    	gamePanel.timePanel = game.timePanel;
	    	gamePanel.addComponent();
	    	
	    	currentMode = game;
	    	isSingleMode = true;
	    	

	    	System.out.println("it is ok before to play");
	    	
	    	//game.go();
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
	    	if(currentPanel!=null)
	    		frame.remove(currentPanel);
		    currentPanel = panel; 
		    frame.add(currentPanel);
		    currentPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		}
	  
	    
	    
	    
	    
	    
	    
	    
	    public static void main(String[] args) {
		// TODO Auto-generated method stub
		    
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
