package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import service.Set;
import ui.GamePanel;
import ui.UpgradePanel;

public class Upgrade implements Runnable {
    int w, h, level;
    Launcher  launcher;
    UpgradePanel up;
    
	public Upgrade(Launcher launcher) {
		// TODO Auto-generated constructor stub
		launcher.currentLocation = 3;
	    this.w        = launcher.frame.getWidth()*3/4;
	    this.h        = launcher.frame.getHeight()*3/4;
	    this.level    = launcher.player.bestGrade;
	    this.launcher = launcher;
	    
	}

	public void run(){

		 up = new UpgradePanel(w,h,level){
		 
		/**
			 * 
			 */
			private static final long serialVersionUID = 1809406938357946096L;

		public void startSingle(int level){
		    startSingleMode(level);
		    up.frame.dispose();
		  }
	   };
	     up.addKeyListener(launcher);
	}
	
	
	 public  void  startSingleMode(int level){
	    
		    launcher.currentLocation = 4;
	    	launcher.isOnGame = true;
		    launcher.gamePanel = new GamePanel();
		    launcher.setCurrentPanel(launcher.gamePanel);    	
	    	Mode game = new SingleMode(launcher,level);    	
	    	launcher.gamePanel.clockPanel = game.clockPanel;
	    	launcher.gamePanel.addComponent();   	
	    	launcher.gamePanel.pause.addKeyListener(launcher);
	    	launcher.gamePanel.back.addKeyListener(launcher);
	    	launcher.gamePanel.musicOn.addKeyListener(launcher);
	    	
	    	launcher.gamePanel.pause.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					SingleMode.isPause = !SingleMode.isPause;
					if(SingleMode.isPause){
						launcher.gamePanel.pause.setIcon(launcher.gamePanel.iconUnpause);
					}else{
						launcher.gamePanel.pause.setIcon(launcher.gamePanel.iconPause);
					}
					launcher.gamePanel.pause.repaint();
				}
	    		
	    	});
	    	launcher.gamePanel.back.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					launcher.comeback();
				}
	    		
	    	});
	    	launcher.gamePanel.musicOn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
             		launcher.setter.setMusic(!Set.isMusicOn);
             		if(!Set.isMusicOn){
						launcher.gamePanel.musicOn.setIcon(launcher.gamePanel.iconMusicOff);
					}else{
						launcher.gamePanel.musicOn.setIcon(launcher.gamePanel.iconMusicOn);
					}
					launcher.gamePanel.musicOn.repaint();
				}
	    		
	    	});
	    	launcher.gamePanel.soundOn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					launcher.setter.setSound(!Set.isSoundOn);
					if(!Set.isSoundOn){
						launcher.gamePanel.soundOn.setIcon(launcher.gamePanel.iconSoundOff);
					}else{
						launcher.gamePanel.soundOn.setIcon(launcher.gamePanel.iconSoundOn);
					}
					launcher.gamePanel.soundOn.repaint();
				}
	    		
	    	});
	    	launcher.currentMode = game;
	    	Launcher.isSingleMode = true;
	    	new Thread(game).start();
	    	//game.go();
	    }
	
}
