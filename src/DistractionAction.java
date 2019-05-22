import java.awt.*;
import javax.swing.*;
/*
@author Kevin Nguyen
@version 1 - May 14, 2019
<p>
This class will thank the user for playing the game.
</p>
*/
public class DistractionAction
{
  public static JFrame frame;
  
  public static final Color grey = new Color (64, 64, 64);
  
  public static void main (String[] args)
  {
    frame = new JFrame("Distraction Action");
    frame.setSize(1000, 800);
    frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
    frame.setResizable(false);
    Goodbye g = new Goodbye();
    Instructions i = new Instructions(0);
    frame.setContentPane(i);
    frame.revalidate();
    frame.setVisible(true);
  }
}