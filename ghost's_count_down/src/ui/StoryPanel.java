package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class StoryPanel extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2194674381748018766L;
	int y=0;
	InvisibleButton button = new InvisibleButton(100,100);
    Runnable  runnable;
	public StoryPanel(){
		runnable = this;
		setOpaque(false);
		setSize(700,700);
		setLayout(null);
		
		add(button);
		button.setBounds(300,250,100,100);
		
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(button.opaque){
					y = -300;
				    button.opaque = false;
				    button.repaint();
				    new Thread(runnable).start();
				}
				
			}
			
		});
	}
	
	@Override
	public void paintComponent(Graphics g){
		if(!button.opaque){
				Image background ;
		String filepath = "background/plotW.png";
 		background = new ImageIcon(filepath).getImage();
 		g.drawImage(background,0,0,getWidth(),getHeight(),
 		 0,background.getHeight( null)*(y-1)/700,background.getWidth(null),background.getHeight( null)*(y+400)/700,null);		

		}
		}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(y<=700){
			try{
				Thread.sleep(80);
				y++;
				repaint();
			}catch(Exception e){
				System.out.print("error");
			}

		}
		button.opaque = true;
		button.repaint();
		
	}
}
