package ui;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
    
	public ClockPanel clockPanel;
    public TimePanel  timePanel;
    
    public GamePanel(){
    	setLayout(null);
    	
    }
    
    public void addComponent(){
    	add(clockPanel);
    	add(timePanel);
    	
    	timePanel.setBounds(0,0,getWidth(),getHeight()/6);
    	clockPanel.setBounds(getWidth()/8,getHeight()/8,getWidth()*6/8,getHeight()*7/8);
    	repaint();
    	
    }
    
    public void paint(){
    	
    	clockPanel.repaint();
    	timePanel.repaint();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
