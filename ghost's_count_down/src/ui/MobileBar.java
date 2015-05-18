package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class MobileBar extends JPanel implements MouseInputListener{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 428847145584787265L;
	int  location=0;
	int  size;
	public MobileBar(int w,int h) {
		// TODO Auto-generated constructor stub
		setSize(w,h);
		size = h ;
		addMouseListener(this);
	}
    
    public void setLocation(int s){
    	location  =s;
    	if(size + location > getWidth())
    		location = getWidth() - size;
    }
	
    public int getNumber(){
        return location/(getWidth()-location);	
    }
    
	@Override
	public void paintComponent(Graphics g){
		
		g.setColor(Color.yellow);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.fillRect(location, 0, size, size);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		setLocation(e.getX());
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)); 
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize(400,400);
		f.setVisible(true);
		f.setLayout(null);
		MobileBar bar = new MobileBar(300,50);
		f.add(bar);
		bar.setBounds(0,100,300,50);
	}
}
