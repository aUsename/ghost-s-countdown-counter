package service;


import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;


public class SoundEffect extends Thread{
	String file;
	public SoundEffect(String file){
		this.file=file;
	}
	
	public void run() {
      
		if(Set.isSoundOn){
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
			// »º³å
			byte[] abData = new byte[512];

			try {
				while (nBytesRead != -1) {
					
				    nBytesRead = audioInputStream.read(abData, 0, abData.length);
					
					if (nBytesRead >= 0)
						auline.write(abData, 0, nBytesRead);
					
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
		


	/*public  static void main(String[] args){
		SoundEffect a = new SoundEffect("music"+File.separator+"button.wav");
		new Thread(a).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(a).start();
	}
*/
}
