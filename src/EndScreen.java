import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author Kevin Nguyen
 * @version 1 - June 7, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * This class will display an end screen congratulationg the user for finishing the game.
 * It will give the user the option to save their score to the desktop or return to the main menu.
 * This class extends GameLevel.
 * <br>
 * Time Spent: 1 hour
 * </p>
 * <p>
 * <pre>
 * Change Log
 * June 7, 2019 - Created and finished EndScreen class.
 * </pre>
 * </p>
 */ 
public class EndScreen extends GameLevel
{
  /**
   * This JButton will give the user the option to save their score to the desktop.
   */ 
  private JButton saveScore;
  /**
   * This JButton will allow the user to return to the main menu.
   */ 
  private JButton mainMenu;
  
  /**
   * This constructor will create a MatchingGame object. It will initialize the fonts and layout of the game, 
   * set the background colour, calls the printText() method, and makes the panel visible.
   *
   * @param d The DistractionAction object that contains the frame that instructions will be displayed on.
   */   
  public EndScreen(DistractionAction d)
  {
    game = d;
    initializeFontsAndLayout();
    setBackground(DistractionAction.GREY);
    printTitle();
    printResults();
    setVisible(true);
  }
  
  /**
   * This method will display the end screen which will congratulate the player and give them the option
   * to save their score or return to the main menu.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * congratulations          JLabel               The JLabel that will display "Congratulations,".
   * name                     JLabel               The JLabel that will display the player's name.
   * finished                 JLabel               The JLabel that will display "You have finished the game.".
   * score                    JLabel               The JLabel that will display how many documents the user managed to collect.
   * </pre>
   * </p>
   */ 
  protected void printResults() 
  {
    JLabel congratulations = new JLabel ("Congratulations,", JLabel.CENTER); 
    congratulations.setFont (endFont);
    congratulations.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, congratulations, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, congratulations, 125, SpringLayout.NORTH, game.frame);
    this.add(congratulations);
    
    JLabel name = new JLabel (game.playerName + "!", JLabel.CENTER); 
    name.setFont (endFont);
    name.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, name, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, name, 60, SpringLayout.NORTH, congratulations);
    this.add(name);
    
    JLabel finished = new JLabel ("You have finished the game.", JLabel.CENTER); 
    finished.setFont (endFont);
    finished.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, finished, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, finished, 125, SpringLayout.NORTH, name);
    this.add(finished);
    
    JLabel score = new JLabel ("Your final mark is " + game.playerScore + "%.", JLabel.CENTER); 
    score.setFont (endFont);
    score.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, score, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, score, 100, SpringLayout.NORTH, finished);
    this.add(score);
    
    saveScore = centredButtonCreator("Save Score to Desktop File", 550);
    mainMenu = centredButtonCreator("Main Menu", 650);
    
    add(saveScore);
    add(mainMenu);
  }
  
  /**
   * This method will return a centred JButton with a specified text and vertical position.
   * 
   * @param text The text that the button will display.
   * @param yPos The yPos/vertical height of the button.
   * @return A centred JButton with the specified text and vertical position.
   */
  private JButton centredButtonCreator(String text, int yPos) 
  {
    JButton button = new JButton(text);
    button.setFont(endFont);
    button.setForeground(Color.white);
    button.setFocusPainted(false);
    button.setMargin(new Insets(0, 0, 0, 0));
    button.setContentAreaFilled(false);
    button.setOpaque(false);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, button, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, button, yPos, SpringLayout.NORTH, game.frame);
    button.addActionListener(this);
    return button;
  }
  
  /**
   * This method will perform different functions depending on the JButton that is pressed. If the 
   * saveScore button is pressed, the player's score will be saved. Otherwise, the panel will switch
   * to the main menu screen.
   * 
   * @param e The ActionEvent that was triggered by a button press.
   */
  public void actionPerformed(ActionEvent e)
  {      
   if (e.getSource() == saveScore)
   {
     game.addToHighScores();
     saveScore.removeActionListener(this);
   }
   else
   {
     game.playerScore = 0;
     game.mainMenu(); 
   }
  }
}