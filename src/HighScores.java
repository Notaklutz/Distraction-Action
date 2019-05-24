import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
/*
 * @author Kevin Nguyen
 * @version 1 - May 14, 2019
 * <p>
 * This class will display the 5 highest high scores to the user and give them the 
 * option to clear the data or return to the menu. It extends TextOnly and implements ActionListener.
 * </p>
 * <p>
 * <pre>
 * Variable Name            Variable Type        Description
 * header                   String               The header that will appear at the top of the high scores file.
 * HIGH_SCORES_FILENAME     String               The filename of the high scores file.
 * clearData                JButton              The JButton that will clear the data from the high scores file.
 * backToMenu               JButton              The JButton that will switch back to the menu screen.
 * </pre>
 */
public class HighScores extends TextOnly implements ActionListener
{ 
  private String header = "Distraction Action High Scores";
  
  private final String HIGH_SCORES_FILENAME = "HighScores.kdr";
  
  private JButton clearData;
  
  private JButton backToMenu;
  
  /**
   * This constructor will create a HighScores object and assign the passed in parameter to game. It will initialize the custom fonts 
   * and register them to the Graphics environment as well as initialize the layout of the panel.
   * It will also call the printTitle() method, the printText() method, and the printFooter() method.
   * @param d The DistractionAction object that will contain the frame that high scores will be displayed on.
   */   
  public HighScores(DistractionAction d)
  {
    game = d;
    initializeFontsAndLayout();
    ge.registerFont (bigTitle);
    ge.registerFont (smallTitle);
    ge.registerFont (buttonFont);
    ge.registerFont (highScoresAndGoodbyeFont);
    ge.registerFont (defaultFont);
    printTitle();
    printText();
    this.setBackground(DistractionAction.GREY);
    this.setVisible(true);
  }
  
  /**
   * This method will print the empty high scores table and data clear options to the user.
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
  }
  
  /**
   * This method will return a centred JButton with a specified text and vertical height.
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
   * @param e The ActionEvent that was triggered by the player's button press.
   */
  public void actionPerformed(ActionEvent e) 
  {
    if (e.getSource() == clearData) 
    {
      System.out.println("Data has been cleared.");
    }
    else if (e.getSource() == backToMenu) 
    {
      game.mainMenu();
    } 
  }
  
  /*   This method is used to create a new save file in the event that there isn't one or the header is incorrect.
   *   ----------------------------------------------------------------------------------------------------------------
   *   Local Variables: output - PrintWriter - Used to output the header and make a new file.
   *   Global Variables Used: None
   *   ----------------------------------------------------------------------------------------------------------------
   *   No input/logic/loop is used.
   *
  private void createNewSaveFile ()
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
  
  
  /*   This method is used to either create a new save file using createNewSaveFile(), or it adds the match results to
   *   a file.
   *   ----------------------------------------------------------------------------------------------------------------
   *   Local Variables:
   *   input - BufferedReader - Used to check for a header.
   *   output - PrintWriter - Used to output the results into the file.
   *   Global Variables Used: None
   *   ----------------------------------------------------------------------------------------------------------------
   *   A while loop is used to ensure that a new file is create if anything goes wrong.
   *
  private void writeHighScores (String name, int score)
  {
    while (true)
    {
      try
      {
        BufferedReader input = new BufferedReader (new FileReader (HIGHS_CORES_FILENAME));
        if (!(input.readLine ().equals (header)))
        {
          createNewSaveFile ();
        }
        PrintWriter output = new PrintWriter (new FileWriter (HIGHS_CORES_FILENAME, true));
        output.println (name);
        output.println (score);
        output.close ();
        break;
      }
      catch (IOException e)
      {
        createNewSaveFile ();
        continue;
      }
    }
  }
  
  
  /*   This method retrieves the high scores from the save file and stores it in some arrays. The array is then sorted
   *   with sortHighScores()
   *   ----------------------------------------------------------------------------------------------------------------
   *   Local Variables:
   *   numOfScores - int - Used to store the number of scores inside the file.
   *   line - String - Used to check how many scores are in the file.
   *   input - BufferedReader - Reads content from the file.
   *
   *   Global Variables Used:
   *   totalMoves          |   int[]                       Stores the number of moves for the leaderboard (Stores all moves).
   *   totalNames          |   String[]                    Stores the winners for the leaderboard (Stores all names).
   *   totalMatchups       |   String[]                    Stores the matchups for the leaderboard (Stores all matches).
   *   ----------------------------------------------------------------------------------------------------------------
   *   A while loop is used to ensure that the program will continue without issues if a problem arises.
   *   Another while loop is finds how many lines are in the file
   *
   private void getHighScores ()
   { 
   int numOfScores = -1;
   String line = "";
   BufferedReader input;
   
   while (true)
   {
   try
   {
   input = new BufferedReader (new FileReader (HIGHSCORES_FILE));
   if (!(input.readLine ().equals (header)))
   {
   createNewSaveFile ();
   new Message ("Invalid save file! New file created.", "Error!");
   continue;
   }
   else
   {
   while (line != null)            // Finds how many lines are in the file
   {
   input.readLine ();
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
   createNewSaveFile ();
   new Message ("File doesn't exist! New file created.", "Error!");
   }
   }
   
   try
   {
   input = new BufferedReader (new FileReader (HIGHSCORES_FILE));
   totalMoves = new int [LEADERBOARD_SIZE + numOfScores];
   totalNames = new String [LEADERBOARD_SIZE + numOfScores];
   totalMatchups = new String [LEADERBOARD_SIZE + numOfScores];
   input.readLine ();
   
   for (int i = 0 ; i < numOfScores ; i++)
   {
   totalMatchups [i] = input.readLine ();
   totalNames [i] = input.readLine ();
   line = input.readLine ();
   totalMoves [i] = Integer.parseInt (line);
   }
   input.close ();
   }
   catch (Exception e)                                                 // General Exception in case something in the file is invalid. 
   {
   createNewSaveFile ();
   new Message ("Invalid File Input! New file created.", "Error!");
   }
   sortHighScores (numOfScores);
   }
   
   
   /*   This method is used to sort the high scores inside the file and then the top 10 elements are placed into new
   *   arrays.
   *   ----------------------------------------------------------------------------------------------------------------
   *   Local Variables:
   *   numOfScores - Parameter Passed int - Used to store the number of scores inside the file.
   *   movedScore, movedName, movedMatch - int, String, String - Stores the element in the array to be moved.
   *
   *   Global Variables Used:
   *   totalMoves          |   int[]                       Stores the number of moves for the leaderboard (Stores all moves).
   *   totalNames          |   String[]                    Stores the winners for the leaderboard (Stores all names).
   *   totalMatchups       |   String[]                    Stores the matchups for the leaderboard (Stores all matches).
   *   ----------------------------------------------------------------------------------------------------------------
   *   Two for loops are used to ensure that every element in the array is checked.
   *
   private void sortHighScores (int numOfScores)
   {
   for (int i = 0 ; i < numOfScores ; i++)
   {
   for (int j = i + 1 ; j < numOfScores ; j++)
   {
   int movedScore = 0;
   String movedName = "";
   String movedMatch = "";
   if (totalMoves [i] > totalMoves [j])    // If element is greater than one after it. 
   {
   movedScore = totalMoves [i];        // Store temporary variable
   totalMoves [i] = totalMoves [j];    // Switch the elements
   totalMoves [j] = movedScore;        // i to j and j to i
   
   movedName = totalNames [i];
   totalNames [i] = totalNames [j];
   totalNames [j] = movedName;
   
   movedMatch = totalMatchups [i];
   totalMatchups [i] = totalMatchups [j];
   totalMatchups [j] = movedMatch;
   }
   }
   }
   }
   
   
   /*   This method allows the user to clear the high scores file and the leaderboard.
   *   ----------------------------------------------------------------------------------------------------------------
   *   Local Variables:
   *   clear - char - Used to check if the user wants to clear the file or not.
   *   Global Variables Used: None
   *   ----------------------------------------------------------------------------------------------------------------
   *   No input/logic/loop is used.
   *
   private boolean clearHighScores (char clear)
   {
   if (clear == 'c' || clear == 'C')
   {
   createNewSaveFile ();
   return false;
   }
   return true;
   } */
}