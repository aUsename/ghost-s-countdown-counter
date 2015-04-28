package ui;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
    
	public ClockPanel clockPanel;
    public TimePanel  timePanel;
    
    public GamePanel(){
    	setLayout(null);
    	add(clockPanel);
    	add(timePanel);
    	
    	clockPanel.setBounds(0,0,getWidth(),getHeight()/6);
    	timePanel.setBounds(0,getHeight()/6,getWidth(),getHeight()*5/6);
    }
    
    public void paint(){
    	
    	clockPanel.repaint();
    	timePanel.repaint();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
