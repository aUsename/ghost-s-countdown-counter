package game;

import ui.GamePanel;
import ui.UpgradePanel;

public class Upgrade implements Runnable {
    int w, h, level;
    Launcher  launcher;
    UpgradePanel up;
    
	public Upgrade(Launcher launcher) {
		// TODO Auto-generated constructor stub
	    this.w = launcher.frame.getWidth()*3/4;
	    this.h = launcher.frame.getHeight()*3/4;
	    this.level = launcher.player.bestGrade;
	    this.launcher = launcher;
	    
	}

	public void run(){

		 up = new UpgradePanel(w,h,level){
		
		public void startSingle(int level){
		    startSingleMode(level);
		    up.frame.dispose();
		  }
	   };
	    
	}
	
	
	 public  void  startSingleMode(int level){
	    	
	    	launcher.isOnGame = true;
		    launcher.gamePanel = new GamePanel();
		    launcher.setCurrentPanel(launcher.gamePanel);    	
	    	Mode game = new SingleMode(launcher,level);    	
	    	launcher.gamePanel.clockPanel = game.clockPanel;
	    	launcher.gamePanel.timePanel = game.timePanel;
	    	launcher.gamePanel.addComponent();   	
	    	launcher.currentMode = game;
	    	launcher.isSingleMode = true;
	    	new Thread(game).start();
	    	//game.go();
	    }
	
}
