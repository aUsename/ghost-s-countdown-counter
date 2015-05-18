package game;



import service.Set;
import ui.ClockPanel;
import ui.Frame;

public abstract class Mode implements Runnable {
	
	
	boolean isOnGame = true;
    static boolean isPause  = false;
    public static boolean isAlive  = true;
    Launcher launcher;
 
    
    
    ClockPanel      clockPanel;
    MinutePointer   minute ;
    SecondPointer   second ;
    HourPointer     hour;
    DeadArea        deadArea;
       
     
    Ball ball  ;
    public int  number;
    Clock clock  ;
    Set setter;
	public boolean isTerminated = false;
    
    
    
    public Mode(Set s){
      
    	ball = new Ball(Frame.width/2,Frame.height/8,Frame.height/20);
    	clock = new Clock(ball,number);
    	setter = s;
    	clockPanel = new ClockPanel(clock);
    	minute = clock.minute;
    	second = clock.second;
    	hour = clock.hour;
        deadArea = clock.deadArea;
    	number = 10; 
    	isAlive  = true;
        
    }
    
    
    abstract public void go();
    

    
    abstract public void launch();

   
    public boolean isOverlap(){

    	if(second.isOverlap(clockPanel.getHeight()/2,90)) return true;
		if(minute.isOverlap(clockPanel.getHeight()/2,90)) return true;
		if(hour.  isOverlap(clockPanel.getHeight()/2,90)) return true;
    	return false;
    }
    
}
