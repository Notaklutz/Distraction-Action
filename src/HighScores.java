import java.awt.*;
import java.awt.event.*;
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
 * This class will display the 5 highest high scores to the user and give them the 
 * option to clear the data or return to the menu. It extends TextOnly and implements ActionListener.
 * </p>
 */
public class HighScores extends TextOnly implements ActionListener
{ 
  /**
   * The header that will appear at the top of the high scores file.
   */   
  private String header = "Distraction Action High Scores";
  /**
   * The filename of the high scores file.
   */   
  private final String HIGH_SCORES_FILENAME = "HighScores.kdr";
  /**
   * The JButton that will clear the data from the high scores file.
   */   
  private JButton clearData;
  /**
   * The JButton that will switch back to the menu screen.
   */   
  private JButton backToMenu;
  /**
   * The size of the leaderboard.
   */   
  private final int LEADERBOARD_SIZE = 5;
  /**
   * The array that stores all of the names on the leaderboard.
   */ 
  private String[] allNames = new String[5];
  /**
   * The array that stores all of the scores on the leaderboard.
   */ 
  private int[] allScores = new int[5];
  /**
   * The array that stores all of the JLabels displaying the names on the leaderboard.
   */ 
  private JLabel[] names = new JLabel[5];
  /**
   * The array that stores all of the JLabels displaying the scores on the leaderboard.
   */ 
  private JLabel[] scores = new JLabel[5];
  
  /**
   * This constructor will create a HighScores object and assign the passed in parameter to game. It will initialize the custom fonts 
   * and register them to the Graphics environment as well as initialize the layout of the panel.
   * It will also call the printTitle() method, the printText() method, and the printFooter() method.
   * 
   * @param d The DistractionAction object that will contain the frame that high scores will be displayed on.
   */   
  public HighScores(DistractionAction d)
  {
    game = d;
    initializeFontsAndLayout();
    printTitle(); 
    getHighScores();
    printText(); 
    this.setBackground(DistractionAction.GREY);
    this.setVisible(true);
  }
  
  /**
   * This method will print the empty high scores table and data clear options to the user. It will also attempt to
   * print the actual high scores table if possible.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * highScores               JLabel               The JLabel that will display "HIGH SCORES".
   * rank                     JLabel               The JLabel that will display "RANK".
   * name                     JLabel               The JLabel that will display "NAME".
   * score                    JLabel               The JLabel that will display "SCORE".
   * one                      JLabel               The JLabel that will display "1.".
   * two                      JLabel               The JLabel that will display "2.".
   * three                    JLabel               The JLabel that will display "3.".
   * four                     JLabel               The JLabel that will display "4.".
   * five                     JLabel               The JLabel that will display "5.".
   * </pre>
   * </p>
   */   
  public void printText()
  {
    JLabel highScores = new JLabel ("HIGH SCORES", JLabel.CENTER); 
    highScores.setFont (highScoresAndGoodbyeFont);
    highScores.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, highScores, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, highScores, 100, SpringLayout.NORTH, game.frame);
    this.add(highScores);
    
    JLabel rank = new JLabel ("RANK", JLabel.CENTER);
    rank.setFont (highScoresAndGoodbyeFont);
    rank.setForeground(Color.white);
    layout.putConstraint(SpringLayout.WEST, rank, 60, SpringLayout.WEST, game.frame);
    layout.putConstraint(SpringLayout.NORTH, rank, 30, SpringLayout.SOUTH, highScores);
    this.add(rank);
    
    JLabel name = new JLabel ("NAME", JLabel.CENTER);
    name.setFont (highScoresAndGoodbyeFont);
    name.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, name, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, name, 30, SpringLayout.SOUTH, highScores);
    this.add(name);
    
    JLabel score = new JLabel ("SCORE", JLabel.CENTER);
    score.setFont (highScoresAndGoodbyeFont);
    score.setForeground(Color.white);
    layout.putConstraint(SpringLayout.WEST, score, 220, SpringLayout.EAST, name);
    layout.putConstraint(SpringLayout.NORTH, score, 30, SpringLayout.SOUTH, highScores);
    this.add(score);
    
    JLabel one = new JLabel ("1.", JLabel.CENTER);
    one.setFont (highScoresAndGoodbyeFont);
    one.setForeground(Color.white);
    layout.putConstraint(SpringLayout.WEST, one, 70, SpringLayout.WEST, game.frame);
    layout.putConstraint(SpringLayout.NORTH, one, 20, SpringLayout.SOUTH, rank);
    this.add(one);
    
    JLabel two = new JLabel ("2.", JLabel.CENTER);
    two.setFont (highScoresAndGoodbyeFont);
    two.setForeground(Color.white);
    layout.putConstraint(SpringLayout.WEST, two, 70, SpringLayout.WEST, game.frame);
    layout.putConstraint(SpringLayout.NORTH, two, 20, SpringLayout.SOUTH, one);
    this.add(two);
    
    JLabel three = new JLabel ("3.", JLabel.CENTER);
    three.setFont (highScoresAndGoodbyeFont);
    three.setForeground(Color.white);
    layout.putConstraint(SpringLayout.WEST, three, 70, SpringLayout.WEST, game.frame);
    layout.putConstraint(SpringLayout.NORTH, three, 20, SpringLayout.SOUTH, two);
    this.add(three);
    
    JLabel four = new JLabel ("4.", JLabel.CENTER);
    four.setFont (highScoresAndGoodbyeFont);
    four.setForeground(Color.white);
    layout.putConstraint(SpringLayout.WEST, four, 70, SpringLayout.WEST, game.frame);
    layout.putConstraint(SpringLayout.NORTH, four, 20, SpringLayout.SOUTH, three);
    this.add(four);
    
    JLabel five = new JLabel ("5.", JLabel.CENTER);
    five.setFont (highScoresAndGoodbyeFont);
    five.setForeground(Color.white);
    layout.putConstraint(SpringLayout.WEST, five, 70, SpringLayout.WEST, game.frame);
    layout.putConstraint(SpringLayout.NORTH, five, 20, SpringLayout.SOUTH, four);
    this.add(five);
    
    clearData = centredButtonCreator("CLEAR SCORES", 580);
    backToMenu = centredButtonCreator("RETURN TO MENU", 650);
    this.add(clearData);
    this.add(backToMenu);
    
    // Printing the high scores
    for (int x = 0; x < allNames.length; x++)
    {
      if (allNames[x] != null)
      {
        names[x] = new JLabel (allNames[x], JLabel.CENTER); 
        names[x].setFont (highScoresAndGoodbyeFont);
        names[x].setForeground(Color.white);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, names[x], 0, SpringLayout.HORIZONTAL_CENTER, name);
        layout.putConstraint(SpringLayout.NORTH, names[x], x * 55 + 20, SpringLayout.SOUTH, name);
        this.add(names[x]);
        
        scores[x] = new JLabel (Integer.toString(allScores[x]), JLabel.CENTER); 
        scores[x].setFont (highScoresAndGoodbyeFont);
        scores[x].setForeground(Color.white);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, scores[x], 0, SpringLayout.HORIZONTAL_CENTER, score);
        layout.putConstraint(SpringLayout.NORTH, scores[x], x * 55 + 20, SpringLayout.SOUTH, score);
        this.add(scores[x]);
      }
    }
  }
  
  /**
   * This method will return a centred JButton with a specified text and vertical height.
   * 
   * @param text The text that the button will display.
   * @param yPos The yPos/vertical height of the button.
   */
  private JButton centredButtonCreator(String text, int yPos) 
  {
    JButton button = new JButton(text);
    button.setFont(buttonFont);
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
   * This method will either clear the data in high scores or return to main menu, depending on what button the player pressed.
   * 
   * @param e The ActionEvent that was triggered by the player's button press.
   */
  public void actionPerformed(ActionEvent e) 
  {
    if (e.getSource() == clearData) 
    {
      clearHighScores();
    }
    else if (e.getSource() == backToMenu) 
    {
      game.mainMenu();
    } 
  }
  
  /**
   * This method is used to create a new high scores file in the event that there isn't one or the header is incorrect.
   * It will also be invoked when the user chooses to clear the high scores.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * output                   PrintWriter          The PrintWriter that will create the file that will store the high scores and print the header to it.
   * </pre>
   * </p>
   */
  private void createNewHighScoresFile ()
  {
    try
    {
      PrintWriter output = new PrintWriter (new FileWriter (HIGH_SCORES_FILENAME));
      output.println (header);
      output.close ();
    }
    catch (IOException e)
    {
    }
  }
  
  
  /**   
   * This method is used to either create a new high scores file using createNewHighScoresFile() (in the event that there is no 
   * high scores file or the header is incorrect) or add the player's score to the file.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * input                    BufferedReader       The BufferedReader that will read the header of the file.
   * output                   PrintWriter          The PrintWriter that will print the player's name and score to the file.
   * </pre>
   * </p>
   * 
   * @param name The player's name.
   * @param score The player's score.
   */
  private void writeHighScores (String name, int score)
  {
    while (true)
    {
      try
      {
        BufferedReader input = new BufferedReader (new FileReader (HIGH_SCORES_FILENAME));
        if (!(input.readLine ().equals (header)))
        {
          createNewHighScoresFile ();
        }
        PrintWriter output = new PrintWriter (new FileWriter (HIGH_SCORES_FILENAME, true));
        output.println (name);
        output.println (score);
        output.close ();
        break;
      }
      catch (IOException e)
      {
        createNewHighScoresFile ();
        continue;
      }
    }
  }
   
   
  /**   
   * This method retrieves the names and scores from the high scores file and stores it in some arrays. The array is
   * then sorted by invoking sortHighScores().
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * numOfScores              int                  The number of scores in the file.
   * line                     String               The String that will be used to store the scores in the file.
   * input                    BufferedReader       The BufferedReader that will be used to read the file.
   * </pre>
   * </p>
   */
  private void getHighScores ()
  { 
    int numOfScores = -1;
    String line = "";
    BufferedReader input;
    
    while (true)
    {
      try
      {
        input = new BufferedReader (new FileReader (HIGH_SCORES_FILENAME));
        if (!(input.readLine ().equals (header)))
        {
          createNewHighScoresFile ();
          continue;
        }
        else
        {
          while (line != null) // Finds how many lines are in the file
          {
            input.readLine ();
            line = input.readLine ();
            numOfScores++;                     
          }
          input.close ();
          break;
        }
      }
      catch (IOException e)
      {
        createNewHighScoresFile ();
      }
    }
    try
    {
      input = new BufferedReader (new FileReader (HIGH_SCORES_FILENAME));
      allScores = new int [LEADERBOARD_SIZE + numOfScores];
      allNames = new String [LEADERBOARD_SIZE + numOfScores];
      input.readLine ();
      
      for (int i = 0 ; i < numOfScores ; i++)
      {
        allNames [i] = input.readLine ();
        line = input.readLine ();
        allScores [i] = Integer.parseInt (line);
      }
      input.close ();
    }
    catch (Exception e) // General Exception in case something in the file is invalid. 
    {
      createNewHighScoresFile ();
    }
    sortHighScores (numOfScores);
  }
   
   
  /**
   * This method is used to sort the high scores.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * movedScore               int                  An int used to temporarily store a score. It is used to sort the scores.
   * movedName                String               A String used to temporarily store a name. It is used to sort the names.
   * </pre>
   * </p>
   * 
   * @param numOfScores The number of scores to be sorted.
   */
  private void sortHighScores (int numOfScores)
  {
    for (int i = 0 ; i < numOfScores ; i++)
    {
      for (int j = i + 1 ; j < numOfScores ; j++)
      {
        int movedScore = 0;
        String movedName = "";
        if (allScores [i] < allScores [j])    // If element is greater than one after it. 
        {
          movedScore = allScores [i];        // Store temporary variable
          allScores [i] = allScores [j];    // Switch the elements
          allScores [j] = movedScore;        // i to j and j to i
          
          movedName = allNames [i];
          allNames [i] = allNames [j];
          allNames [j] = movedName;
        }
      }
    }
  }
   
   
  /**   
   * This method calls createNewHighScoresFile() to erase the old file and game.highScores() to refresh the frame.
   */
  private void clearHighScores ()
  {
    createNewHighScoresFile ();
    game.highScores();
  }
}