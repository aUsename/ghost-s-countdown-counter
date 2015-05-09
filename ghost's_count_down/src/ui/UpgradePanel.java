package ui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.*;
import javax.swing.event.MouseInputListener;


public class UpgradePanel extends JPanel{  
	  
	public JFrame     frame;  
	ImageIcon  icon;
	Image      image;
	CheckPoint point1;
	CheckPoint point2;
	CheckPoint point3;
	CheckPoint point4;
	CheckPoint point5;
	CheckPoint point6;
	CheckPoint point7;
	CheckPoint point8;
	CheckPoint point9;
	CheckPoint point10;
	CheckPoint[] points;
	int w,h;
	int topLevel;
	
    public UpgradePanel(int w,int h,int topLevel) {
        
    	super();
        this.topLevel = topLevel;
        this.w = w;
        this.h = h;
    	
    	icon = new ImageIcon("background"+File.separator+"upgrade.jpg");
        image = icon.getImage();
        
        
    	frame = new JFrame();
    	frame.setAlwaysOnTop(true); 
    	frame.setUndecorated(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    	frame.setBounds((size.width - w)/2, (size.height-h)/2, w,h);
    	frame.setLayout(null);
    	
        frame.getContentPane().add(this);
        this.setBounds(0, 0, w, h);
        this.setLayout(null);
        frame.setVisible(true);
        grabFocus();
        
        initial();
    }
    
    private  void initial(){
    	
    	// position
    	point1 = new CheckPoint(519, 589, 20,  1);
    	point2 = new CheckPoint(576, 565, 35,  2);
    	point3 = new CheckPoint(645, 511, 35,  3);
    	point4 = new CheckPoint(680, 417, 45,  4);
    	point5 = new CheckPoint(710, 270, 73,  5);
    	point6 = new CheckPoint(640, 144, 36,  6);
    	point7 = new CheckPoint(540, 104, 55,  7);
    	point8 = new CheckPoint(425, 88,  40,  8);
    	point9 = new CheckPoint(350, 70,  24,  9);
    	point10 = new CheckPoint(0,  0,   190, 10);
    
    	points = new CheckPoint[10];
    	points[0] = point1;
    	points[1] = point2;
    	points[2] = point3;
    	points[3] = point4;
    	points[4] = point5;
    	points[5] = point6;
    	points[6] = point7;
    	points[7] = point8;
    	points[8] = point9;
    	points[9] = point10;
    	
    	for(CheckPoint c : points){
    		 add(c);
    		 c.setBounds((int)(c.x-c.r),(int)(c.y-c.r),(int)(2*c.r),(int)(2*c.r)); 	
    	   
    	}
    }
    
    @Override
    public void paintComponent(Graphics gp) {
    	Graphics2D g = (Graphics2D) gp;
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(),getHeight(),0,0,
				image.getWidth(null),image.getHeight(null),this);       
		
    }
    
    public void startSingle(int level){;
    
    }
    
    
    class CheckPoint extends JPanel implements MouseListener{
    	double x;
    	double y;
    	double r;
    	int level;
    	boolean isReached;
    
    	
    	public CheckPoint(double x,double y,double r,int l){
    		
    		this.setOpaque(false);
    		level = l;
    		this.x = x*w/875;
    		this.y = y*h/618;
    		this.r = r*h/800;
    		this.isReached = ( level <= topLevel ) ;
    		this.addMouseListener(this);
    		this.setBounds((int)(x-r),(int)(y-r),(int)(2*r),(int)(2*r));
    	}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if(this.isReached){
				startSingle(level);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
            if(this.isReached)
            	setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
       
    		
    }
    
	public static void main(String[] args){
		
		UpgradePanel pan = new UpgradePanel(500,400,5);
	}
	
}
