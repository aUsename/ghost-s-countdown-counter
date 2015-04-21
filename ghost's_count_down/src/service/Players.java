package service;

import game.PlayerInfo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Players {

	File file;
	
	
	
	public Players(){
		file = new File("player.txt");
		if(!file.exists()){
			//  open  a dialog with "failed to open"
			System.out.println("file not exists");		
	    }
		
	}
	
	
	
	public ArrayList<PlayerInfo> getPlayers() throws IOException {
		
		ArrayList<String> array = read();
		ArrayList<PlayerInfo> players = new ArrayList<>();
	
		for(String s : array){
			PlayerInfo player = new PlayerInfo(this);
			player.initial(s);
			players.add(player);
			
		}
		return players;
	}
	
	
	
	/**
	 * storage in order 
	 * @param player
	 * @throws IOException
	 */
	
	public void storage(PlayerInfo player) throws IOException{
		/*
		StringBuffer strBuffer = new StringBuffer();	
		ArrayList<String> array = new ArrayList<String>();
		array = read();
		array.add(player.getString());
		for(String s : array){
			strBuffer.append(s);
			strBuffer.append(System.getProperty("line.separator"));
		}
		reWrite(new String(strBuffer));
	   */
		
		ArrayList<PlayerInfo>  players = getPlayers();
		StringBuffer strBuffer = new StringBuffer();
		
		PlayerInfo temp = null;
		for(PlayerInfo p : players){
			if(p.name.equals(player.name)){
				temp = p;
			}
		}
		players.remove(temp);
		
		boolean isAdded = false;
		for(PlayerInfo p : players){
			if(p.bestGrade>player.bestGrade){
				strBuffer.append(p.getString());
				strBuffer.append(System.getProperty("line.separator"));
			}
			if((!isAdded)&&(p.bestGrade<player.bestGrade)){
				strBuffer.append(player.getString());
				strBuffer.append(System.getProperty("line.separator"));
				strBuffer.append(p.getString());
				strBuffer.append(System.getProperty("line.separator"));
			    isAdded = true;
			}
			
		}
		if(!isAdded)  {
			strBuffer.append(player.getString());
			strBuffer.append(System.getProperty("line.separator"));
		}
		
		reWrite(new String(strBuffer));
	}
	
	
	
	
	public ArrayList<String> read() throws IOException{
		
		
		ArrayList<String> strBuffer = new ArrayList<String>();
		String s;
		
		
		BufferedReader br;
		br = new BufferedReader(new FileReader(file));
		s = br.readLine();
		while(s!=null){
			
			strBuffer.add(s);
			s = br.readLine();
			
		}
		br.close();
		
		return strBuffer;

	   
	}
	
	
	
	
	
	public void reWrite(String s){
		
		
		try{

			BufferedWriter bw = new BufferedWriter(new FileWriter(file)); 
			bw.write(s);
			bw.flush();
			bw.close();
		
		}catch(Exception e){
			System.out.println(e);
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Players ps = new Players();
          
          ArrayList<PlayerInfo> players = null;
          try{
        	 players = ps.getPlayers();
        	 
          }catch(Exception e){
        	  System.out.println(e);
          }
          for(PlayerInfo p : players){
        	  
        	  System.out.println(p.getString());
        	  p.update();
        	  p.storage();
        	  System.out.println(p.getString());
          }
         
          
	}

}
