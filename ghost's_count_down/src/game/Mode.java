package game;



import service.Set;
import ui.ClockPanel;
import ui.Frame;
import ui.TimePanel;

public abstract class Mode implements Runnable {
	
	public static double restTime; 
	boolean isOnGame = true;
    static boolean isPause  = false;
    boolean isAlive  = true;
    Launcher launcher;
 
    
    
    ClockPanel      clockPanel;
    TimePanel       timePanel;
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
    	timePanel = new TimePanel();
    	number = 10; 
    	
    }
    
    
    abstract public void go();
    

    
    abstract public void launch();

   
    public boolean isOverlap(){

    	if(second.isOverlap(clockPanel.getHeight()/2)) return true;
		if(minute.isOverlap(clockPanel.getHeight()/2)) return true;
		if(hour.  isOverlap(clockPanel.getHeight()/2)) return true;
    	return false;
    }
    
}
