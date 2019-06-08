import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author Kevin Nguyen
 * @version 1 - June 4, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * This class will ask the user to enter their name, as well as make sure the entered name
 * is within the character limit.
 * <br>
 * Time Spent: 1 hour
 * </p>
 */

/**
 * Change Log
 * June 4, 2019 - Created and finished PlayerNameReceiver.
 */ 
public class PlayerNameReceiver extends Screen implements ActionListener
{ 
  /**
   * This JTextField will be used to get user input.
   */ 
  private JTextField input;
  /**
   * This JLabel will display the first line of a message telling the player that the name they entered
   * is not within the character limit.
   */ 
  private JLabel notInLimit;
  /**
   * This JLabel will display the second line of a message telling the player that the name they entered
   * is not within the character limit.
   */ 
  private JLabel notInLimit2;
  /**
   * This variable will store the current PlayerNameReceiver object for use in an inner class.
   */ 
  private PlayerNameReceiver panel;
  
  /**
   * This constructor will create a PlayerNameReceiver object and assign the passed in parameter to game. 
   * It will initialize the custom fonts and initialize the layout of the panel. It will also assign the created object
   * to panel, set the background, and call the printTitle(), printFooter(), printScreen(), and exceedCharLimit() methods.
   * Finally, it will set the panel to visible.
   * 
   * @param d The DistractionAction object that contains the frame that PlayerNameReceiver will be displayed on.
   */   
  public PlayerNameReceiver(DistractionAction d)
  {
    game = d;
    panel = this;
    initializeFontsAndLayout();
    this.setBackground(DistractionAction.GREY);
    printTitle();
    printFooter();
    printScreen();
    setVisible(true);
  }
  
  /**
   * This method will print the JLabels that will ask the user to enter
   * their name and the JTextField that will receive the input. It will also print the JLabel
   * that will tell the user that their name is too long, but will not make it visible.
   * 
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * enterName                JLabel               The JLabel that will display "Enter your name below:".
   * maxChar                  JLabel               The JLabel that will display "(1-15 characters)".
   * </pre>
   * </p>
   */   
  private void printScreen()
  {
    JLabel enterName = new JLabel ("Enter your name below:", JLabel.CENTER); 
    enterName.setFont (playerNameFont);
    enterName.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, enterName, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, enterName, 130, SpringLayout.NORTH, game.frame);
    this.add(enterName);
    
    JLabel maxChar = new JLabel ("(1-15 characters)", JLabel.CENTER); 
    maxChar.setFont (playerNameFont);
    maxChar.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, maxChar, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, maxChar, 200, SpringLayout.NORTH, game.frame);
    this.add(maxChar);
    
    notInLimit = new JLabel ("Your name is not within", JLabel.CENTER);
    notInLimit.setFont (playerNameFont);
    notInLimit.setForeground(RED);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, notInLimit, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, notInLimit, 450, SpringLayout.NORTH, game.frame);
    notInLimit.setVisible(false);
    this.add(notInLimit);
    
    notInLimit2 = new JLabel ("the character limit!", JLabel.CENTER);
    notInLimit2.setFont (playerNameFont);
    notInLimit2.setForeground(RED);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, notInLimit2, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, notInLimit2, 520, SpringLayout.NORTH, game.frame);
    notInLimit2.setVisible(false);
    this.add(notInLimit2);
    
    input = new JTextField(20);
    
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, input, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.VERTICAL_CENTER, input, 0, SpringLayout.VERTICAL_CENTER, this);
    
    input.addActionListener(this);
    input.setFont(buttonFont);
    add(input);
  }
  
  /**
   * This method will be invoked when the enter key is pressed while the JTextField is selected.
   * If the String entered is within the character limit, the String will be passed into the playerName
   * variable of the DistractionAction class and the panel will be switched to the instructions screen
   * for the deficiencies room. Otherwise, a message telling the user that their name is not within
   * the character limit will be displayed.
   * 
   * @param e The ActionEvent that was triggered by pressing enter while the JTextField was selected.
   */   
  public void actionPerformed(ActionEvent e)
  {
    if (input.getText().length() <= 15 && input.getText().length() >= 1)
    {
      game.playerName = input.getText();
      game.instructions(0);
    }
    else
    {
      notInLimit.setVisible(true);
      notInLimit2.setVisible(true);
      input.setText("");
      new Thread() // creates 1.25 second delay before making text invisible
      {
        public void run() 
        {
          try 
          {
            this.sleep(1250);
          } 
          catch (InterruptedException e) 
          {
          }
          notInLimit.setVisible(false);
          notInLimit2.setVisible(false);
        }
      }.start();
    }
  }
}