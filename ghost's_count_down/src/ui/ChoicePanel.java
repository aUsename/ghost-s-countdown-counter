package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ChoicePanel extends JPanel implements Runnable {
	boolean isIn = false;
	public SingleButton single ;
	public DoubleButton doub ;
	public IntroductionButton intro;
	public ExitButton   exit ;
	public SetButton   set ;
	public int y=-520;
	public int x=-900;
	Thread trd = null;
	
	public ChoicePanel(int w, int h){		
		setLayout(null);
		setOpaque(false);
		
		single = new SingleButton();
		single.addMouseListener(single);
		add(single);
		single.setBounds(815, 10, 270, 160);
		
		doub = new DoubleButton();
		doub.addMouseListener(doub);
		add(doub);
		doub.setBounds(815, 190, 270, 160);
		
		intro = new IntroductionButton();
		intro.addMouseListener(intro);
		add(intro);
		intro.setBounds(815, 370, 270, 160);
		
		TransparentPanel tp= new TransparentPanel();
		add(tp);
		tp.setBounds(800, 0, 300, 700);
		
	}
	
	public void paint(Graphics g){
		Image background = null;
		String filepath = "background"+File.separator+"star1.png";
		background = new ImageIcon(filepath).getImage();
		g.drawImage(background,x,y,2000,1226,this);
		//g.drawImage(background,0,0,getWidth(),getHeight(),0,0,background.getWidth(null),background.getHeight( null),null);		
		super.paintChildren(g);
	}

	public void start(){
		trd = new Thread(this);
		trd.start();
	}
	
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<1000;i++){
		while(x<0&&y<0){
			try{
				repaint();
				Thread.sleep(80);
				x++;
				y++;
			}catch(Exception e){
				System.out.print("error");
			}
		}//x=0,y=0
		
		while(x>=-900&&x<=0){
			try{
				repaint();
				Thread.sleep(50);
				x--;
			}catch(Exception e){
				System.out.print("error");
			}
		}//x=-900,y=0
			
		while(y>=-520&&y<=0){
			try{
				repaint();
				Thread.sleep(50);
				y--;
			}catch(Exception e){
				System.out.print("error");
			}
		}//x=-900,y=-520
		
		while(x<0&&y<0){
			try{
				repaint();
				Thread.sleep(50);
				x++;
			}catch(Exception e){
				System.out.print("error");
			}
		}//x=0,y=-520
		
		while(y>=-520&&y<0){
			try{
				repaint();
				Thread.sleep(50);
				y++;
			}catch(Exception e){
				System.out.print("error");
			}
		}//x=0,y=0
		
		
		continue;
		}
	}
	
	

	
	
//     public SingleButton single ;
//     public DoubleButton doub ;
//     public ExitButton   exit ;
//     public SetButton   set ;
//    
//     int a,b;
//     
//     public ChoicePanel(int w,int h){
//    	 
//         a = w/5;
//         b = h/5;
//    	 setOpaque(false);
//    	 setLayout(null);
//    	 single = new SingleButton(a,b);
//    	 doub = new DoubleButton(a,b) ;
//    	 exit = new ExitButton(a,b);
//    	 set = new SetButton(a,b);
//    	 
//    	 add(single);
//    	 single.setBounds(0,0,a,b);
//    	 add(doub);
//    	 doub.setBounds(0,b,a,b);
//    	 add(exit);
//    	 exit.setBounds(0,2*b,a,b);
//    	 add(set);
//    	 set.setBounds(0,3*b,a,b);
//     }
//     
//     
//     public void paintComponent(Graphics g){
//    	 g.setColor(Color.white);
//    	 g.fillRect(0, 0, getWidth(), getHeight());
//     }
//	
}
