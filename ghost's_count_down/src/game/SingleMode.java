package game;


public class SingleMode extends Mode{
	
    PlayerInfo player;
    int currentLevel;
    public static double restTime; 
    
    // if limit the time between two launch
    boolean launchable = true;
    long    timeOfLaunch;
    long    timeOfPause;
    
    // if trip launch in 2s,delete a part of the dead area as a prize
    long    firstTimeLatest  = -1;
    long    secondTimeLatest = -1;
    long    inteval = 1500;
    
    public static boolean toDraw;
    
    
	public SingleMode(Launcher launch,int level) {
		super(launch.setter);
		// TODO Auto-generated constructor stub
		restTime = 5000.0;
		player = launch.player;
		launcher = launch;
		currentLevel = level;
		timeOfPause = 500;
		this.number = ((int)(level)) + 6;
		toDraw = false;
		isPause = false;
	}

	public void go() {
    		
		while(true){
    			if(!isPause){
    				long a = System.currentTimeMillis();
    				minute.rotate();
    				hour.rotate();
    				second.rotate();
    			    
    				if(!launchable){
    					if(System.currentTimeMillis()-this.timeOfLaunch > timeOfPause){
    						launchable = true;
    					}
    				}
    				
    			    try {
						Thread.sleep( 15 - (Integer)(currentLevel/2+5) );
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
    			    long b = System.currentTimeMillis();
    			    restTime -= (b-a);
    			   
    			    if(restTime< 0){	
    			    	isAlive = false;
    			    }
    			    if(number==0){
    			    	isAlive = true;
    			        break;
    			    }
    			    if (!isAlive || isTerminated ){
    			    	break;
    			    }
    			    if(deadArea.start!=null){
    			    	deadArea.start+=0.5;	
    			    }
    			    
    			}
    
    			clockPanel.pointers.repaint();
    		}
	}

	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		go();
		
		if(isAlive && !isTerminated){
			if(currentLevel==10) new Thread(launcher.soundWin ).start();
			else                 new Thread(launcher.soundBeat).start();
			
			toDraw = true;
			clockPanel.pointers.repaint();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
			toDraw = false;
			clockPanel.pointers.repaint();
			
			if(currentLevel==player.bestGrade){
				player.bestGrade++;
				player.storage();
			    
			}
		     
		}else if(!isAlive){	
			new Thread(launcher.soundFail).start();
			toDraw = true;
			clockPanel.pointers.repaint();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
			toDraw = false;
			clockPanel.pointers.repaint();
		}

		if(launcher.currentMode.isOnGame){
			launcher.upgrade();
		}
	}
	
	
    public void launch(){
		
		if(this.launchable  && !isPause){
			new Thread(launcher.soundLaunch).start();;
			
			if(isOverlap() || ! deadArea.updateShadow())				isAlive = false;
			number --;
			restTime +=( currentLevel+6+number)* 500 ;
			
			launchable = false;
		    timeOfLaunch = System.currentTimeMillis();

	        trim();	    
		}
		
		
	}

    public void trim(){
    	if(isTripHit()){
	    	deadArea.trim();
	    	this.firstTimeLatest  = -1;
	    	this.secondTimeLatest = -1;
	    }else{
	    	
	    	if (this.firstTimeLatest == -1){
	    		this.firstTimeLatest = System.currentTimeMillis();
	    	}
	    	else if (this.secondTimeLatest == -1){
	    		this.secondTimeLatest = System.currentTimeMillis();
	    	}
	    	else{
	    	    this.firstTimeLatest  = this.secondTimeLatest;
	    	    this.secondTimeLatest = System.currentTimeMillis(); 
	    	}
	    }
    }
    
    public boolean isTripHit(){
    	if(this.firstTimeLatest==-1  ||  this.secondTimeLatest == -1){
    		return false;
    	}
    	else if(System.currentTimeMillis() - this.firstTimeLatest < inteval){
    		return true;
    	}
    	else 
    		return false;
    }
    
   
	
}
