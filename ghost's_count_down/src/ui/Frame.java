package ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame implements KeyListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();		
		frame.setLayout(null);
		frame.setSize(1100, 700);
		
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		EnterButton eb = new EnterButton();
		eb.setBounds(300, 500, 415, 95);
		
		EnterPanel ep = new EnterPanel();
		frame.add(ep);
		ep.setBounds(0, 0, 1100, 700);
		ep.setLayout(null);
		ep.add(eb);
		frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
