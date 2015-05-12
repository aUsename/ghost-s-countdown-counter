
package game;

import service.Set;
import ui.ClockPanel;


public class DoubleMode extends Mode{
	
	boolean turnToFormer = true;
	boolean FormerWin    = false;
	boolean LaterWin     = false;
	
	public DoubleMode(Set s,Launcher l){
		super(s);
		restTime = -1; 
		launcher = l;
		// TODO Auto-generated constructor stub
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
			    
			    if(this.FormerWin || this.LaterWin){
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
		launcher.comeback();
	}

	public void launch(){
	    
		if(isOverlap() || ! deadArea.updateShadow())	{
		    if(this.turnToFormer){
		    	this.FormerWin = true ;
		    }else{
		    	this.LaterWin  = true ;
		    }
		}
		number --;
		this.turnToFormer = ! this.turnToFormer;
	}

}
