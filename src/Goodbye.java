import java.awt.*;
import javax.swing.*;
/**
 * @author Kevin Nguyen
 * @version 4 - June 2, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * This class will thank the user for playing the game. It extends Screen.
 * <br>
 * Time Spent: 1 hour
 * </p>
 * <p>
 * <pre>
 * Change Log
 * May 19, 2019 - Created Goodbye class and overrided printText() method. Code does not compile yet.
 * May 21, 2019 - Used SpringLayout to properly add and space out JLabels to panel. Also added
 *                Timer class to dispose of screen after a set amount of time.
 * May 26, 2019 - Moved delay method and disposing function to the driver class. Changed constructor to 
 *                accept an instance of the driver class as a parameter.
 * June 2, 2019 - Changed printText() to sayGoodbye(). Updated encapsulation of methods.
 * </p>
 * </pre>
 */ 
public class Goodbye extends Screen
{
  /**
   * This constructor will create a Goodbye object and assign the passed in parameter to game. It will initialize the custom fonts 
   * and the layout. It will also call the printTitle() method, the sayGoodbye() method, and the printFooter() method.
   * 
   * @param d The DistractionAction object that will contain the frame that goodbye will be displayed on.
   */   
  public Goodbye(DistractionAction d)
  {
    game = d;
    initializeFontsAndLayout();
    printTitle();
    sayGoodbye();
    printFooter();
    this.setBackground(DistractionAction.GREY);
    this.setVisible(true);
  }
  
  /**
   * This method will print a goodbye message to the user.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * goodbye                  JLabel               The JLabel that will display "GOODBYE!".
   * thank                    JLabel               The JLabel that will display "THANK YOU FOR PLAYING".
   * learned                  JLabel               The JLabel that will display "WE HOPE YOU LEARNED SOMETHING".
   * play                     JLabel               The JLabel that will display "PLAY AGAIN ANYTIME!".
   * </pre>
   * </p>
   */   
  private void sayGoodbye()
  {
    JLabel goodbye = new JLabel ("GOODBYE!", JLabel.CENTER); 
    goodbye.setFont (highScoresAndGoodbyeFont);
    goodbye.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, goodbye, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, goodbye, 90, SpringLayout.NORTH, game.frame);
    this.add(goodbye);
    
    JLabel thank = new JLabel ("THANK YOU FOR PLAYING", JLabel.CENTER);
    thank.setFont (highScoresAndGoodbyeFont);
    thank.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, thank, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, thank, 100, SpringLayout.SOUTH, goodbye);
    this.add(thank);
    
    JLabel learned = new JLabel ("WE HOPE YOU LEARNED SOMETHING", JLabel.CENTER);
    learned.setFont (highScoresAndGoodbyeFont);
    learned.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, learned, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, learned, 50, SpringLayout.SOUTH, thank);
    this.add(learned);
    
    JLabel play = new JLabel ("PLAY AGAIN ANYTIME!", JLabel.CENTER);
    play.setFont (highScoresAndGoodbyeFont);
    play.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, play, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, play, 50, SpringLayout.SOUTH, learned);
    this.add(play);
  }
}