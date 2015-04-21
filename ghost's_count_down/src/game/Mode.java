package game;

import service.Set;
import ui.ClockPanel;

public class Mode {
	boolean isOnGame = false;
    boolean isPause = false;
    boolean isAlive = false;
    
    ClockPanel clockPanel;
    
    Clock   clock = new Clock();
    
    MinutePointer minute ;
    SecondPointer second ;
    HourPointer hour;
    
    
    Set setter;
    
    
    
    public Mode(Set s){
      
      setter = s;
      clockPanel = new ClockPanel(clock);
      minute = clock.minute;
      second = clock.second;
      hour = clock.hour;
    }
    
    
    
    
    
    public void go(){
    	
    }
}
