package game;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.util.logging.Level;
import java.util.logging.Logger;





public class Splash extends Thread{

	 public static void main(String[] args) {
         new Thread() {
             public void run() {
                 try {
                     SplashScreen splash = SplashScreen.getSplashScreen();
                     Graphics2D g = splash.createGraphics();
                     g.setColor(Color.RED);
                     g.drawString("≤‚ ‘Œƒ◊÷", 10, 30);
                     splash.update();

                     Thread.sleep(1000);
                     g.setComposite(AlphaComposite.Clear);
                     g.fillRect(0, 0, (int) splash.getSize().getWidth(), (int) splash.getSize().getHeight());
                     splash.setImageURL(Splash.class.getResource("background/login.pg"));

                     int x = 100, y = 100;
                     String author = "1 2 3 4 5";
                     g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
                     g.setPaintMode();

                     for (int i = 0; i < 5; i++) {
                         g.setColor(new Color(50, 50, 0));
                         g.drawString(author, x + i, y + i - 1);
                         g.setColor(new Color(10, 10, 0));
                         g.drawString(author, x + i - 1, y + i);
                     }
                     g.setColor(Color.red);
                     g.drawString(author, x + 5, y + 5);
                     splash.update();
                     Thread.sleep(1000);


                 } catch (Exception ex) {
                     Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }.start();


         try {
             Thread.sleep(3000);
         } catch (Exception e) {
             e.printStackTrace();
         }

        new Launcher();
     }
 }






