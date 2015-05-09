package service;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;


/**
 * 播放声音的类【只能播放wav格式】
 */
public class Music extends Thread {
	String file;
	public Music(String file){
		this.file=file;
	}
	
	
	public void run() {
      
		while(true){
    	  
			File soundFile = new File(file);

			AudioInputStream audioInputStream = null;
			try {
				audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			} catch (Exception e1) {
				e1.printStackTrace();
				return;
			}

			AudioFormat format = audioInputStream.getFormat();
			SourceDataLine auline = null;
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

			try {
				auline = (SourceDataLine) AudioSystem.getLine(info);
				auline.open(format);
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}

			auline.start();
			int nBytesRead = 0;
			// 缓冲
			byte[] abData = new byte[512];

			try {
				while (nBytesRead != -1) {
					if(Set.isMusicOn){
						nBytesRead = audioInputStream.read(abData, 0, abData.length);
					
					if (nBytesRead >= 0)
						auline.write(abData, 0, nBytesRead);
					}
					
				}
			} catch (IOException e) {
				e.printStackTrace();
				return;
			} finally {
				auline.drain();
				auline.close();
			}

		}
		
	}
	
}
