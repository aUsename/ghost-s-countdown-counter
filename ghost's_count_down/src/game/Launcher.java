package game;

import java.awt.Container;

import javax.swing.JPanel;

import service.Set;
import ui.ChoicePanel;
import ui.Frame;
import ui.ClockPanel;
import ui.GamePanel;

public class Launcher {
	
        boolean isOnGame = false;
	    boolean isSingleMode = true;  
	    Mode  currentMode; 
	    
	    Frame f = new Frame();
	    Container frame = f.getContentPane();
	    ChoicePanel choice;
	    GamePanel gamePanel; 
	    JPanel currentPanel;
	    
	    
	    Set setter = new Set();
	    
	    
	    
	    
	    public Launcher(){
	    	
	    	choice = new ChoicePanel();
	    	currentPanel = choice;
	    	gamePanel = new GamePanel();
	    }
	    
	    
	    
	    
	    public void startSingleMode(){
	    	
	    	
	    	isOnGame = true;
	    	frame.remove(currentPanel);
	    	currentPanel = gamePanel; 
	    	frame.add(currentPanel);
	    	Mode game = new SingleMode(setter);
	    	gamePanel.clockPanel = game.clockPanel;
	    	currentMode = game;
	    	game.go();
	    }
	    
	    
	    public void startDoubleMode(){
	        
	    	
	    	isOnGame = true;
	    	frame.remove(currentPanel);
	    	currentPanel = gamePanel;
	    	frame.add(currentPanel);
	    	Mode game = new DoubleMode(setter);
	    	game.clockPanel = game.clockPanel;
	    	currentMode = game;
	    	game.go();
	    }
	    
	    
	  
	    public static void main(String[] args) {
		// TODO Auto-generated method stub
		  
	    }

}
