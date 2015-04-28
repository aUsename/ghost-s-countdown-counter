package game;

import service.Set;
import ui.ClockPanel;
import ui.TimePanel;

public class Mode {
	boolean isOnGame = true;
    boolean isPause = false;
    boolean isAlive = true;
    
    
    
    ClockPanel clockPanel;
    TimePanel  timePanel;
    public double restTime; 
    
    
    
    MinutePointer minute ;
    SecondPointer second ;
    HourPointer hour;
    
    Ball ball  ;
    int  number;
    
    Clock   clock = new Clock(ball,number);
    
    Set setter;
    
    
    
    public Mode(Set s){
      
      setter = s;
      clockPanel = new ClockPanel(clock);
      minute = clock.minute;
      second = clock.second;
      hour = clock.hour;
      timePanel = new TimePanel();
      
      
      ball = new Ball(clockPanel.getWidth()/2,clockPanel.getHeight()*9/10,clockPanel.getHeight()/20);
      number = 4; 
      
    }
    
    
    
    
    
    public void go(){
    	
    }
    
    
    
    
    public void launch(){
		clock.updateShadow();
		number --;
		restTime+=5;
	}
	
    
    
    
    
}
