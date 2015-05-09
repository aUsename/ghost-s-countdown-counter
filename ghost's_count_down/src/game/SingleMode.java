package game;


public class SingleMode extends Mode{
	
    PlayerInfo player;
    int currentLevel;
    Launcher launcher;
    
	public SingleMode(Launcher launch,int level) {
		super(launch.setter);
		// TODO Auto-generated constructor stub
		restTime = 5000.0;
		player = launch.player;
		launcher = launch;
		currentLevel = level;
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
						Thread.sleep(8);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
    			    long b = System.currentTimeMillis();
    			    restTime -= (b-a);
    			    if(restTime<= 0){	
    			    	isAlive = false;
    			    }
    			    if(number==0){
    			    	isAlive = true;
    			        break;
    			    }
    			    if (!isAlive ){
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
		
		if(isAlive){
			//do  update the bestGrade 
			if(currentLevel==player.bestGrade){
				player.bestGrade++;
				player.storage();
			}
		      
		}else{
			
		}
		if(launcher.currentMode.isOnGame){
			launcher.upgrade();
		}
	}
	
	
}
