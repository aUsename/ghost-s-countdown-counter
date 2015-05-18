package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TransparentPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1065161380022834033L;



	public TransparentPanel(){
		setLayout(null);
		setOpaque(false);

	}
	

	
	public void paint(Graphics g){
		Image background = null;
		String filepath = "background"+File.separator+"transparentBoard.png";
		background = new ImageIcon(filepath).getImage();
		g.drawImage(background,0,0,300,700,this);
		//g.drawImage(background,0,0,getWidth(),getHeight(),0,0,background.getWidth(null),background.getHeight( null),null);		
		super.paintChildren(g);
	}
	

}
