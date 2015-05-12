package service;

import java.awt.event.KeyEvent;

public class Set {
    
	// sound effect
    public static boolean isSoundOn = true;
	public void setSound(boolean b){
		isSoundOn = b;
	}
	
	
	
	//music in background
    public static boolean isMusicOn = false;
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
    public static  int shortcutUp = KeyEvent.VK_UP;
    public void setShortcutUp(int i){
    	if(i>='a'){
    		shortcutBack = i-'a'+'A';
    	}else{
    		shortcutBack = i;
    	}
    }
    
    
    //shortcut key to put down
    public static  int shortcutDown = KeyEvent.VK_DOWN;
    public void setShortcutDown(int i){
    	if(i>='a'){
    		shortcutDown= i-'a'+'A';
    	}else{
    		shortcutDown = i;
    	}

    }
    
    
    // shortcut key to pause or revert
    public static  int shortcutPause = KeyEvent.VK_SPACE;
    public void setShortcutPause(int i){
    	if(i>='a'){
    		shortcutPause = i-'a'+'A';
    	}else{
    		shortcutPause = i;
    	}
    }
    
    
    // shortcut key to get back to the choice panel
    public static  int shortcutBack = KeyEvent.VK_BACK_SPACE;
    public  void setShortcutBack(int i){
    	if(i>='a'){
    		shortcutBack = i-'a'+'A';
    	}else{
    		shortcutBack = i;
    	}
    }
    
    
    //shortcut of launch
    public static  int shortcutLaunch = KeyEvent.VK_ENTER;
    public void setShortcutLaunch(int i){
    	if(i>='a'){
    		shortcutLaunch = i-'a'+'A';
    	}else{
    		shortcutLaunch = i;
    	}
    }
    
    
    public void reset(){
    	volumeOfMusic = 10;
    	volumeOfSound = 10;
    	isMusicOn = true;
    	isSoundOn = true;
    	
    	shortcutLaunch = KeyEvent.VK_ENTER;
    	shortcutBack = KeyEvent.VK_BACK_SPACE;
    	shortcutPause = KeyEvent.VK_SPACE;
    	shortcutDown = KeyEvent.VK_DOWN;
    	shortcutUp = KeyEvent.VK_UP;
    }
}
