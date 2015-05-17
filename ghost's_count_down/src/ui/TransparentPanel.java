package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TransparentPanel extends JPanel implements MouseListener {
//	boolean isIn = false;
//	public SingleButton single ;
//	public DoubleButton doub ;
//	public IntroductionButton intro;
//	public ExitButton   exit ;
//	public SetButton   set ;
	
	public TransparentPanel(){
		setLayout(null);
		setOpaque(false);
		
//		single = new SingleButton();
//		single.addMouseListener(single);
//		add(single);
//		single.setBounds(0, 10, 270, 160);
//		
//		doub = new DoubleButton();
//		doub.addMouseListener(doub);
//		add(doub);
//		doub.setBounds(0, 190, 270, 160);
//		
//		intro = new IntroductionButton();
//		intro.addMouseListener(intro);
//		add(intro);
//		intro.setBounds(0, 370, 270, 160);
	}
	

	
	public void paint(Graphics g){
		Image background = null;
		String filepath = "background"+File.separator+"transparentBoard.png";
		background = new ImageIcon(filepath).getImage();
		g.drawImage(background,0,0,300,700,this);
		//g.drawImage(background,0,0,getWidth(),getHeight(),0,0,background.getWidth(null),background.getHeight( null),null);		
		super.paintChildren(g);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
