package ui;

import java.awt.*;

import javax.swing.*;

public class UpgradePanel extends JFrame{  
	  
    //JPanel row1 = new JPanel();
      
    JPanel row2 = new JPanel();    
    JButton[] line1 = new JButton[5];    
    JButton[] line2 = new JButton[5];
    JButton[] line3 = new JButton[5]; 
    JButton[] line4 = new JButton[5]; 

   
    
    JPanel row3 = new JPanel();  
    JButton back = new JButton("返回"); 
    JButton quit = new JButton("退出");  

  
    public UpgradePanel() throws HeadlessException {  
        super("关卡选择");  
        setSize(1100,700);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        GridLayout gridLayout = new GridLayout(2, 6, 10, 50);//row3和row2之间的距离  
        setLayout(gridLayout);  
          
        
          
        GridLayout gridLayout1 = new GridLayout(4, 6, 50, 20);  //长，宽，水平距离，垂直距离
        row2.setLayout(gridLayout1);  


        for (int i = 0; i < 5; i++) {  
            line1[i] = new JButton(Integer.toString(i+1));
            row2.add(line1[i]);  
        }  
  
        for (int i = 0; i < 5; i++) {  
            line2[i] = new JButton(Integer.toString(i+6));  
           row2.add(line2[i]);  
        }  
 
        for (int i = 0; i < 5; i++) {  
            line3[i] = new JButton(Integer.toString(i+11));  
           row2.add(line3[i]);  
        }  
 
        for (int i = 0; i < 5; i++) {  
            line4[i] = new JButton(Integer.toString(i+16));   
           row2.add(line4[i]);  
        }   
        add(row2);  
          
        FlowLayout flowLayout2 = new FlowLayout(FlowLayout.CENTER,250,50);  
        row3.setLayout(flowLayout2);
        row3.add(back); 
        row3.add(quit);   
        add(row3);
        setVisible(true);  
        
        Background a = new Background();
    }  
      
	      
/*	public static void main(String[] args){
		UpgradePanel P = new UpgradePanel();
	}*/
	
}
