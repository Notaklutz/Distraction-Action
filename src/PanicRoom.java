import java.awt.*;
import javax.swing.*;
import java.io.*;
/*
 * @author Kevin Nguyen
 * @version 1 - May 14, 2019
 * <p>
 * This class is a running game where the player will have to jump over distractions and collect boosts.
 * It extends JPanel.
 * </p>
 */
public class PanicRoom extends JPanel
{
  private DistractionAction game;
  
  /**
   * This constructor will create a PanicRoom object.
   * @param d The DistractionAction object that will contain the frame that PanicRoom will be displayed on.
   */   
  public PanicRoom(DistractionAction d)
  {
    game = d;
    this.setBackground(DistractionAction.GREY);
  }
}