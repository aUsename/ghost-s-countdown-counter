package ui;

import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class RegisterPanel extends JPanel{
/*
 * 需要判断玩家是否存在，
 * 如果存在则跳转到UpgradePanel;
 * 如果不存在则跳出RegisterSuccessPanel,再到UpgradePanel
 */
	
			
	
	public  RegisterPanel(){
			//登陆界面
		    JFrame  registerPanel =new JFrame();
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
		    registerPanel.setBounds((screenWidth-frameWidth)/2,(screenHeight-frameHeight)/2,frameWidth,frameHeight);
		    registerPanel.setTitle("登陆");
		    registerPanel.setVisible(true);
		    
		    //登录按钮
		    JPanel buttonPanel = new JPanel();
		    buttonPanel.setSize(frameWidth,frameHeight/3);
		    buttonPanel.setLocation(0,frameHeight*7/10);
		    buttonPanel.setVisible(true);
		    
		    JButton registerButton = new JButton("登陆");
		    registerButton.setLocation(frameWidth*2/5,0);
		    registerButton.setSize(frameWidth/5,frameHeight/10);
		    registerButton.setVisible(true);
		    
		    //文本
		    JPanel textPanel = new JPanel();
		    textPanel.setSize(frameWidth,frameHeight*7/10);
		    textPanel.setLocation(0,0);
		    
		    //标签
		    JLabel idLabel = new JLabel("玩家名");
		    idLabel.setSize(frameWidth/2,frameHeight/10);
		    idLabel.setLocation(frameWidth/8,frameHeight/5);
		    idLabel.setVisible(true);
		    
		    JTextField idField = new JTextField("请输入玩家名");
		    idField.setSize(frameWidth/2,frameHeight/10);
		    idField.setLocation(frameWidth*3/10,frameHeight/5);
		    idField.setVisible(true);
		    
		    RegisterBackground imagePanel = new RegisterBackground();
		    imagePanel.getImage();
		    imagePanel.repaint();
		    
		    
		    textPanel.setLayout(null);
		    textPanel.add(idField);
		    textPanel.add(idLabel);
		    buttonPanel.setLayout(null);
		    buttonPanel.add(registerButton);
		    registerPanel.setLayout(null);
		    registerPanel.add(textPanel);
		    registerPanel.add(buttonPanel);
		    registerPanel.add(imagePanel);
		    registerPanel.repaint();
		    
	}
	public static void main(String[] args){
		RegisterPanel a=new RegisterPanel();
	}
	
}
	
	//背景图片
	class RegisterBackground extends JPanel{
		   Image BackgroundRegister;
		
		  public void getImage(){
				BufferedImage bufferedLogin = null; 
				try{
					bufferedLogin = ImageIO.read(new File("background"+File.separator+"splash.jpg"));
				}catch(IOException ex){
					ex.printStackTrace();
				}
			
				BackgroundRegister = bufferedLogin;
			}
			
			
			public void paintComponent(Graphics g) {
				g.drawImage(BackgroundRegister, 0, 0, this);       
		    }
	}
	
	
	
	
/*	public static void main(String[] args){
		RegisterPanel a=new RegisterPanel();
	}
	
}	
*/
	

