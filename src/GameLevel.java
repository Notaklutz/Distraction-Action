import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author Kevin Nguyen
 * @version 1 - June 1, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * This abstract class provides two instance variables, an abstract method to print results,
 * and a method to create buttons in the results screen of any of the games in Distraction Action.
 * The games in Distraction Action will extend this class (LevelThreeResults in the case of the dodging arena), 
 * as will EndScreen. This class extends Screen and implements ActionListener.
 * <br>
 * Time Spent: 30 minutes
 * </p>
 */

/**
 * Change Log
 * June 1, 2019 - Created and finished GameLevel class. Added instance variables and methods.
 * June 7, 2019 - Added originalScore.
 */ 
public abstract class GameLevel extends Screen implements ActionListener
{
  /**
   * This JButton will allow the user to play the game again.
   */ 
  protected JButton tryAgain;
  /**
   * This JButton will allow the user to go to the next level or go back to level selection,
   * depending on whether or not the user is playing a full game.
   */ 
  protected JButton nextLevelOrLevelSelection;
  /**
   * This int is used to store the original score of the player before starting the level.
   */ 
  protected int originalScore;
  
  /**
   * This abstract method will be overridden by the subclasses of this class.
   * It is meant to print the results of each game.
   */ 
  protected abstract void printResults();
  
  /**
   * This method will create a JButton which will be used in the results screen of each game.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * button                   JButton              The JButton that will be used in the results screen.
   * </pre>
   * </p>
   * 
   * @param text The String to be displayed on the button.
   * @return The JButton that will be used in the results screen.
   */
  protected JButton resultButtonCreator(String text) 
  {
    JButton button = new JButton(text);
    button.setFont(buttonFont);
    button.setForeground(Color.WHITE);
    button.setFocusPainted(false);
    button.setMargin(new Insets(0, 0, 0, 0));
    button.setContentAreaFilled(false);
    button.setOpaque(false);
    button.addActionListener(this);
    return button;
  }
}