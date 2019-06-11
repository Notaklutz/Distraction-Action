import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author Kevin Nguyen
 * @version 2 - June 9, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * This class will display the credits of the game. It extends Screen
 * <br>
 * Time Spent: 1 hour
 * </p>
 * <p>
 * <pre>
 * Change Log
 * June 5, 2019 - Created and finished Credits class.
 * June 9, 2019 - Removed KeyListener. Replaced with Key Binding.
 * </pre>
 * </p>
 */ 
public class Credits extends Screen
{
  /**
   * This constructor will create a Credits object and assign the passed in parameter to game. It will initialize the custom fonts 
   * and the layout. It will also call the printTitle() method, the displayCredits() method, and the printFooter() method.
   * It will set the panel to visible and set the background colour to grey.
   * 
   * @param d The DistractionAction object that will contain the frame that credits will be displayed on.
   */   
  public Credits(DistractionAction d)
  {
    game = d;
    initializeFontsAndLayout();
    printTitle();
    displayCredits();
    printFooter();
    this.setBackground(DistractionAction.GREY);
    this.setVisible(true);
  }
  
  /**
   * This method will display the credits to the user.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * creditsLabel             JLabel               The JLabel that will display "CREDITS!".
   * imagesLine1              JLabel               The JLabel that will display "Icons used in the making of the cards in the".
   * imagesLine2              JLabel               The JLabel that will display "Matching Mayhem and the design of the".
   * imagesLine3              JLabel               The JLabel that will display "distractions, boosts, and documents in".
   * imagesLine4              JLabel               The JLabel that will display "the Dodging Arena were made by Freepik".
   * imagesLine5              JLabel               The JLabel that will display "from www.flaticon.com.".
   * imagesLine6              JLabel               The JLabel that will display "The images used in level one's book".
   * imagesLine7              JLabel               The JLabel that will display "are from Minecraft by Mojang.".
   * programmers              JLabel               The JLabel that will display "Programmers: Kevin Nguyen and Ryan Phan".
   * continueLabel            JLabel               The JLabel that will display "PRESS ENTER TO RETURN TO THE MAIN MENU".
   * input                    InputMap             The InputMap of the panel.
   * action                   ActionMap            The ActionMap of the panel.
   * </pre>
   * </p>
   */   
  private void displayCredits()
  {
    JLabel creditsLabel = new JLabel ("CREDITS", JLabel.CENTER); 
    creditsLabel.setFont (defaultFont);
    creditsLabel.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, creditsLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, creditsLabel, 90, SpringLayout.NORTH, game.frame);
    this.add(creditsLabel);
    
    JLabel imagesLine1 = new JLabel ("Icons used in the making of the cards in");
    imagesLine1.setFont (defaultFont);
    imagesLine1.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, imagesLine1, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, imagesLine1, 30, SpringLayout.SOUTH, creditsLabel);
    this.add(imagesLine1);
    
    JLabel imagesLine2 = new JLabel ("Matching Mayhem and the design of the");
    imagesLine2.setFont (defaultFont);
    imagesLine2.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, imagesLine2, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, imagesLine2, 30, SpringLayout.SOUTH, imagesLine1);
    this.add(imagesLine2);
    
    JLabel imagesLine3 = new JLabel ("distractions, boosts, and documents in");
    imagesLine3.setFont (defaultFont);
    imagesLine3.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, imagesLine3, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, imagesLine3, 30, SpringLayout.SOUTH, imagesLine2);
    this.add(imagesLine3);
    
    JLabel imagesLine4 = new JLabel ("the Dodging Arena were made by Freepik");
    imagesLine4.setFont (defaultFont);
    imagesLine4.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, imagesLine4, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, imagesLine4, 30, SpringLayout.SOUTH, imagesLine3);
    this.add(imagesLine4);
    
    JLabel imagesLine5 = new JLabel ("from www.flaticon.com.");
    imagesLine5.setFont (defaultFont);
    imagesLine5.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, imagesLine5, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, imagesLine5, 30, SpringLayout.SOUTH, imagesLine4);
    this.add(imagesLine5);
    
    JLabel imagesLine6 = new JLabel ("The images used in level one's book");
    imagesLine6.setFont (defaultFont);
    imagesLine6.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, imagesLine6, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, imagesLine6, 30, SpringLayout.SOUTH, imagesLine5);
    this.add(imagesLine6);
    
    JLabel imagesLine7 = new JLabel ("are from Minecraft by Mojang.");
    imagesLine7.setFont (defaultFont);
    imagesLine7.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, imagesLine7, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, imagesLine7, 30, SpringLayout.SOUTH, imagesLine6);
    this.add(imagesLine7);
    
    JLabel programmers = new JLabel ("Programmers: Kevin Nguyen and Ryan Phan");
    programmers.setFont (defaultFont);
    programmers.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, programmers, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, programmers, 30, SpringLayout.SOUTH, imagesLine7);
    this.add(programmers);
    
    JLabel continueLabel = new JLabel ("PRESS ENTER TO RETURN TO THE MAIN MENU.");
    continueLabel.setFont (defaultFont);
    continueLabel.setForeground(DARK_RED);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, continueLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, continueLabel, 50, SpringLayout.SOUTH, programmers);
    this.add(continueLabel);

    InputMap input = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    input.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "Back to Menu");
    ActionMap action = this.getActionMap();
    action.put("Back to Menu", new AbstractAction()
    {
      public void actionPerformed(ActionEvent e)
      {
        game.mainMenu();
      }
    }
    );
  }
}