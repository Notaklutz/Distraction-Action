import java.awt.*;
import javax.swing.*;
import java.io.*;
/*
 * @author Kevin Nguyen
 * @version 1 - May 14, 2019
 * <p>
 * This class will teach the player about common distractions and test their knowledge with a quiz.
 * It extends JPanel.
 * </p>
 */
public class DeficienciesRoom extends JPanel
{
  private DistractionAction game;
  
  /**
   * This constructor will create a DeficienciesRoom object.
   * @param d The DistractionAction object that will contain the frame that DeficienciesRoom will be displayed on.
   */   
  public DeficienciesRoom(DistractionAction d)
  {
    game = d;
    this.setBackground(DistractionAction.GREY);
  }
}