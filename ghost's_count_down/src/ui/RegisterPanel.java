package ui;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class RegisterPanel extends JPanel{
/**
	 * 
	 */
	private static final long serialVersionUID = 4526463358476555947L;
	/*
 * 判断玩家是否存在，
 * 存在进去UpgradePanel;
 * 不存在进去RegisterSuccessPanel,再UpgradePanel
 */
	public JButton registerButton;
	JPanel textPanel;		
	JLabel idLabel;
	Background imagePanel;
	public JTextField idField;
	public JFrame  frame;
	public String getText(){
		return idField.getText();
	}
	
	public  RegisterPanel(){
			//登陆
		    
		    frame =new JFrame();
		    frame.setAlwaysOnTop(true);
		    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		    int screenWidth = screenSize.width;
		    int screenHeight = screenSize.height;
		    int frameHeight = 0;
		    int frameWidth = 0;
		    if(screenWidth*3>screenHeight*4){
		    	frameHeight =screenHeight/3;
		    	frameWidth = frameHeight*4/3;
		    }
		    else {
		    	frameWidth =screenWidth/3;
		    	frameHeight = frameWidth*4/3;
		    }
		    
		    frame.setSize(frameWidth,frameHeight);	   
		    frame.setLocation((screenWidth-frameWidth)/2,(screenHeight-frameHeight)/2);
		    frame.setLayout(null);
		    frame.setTitle("登陆");
		    frame.setVisible(true);
		    
		    imagePanel = new Background("background"+File.separator+"splash.jpg",
		    		       frame.getWidth(),frame.getHeight());
		    frame.getContentPane().add(imagePanel);
		    imagePanel.setBounds(0,0,frame.getWidth(),frame.getHeight());
		   
		   
		   
		   
		    
		    //登陆按钮
		    
		    registerButton = new JButton("登陆");
		    
		    registerButton.setForeground(Color.LIGHT_GRAY);
		    registerButton.setContentAreaFilled(false);
		    registerButton.setBorder(null);
		    imagePanel.add(registerButton);
		    registerButton.setLocation(frameWidth*2/5,frameHeight*3/5);
		    registerButton.setSize(frameWidth/5,frameHeight/10);
		    registerButton.setVisible(true);
		    
		    
		    //文本
		    textPanel = new JPanel();
		    textPanel.setLayout(null);
		    textPanel.setOpaque(false);
		    imagePanel.add(textPanel);
		    
		    textPanel.setSize(frameWidth,frameHeight*7/10);
		    textPanel.setLocation(0,0);
		    
		    //标签
		    idLabel = new JLabel("玩家名");
		    idLabel.setForeground(Color.LIGHT_GRAY);
		    idLabel.setSize(frameWidth/2,frameHeight/10);
		    idLabel.setLocation(frameWidth/8,frameHeight/5);
		    idLabel.setVisible(true);
		    
		    idField = new JTextField("请输入玩家姓名");
		    idField.setSize(frameWidth/2,frameHeight/10);
		    idField.setLocation(frameWidth*3/10,frameHeight/5);
		    idField.setVisible(true);
		    
		    textPanel.add(idField);
		    textPanel.add(idLabel);
		    textPanel.repaint();
		   
		    
		  
	}
	public static void main(String[] args){
		RegisterPanel a=new RegisterPanel();
	    System.out.println(a.idField.getText());
	}
	
}
	

	
		  
	

	

	

