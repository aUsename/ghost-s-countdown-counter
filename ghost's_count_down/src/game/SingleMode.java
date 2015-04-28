package game;

import service.Set;


public class SingleMode extends Mode{
	
    PlayerInfo player;
    int currentLevel;
    
    
	public SingleMode(Set s,PlayerInfo er) {
		super(s);
		// TODO Auto-generated constructor stub
		restTime = 5.0;
		player = er;
	}

	public void go() {
		// TODO Auto-generated method stub
		
		
		if(isOnGame){
    		while(isAlive){
    			
    			if(!isPause){
    				long a = System.currentTimeMillis();
    				minute.rotate();
    				hour.rotate();
    				second.rotate();
    				long b = System.currentTimeMillis();
    			    restTime -= (b-a);
    			    if(restTime<0){	
    				   isAlive = false;
    				   break;
    			    }	
    			}
    			
    			clockPanel.repaint();
    			
    		}
    	}
	}
	

}
