package ui;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 5621485351345206242L;
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
    	clockPanel.pointers.setBounds(0,0,clockPanel.getWidth(),clockPanel.getHeight());
    	repaint();
    	
    }
    
    public void paint(){
    	
    	clockPanel.repaint();
    	timePanel.repaint();
    }
    

}
