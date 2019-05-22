import java.awt.*;
import javax.swing.*;
/*
@author Kevin Nguyen
@version 1 - May 14, 2019
<p>
This class will display both the Kodiak Red logo and the game logo when Distraction
Action is first opened.
</p>
*/
public class SplashScreen extends TextOnly
{ 
  private JLabel splashScreen;
  
  public void kodiakRedLogo()
  {
   ImageIcon logo = new ImageIcon("Kodiak Red.png"); 
   splashScreen = new JLabel(logo);
   frame.add(splashScreen);
  }
  public void printText()
  {
    
  }
}