package game;

import java.util.Calendar;
import java.util.Date;

import service.Players;


public class PlayerInfo {
   
	
   public String name;
   String password;
   public int    bestGrade;
   
   Calendar registerTime;
   Calendar updateTime;
   
   Players fileSorce;
   
   public static final  String splitSign = "jfdk";
   
   
   
   public PlayerInfo(Players sorce){
	   fileSorce = sorce;
	   
   }
   
   
   
   public PlayerInfo(Players sorce,String s){
	   this(sorce);
	   initial();
	   name = s ;
   }
   
   
   
   
   public void initial(){
	   bestGrade = 0;
	   password = "123456";
	   registerTime = Calendar.getInstance();
	   registerTime.setTime(new Date());
	   updateTime = Calendar.getInstance();
	   updateTime.setTime(new Date());
   }
   
   
   
   
   
   
   
   public void initial(String s){
	   String str[] = s.split(splitSign);
	   
	   try{
	
		   name = str[0];
		   password = str[1];
		   bestGrade= Integer.parseInt(str[2]);
		   
		   registerTime = Calendar.getInstance();
		   registerTime.setTimeInMillis(Long.parseLong(str[3]));
		   updateTime  = Calendar.getInstance();
		   updateTime.setTimeInMillis(Long.parseLong(str[4]));
		  
		   
	   }catch(IndexOutOfBoundsException e){
		   System.out.println(e);
		   System.out.println("initial error of player");
	   }
   }
   
  
   
   
   
   
   public void update(){
	   updateTime.setTime(new Date());
   }
   
  
   
   
   public boolean storage(){
		boolean isSuccessful = true;
		try{
			fileSorce.storage(this);
			
		}catch(Exception e){
			System.out.println(e);
			isSuccessful = false;
		}
		
		return isSuccessful;
	}



public String getString() {
	// TODO Auto-generated method stub

	String s = name + splitSign + password + splitSign + bestGrade +splitSign+ registerTime.getTimeInMillis() + splitSign + updateTime.getTimeInMillis();
	return  s;
}
}
