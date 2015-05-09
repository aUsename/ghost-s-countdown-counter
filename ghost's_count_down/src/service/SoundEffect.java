package service;


import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;


public class SoundEffect extends Thread{

	SourceDataLine auline;
	AudioInputStream audioInputStream = null;
	
	public SoundEffect(String file){

		File soundFile = new File(file);
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}

		AudioFormat format = audioInputStream.getFormat();
		auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		
		
	}
	
	public void run(){
		auline.start();
		int nBytesRead = 0;
		// »º³å
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
