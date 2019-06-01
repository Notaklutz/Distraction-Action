import java.awt.*;
import javax.swing.*;
import java.io.*;
/*
 * @author Kevin Nguyen
 * @version 1 - May 14, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * This class will thank the user for playing the game. It extends TextOnly.
 * </p>
 */
public class Goodbye extends TextOnly
{
  /**
   * This constructor will create a Goodbye object and assign the passed in parameter to game. It will initialize the custom fonts 
   * and register them to the Graphics environment as well as initialize the layout of the panel.
   * It will also call the printTitle() method, the printText() method, and the printFooter() method.
   * 
   * @param d The DistractionAction object that will contain the frame that goodbye will be displayed on.
   */   
  public Goodbye(DistractionAction d)
  {
    game = d;
    initializeFontsAndLayout();
    printTitle();
    printText();
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
  public void printText()
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