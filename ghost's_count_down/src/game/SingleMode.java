package game;

import service.Set;
import ui.ClockPanel;


public class SingleMode extends Mode{
	
    
    
	public SingleMode(Set s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	public void go() {
		// TODO Auto-generated method stub
		if(isOnGame){
    		while(!isAlive){
    			if(!isPause){
    				minute.rotate();
    				hour.rotate();
    				second.rotate();
    				
    			}
    		}
    	}
	}

}
