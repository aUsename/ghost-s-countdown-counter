
package game;

import service.Set;


public class DoubleMode extends Mode{
	
	public static boolean toDraw;
	public static boolean turnToLeft = true;
	public static boolean FormerWin    = false;
	public static boolean LaterWin     = false;
	
	public DoubleMode(Set s,Launcher l){
		super(s);
		launcher = l;
		turnToLeft = true;
		FormerWin    = false;
		LaterWin     = false;
		toDraw = false;
		isPause = false;
	}

	public void go() {
		// TODO Auto-generated method stub
		while(true){
			if(!isPause){
			
				minute.rotate();
				hour.rotate();
				second.rotate();
			    
				
			    try {
					Thread.sleep(8);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			    
			    if(deadArea.start!=null){
			    	deadArea.start+=0.5;	
			    }
			    
			    if(DoubleMode.FormerWin || DoubleMode.LaterWin){
			    	break;
			    }
			}

			clockPanel.pointers.repaint();
		}
	}

	
 	@Override
   	public void run() {
		// TODO Auto-generated method stub
		go();
		toDraw = true;
		clockPanel.pointers.repaint();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		toDraw = false;
		clockPanel.pointers.repaint();
		launcher.comeback();
	}

 	@Override
	public void launch(){
	    
 		if(!isPause){
 			new Thread(launcher.soundLaunch).start();
 			if(  isOverlap() || ! deadArea.updateShadowDouble(this.turnToLeft) )	{
		    if(this.turnToLeft){
		    	DoubleMode.LaterWin = true ;
		    }else{
		    	DoubleMode.FormerWin  = true ;
		    }
		}
		number --;
		DoubleMode.turnToLeft = ! DoubleMode.turnToLeft;
		launcher.gamePanel.repaint();
 		}
		
	}

	@Override
	public boolean isOverlap(){
		if(this.turnToLeft) {
			if(second.isOverlap(clockPanel.getHeight()/2,180)) return true;
			if(minute.isOverlap(clockPanel.getHeight()/2,180)) return true;
			if(hour.  isOverlap(clockPanel.getHeight()/2,180)) return true;
		}else{
			if(second.isOverlap(clockPanel.getHeight()/2,0)) return true;
			if(minute.isOverlap(clockPanel.getHeight()/2,0)) return true;
			if(hour.  isOverlap(clockPanel.getHeight()/2,0)) return true;
		}
		return false;
	}
}
