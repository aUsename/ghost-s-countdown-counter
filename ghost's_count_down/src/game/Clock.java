package game;

import java.awt.Graphics;

public class Clock {
	    
	MinutePointer minute = new MinutePointer();
	SecondPointer second = new SecondPointer();
	HourPointer hour = new HourPointer();
	
	
	public Clock(){
	}


	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		minute.draw(g);
		hour.draw(g);
		second.draw(g);
	}
}
