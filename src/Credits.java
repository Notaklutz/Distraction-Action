import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author Kevin Nguyen
 * @version 1 - June 5, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * This class will display the credits of the game. It extends Screen
 * <br>
 * Time Spent: 45 minutes
 * </p>
 */

/**
 * Change Log
 * June 5, 2019 - Created and finished Credits class.
 */ 
public class Credits extends Screen implements KeyListener
{
  /**
   * This constructor will create a Credits object and assign the passed in parameter to game. It will initialize the custom fonts 
   * and the layout. It will also call the printTitle() method, the displayCredits() method, and the printFooter() method.
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
    addKeyListener(this);
  }
  
  /**
   * This method will display the credits to the user.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * creditsLabel             JLabel               The JLabel that will display "CREDITS!".
   * imagesLine1              JLabel               The JLabel that will display "Icons used in the making of the cards in the".
   * imagesLine2              JLabel               The JLabel that will display "matching game and the design of the".
   * imagesLine3              JLabel               The JLabel that will display "distractions and boosts in the dodging game".
   * imagesLine4              JLabel               The JLabel that will display "were made by Freepik from www.flaticon.com".
   * imagesLine5              JLabel               The JLabel that will display "The documents in the dodging game were adapted".
   * imagesLine6              JLabel               The JLabel that will display "from the Google Docs logo by Google LLC.".
   * imagesLine7              JLabel               The JLabel that will display "The images used in level one's book".
   * imagesLine8              JLabel               The JLabel that will display "are from Minecraft by Mojang.".
   * programmers              JLabel               The JLabel that will display "Programmers: Kevin Nguyen and Ryan Phan".
   * continueLabel            JLabel               The JLabel that will display "Press any key to return to the main menu.".
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
    
    JLabel imagesLine1 = new JLabel ("Icons used in the making of the cards in the");
    imagesLine1.setFont (defaultFont);
    imagesLine1.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, imagesLine1, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, imagesLine1, 30, SpringLayout.SOUTH, creditsLabel);
    this.add(imagesLine1);
    
    JLabel imagesLine2 = new JLabel ("matching game and the design of the");
    imagesLine2.setFont (defaultFont);
    imagesLine2.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, imagesLine2, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, imagesLine2, 30, SpringLayout.SOUTH, imagesLine1);
    this.add(imagesLine2);
    
    JLabel imagesLine3 = new JLabel ("distractions and boosts in the dodging game");
    imagesLine3.setFont (defaultFont);
    imagesLine3.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, imagesLine3, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, imagesLine3, 30, SpringLayout.SOUTH, imagesLine2);
    this.add(imagesLine3);
    
    JLabel imagesLine4 = new JLabel ("were made by Freepik from www.flaticon.com");
    imagesLine4.setFont (defaultFont);
    imagesLine4.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, imagesLine4, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, imagesLine4, 30, SpringLayout.SOUTH, imagesLine3);
    this.add(imagesLine4);
    
    JLabel imagesLine5 = new JLabel ("The documents in the dodging game were adapted");
    imagesLine5.setFont (defaultFont);
    imagesLine5.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, imagesLine5, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, imagesLine5, 30, SpringLayout.SOUTH, imagesLine4);
    this.add(imagesLine5);
    
    JLabel imagesLine6 = new JLabel ("from the Google Docs logo by Google LLC.");
    imagesLine6.setFont (defaultFont);
    imagesLine6.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, imagesLine6, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, imagesLine6, 30, SpringLayout.SOUTH, imagesLine5);
    this.add(imagesLine6);
    
    JLabel imagesLine7 = new JLabel ("The images used in level one's book");
    imagesLine7.setFont (defaultFont);
    imagesLine7.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, imagesLine7, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, imagesLine7, 30, SpringLayout.SOUTH, imagesLine6);
    this.add(imagesLine7);
    
    JLabel imagesLine8 = new JLabel ("are from Minecraft by Mojang.");
    imagesLine8.setFont (defaultFont);
    imagesLine8.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, imagesLine8, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, imagesLine8, 30, SpringLayout.SOUTH, imagesLine7);
    this.add(imagesLine8);
    
    JLabel programmers = new JLabel ("Programmers: Kevin Nguyen and Ryan Phan");
    programmers.setFont (defaultFont);
    programmers.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, programmers, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, programmers, 30, SpringLayout.SOUTH, imagesLine8);
    this.add(programmers);
    
    JLabel continueLabel = new JLabel ("Press any key to return to the main menu.");
    continueLabel.setFont (defaultFont);
    continueLabel.setForeground(DARK_RED);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, continueLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, continueLabel, 50, SpringLayout.SOUTH, programmers);
    this.add(continueLabel);
  }
  
  /**
   * This method will call game.mainMenu() to switch the panel back to the main menu screen.
   * 
   * @param e The KeyEvent that is triggered by a key press.
   */   
  public void keyPressed(KeyEvent e)
  {
    game.mainMenu();
  }
  
  /**
   * This method is invoked when a key is released. It has no purpose in the Credits class, 
   * but must be overridden as it is an abstract method in the KeyListener class.
   * 
   * @param e The KeyEvent that is triggered by a key release.
   */   
  public void keyReleased(KeyEvent e){}
  
  /**
   * This method is invoked when a key is typed. It has no purpose in the Credits class, but must be overridden
   * as it is an abstract method in the KeyListener class.
   * 
   * @param e The KeyEvent that is triggered by a key type.
   */   
  public void keyTyped(KeyEvent e){}
}