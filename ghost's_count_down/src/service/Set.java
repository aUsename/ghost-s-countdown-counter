package service;

import java.awt.event.KeyEvent;

public class Set {
    
	// sound effect
    public static boolean isSoundOn = true;
	public void setSound(boolean b){
		isSoundOn = b;
	}
	
	
	
	//music in background
    public static boolean isMusicOn = true;
    public void setMusic(boolean b){
    	isMusicOn = b;
    }
    
    
    
    public static int volumeOfSound = 10;
    public void setVolumeOfSound(int v){
    	volumeOfSound += v;
    }
    
    
    public static int volumeOfMusic = 10;
    public void setVolumeOfMusic(int v){
    	volumeOfMusic += v;
    }
    
    //shortcut key to put up
    public static  int shortcutup = KeyEvent.VK_UP;
    public void setShortcut(int i){
    	shortcutup = i;
    }
    
    
    //shortcut key to put down
    public static  int shortcutdown = KeyEvent.VK_DOWN;
    public void setShortcutdown(int i){
    	shortcutdown = i;
    }
    
    
    // shortcut key to pause or revert
    public static  int shortcutPause = KeyEvent.VK_SPACE;
    public void setShortcutPause(int i){
    	shortcutPause = i;
    }
    
    
    // shortcut key to get back to the choice panel
    public static  int shortcutback = KeyEvent.VK_BACK_SPACE;
    public  void setShortcutback(int i){
    	shortcutback = i;
    }
    
    
    //shortcut of launch
    public static  int shortcutlaunch = KeyEvent.VK_ENTER;
    public void setShortcutlaunch(int i){
    	shortcutlaunch = i;
    }
    
    
    
    
}
