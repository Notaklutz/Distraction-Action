import java.awt.*;
import javax.swing.*;
import java.io.*;
/*
 * @author Kevin Nguyen
 * @version 1 - May 14, 2019
 * <p>
 * This class is a dodging game where the player will have to use the WASD keys to move around and dodge 
 * distractions while collecting boosts and data files. It extends JPanel.
 * </p>
 */
public class EscapeRoom extends JPanel
{
  private DistractionAction game;
  
  /**
   * This constructor will create a EscapeRoom object.
   * @param d The DistractionAction object that will contain the frame that EscapeRoom will be displayed on.
   */   
  public EscapeRoom(DistractionAction d)
  {
    game = d;
    this.setBackground(DistractionAction.GREY);
  }
}