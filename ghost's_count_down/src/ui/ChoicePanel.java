package ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ChoicePanel extends JPanel {

	
	
     public SingleButton single ;
     public DoubleButton doub ;
     public ExitButton   exit ;
     public SetButton   set ;
    
     int a,b;
     
     public ChoicePanel(int w,int h){
    	 
        /* a = w/5;
         b = h/5;
    	 setOpaque(false);
    	 setLayout(null);
    	 single = new SingleButton(a,b);
    	 doub = new DoubleButton(a,b) ;
    	 exit = new ExitButton(a,b);
    	 set = new SetButton(a,b);
    	 
    	 add(single);
    	 single.setBounds(0,0,a,b);
    	 add(doub);
    	 doub.setBounds(0,b,a,b);
    	 add(exit);
    	 exit.setBounds(0,2*b,a,b);
    	 add(set);
    	 set.setBounds(0,3*b,a,b);
     }
     public void paintComponent(Graphics g){
    	 g.setColor(Color.white);
    	 g.fillRect(0, 0, getWidth(), getHeight());
     }*/
     }
	
}
