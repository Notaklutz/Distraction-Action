import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Kevin Nguyen
 * @version 1 - June 1, 2019
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 * This abstract class provides two instance variables and a method to create buttons in 
 * MainMenu and LevelSelection. It extends Screen and implements ActionListener.
 * </p>
 */

/**
 * Change Log
 * June 1, 2019 - Created and finished NavigationScreen class. Added instance variables and methods.
 */ 
public abstract class NavigationScreen extends Screen implements ActionListener 
{
  /**
   * Stores the amount of buttons. Used for spacing purposes.
   */
  protected int btnCount;
  /**
   * Stores the amount of pixels between two buttons. Used for spacing purposes in buttonCreator().
   */
  protected int spacingValue;

  /**
   * This method is used to create buttons in both the main menu and level selection screens.
   * This method was originally created by Ryan.
   *
   * @param text The string that will be passed in to the JButton constructor to be displayed on the JButton.
   * @return The created button which will be used in either the main menu or level selection screen.
   */
  protected JButton buttonCreator(String text) 
  {
    JButton button = new JButton(text);
    btnCount++;
    button.setFont(buttonFont);
    button.setForeground(Color.white);
    button.setFocusPainted(false);
    button.setMargin(new Insets(0, 0, 0, 0));
    button.setContentAreaFilled(false);
    button.setOpaque(false);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, button, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, button, btnCount * spacingValue, SpringLayout.NORTH, game.frame);
    button.addActionListener(this);
    return button;
  }
}