import java.awt.*;
import javax.swing.*;
import java.io.*;
/*
 @author Kevin Nguyen
 @version 1 - May 14, 2019
 <p>
 This class will thank the user for playing the game.
 </p>
 */
public class HighScores extends TextOnly
{
  /**
   * This constructor will create a HighScores object. It will initialize the custom fonts 
   * and register them to the Graphics environment as well as initialize the layout of the panel.
   * It will also call the printTitle() method, the printText() method, and the printFooter() method.
   */   
  public HighScores()
  {
    initializeFontsAndLayout();
    ge.registerFont (bigTitle);
    ge.registerFont (smallTitle);
    ge.registerFont (defaultFont);
    printTitle();
    printText();
    printFooter();
    this.setBackground(grey);
    this.setVisible(true);
  }
  
  /**
   * This method will print a goodbye message to the user.
   */   
  public void printText()
  {
    JLabel goodbye = new JLabel ("GOODBYE!", JLabel.CENTER); 
    goodbye.setFont (defaultFont);
    goodbye.setForeground(Color.white);
    layout.putConstraint(SpringLayout.WEST, goodbye, 400, SpringLayout.WEST, DistractionAction.frame);
    layout.putConstraint(SpringLayout.NORTH, goodbye, 70, SpringLayout.NORTH, DistractionAction.frame);
    this.add(goodbye);
    JLabel thank = new JLabel ("THANK YOU FOR PLAYING", JLabel.CENTER);
    thank.setFont (defaultFont);
    thank.setForeground(Color.white);
    layout.putConstraint(SpringLayout.WEST, thank, 250, SpringLayout.WEST, DistractionAction.frame);
    layout.putConstraint(SpringLayout.NORTH, thank, 100, SpringLayout.SOUTH, goodbye);
    this.add(thank);
    JLabel learned = new JLabel ("WE HOPE YOU LEARNED SOMETHING", JLabel.CENTER);
    learned.setFont (defaultFont);
    learned.setForeground(Color.white);
    layout.putConstraint(SpringLayout.WEST, learned, 200, SpringLayout.WEST, DistractionAction.frame);
    layout.putConstraint(SpringLayout.NORTH, learned, 50, SpringLayout.SOUTH, thank);
    this.add(learned);
    JLabel play = new JLabel ("PLAY AGAIN ANYTIME!", JLabel.CENTER);
    play.setFont (defaultFont);
    play.setForeground(Color.white);
    layout.putConstraint(SpringLayout.WEST, play, 280, SpringLayout.WEST, DistractionAction.frame);
    layout.putConstraint(SpringLayout.NORTH, play, 50, SpringLayout.SOUTH, learned);
    this.add(play);
  }
  
  /*   This method is used to create a new save file in the event that there isn't one or the header is incorrect.
   *   ----------------------------------------------------------------------------------------------------------------
   *   Local Variables: output - PrintWriter - Used to output the header and make a new file.
   *   Global Variables Used: None
   *   ----------------------------------------------------------------------------------------------------------------
   *   No input/logic/loop is used.
   */
  private void createNewSaveFile ()
  {
    try
    {
      PrintWriter output = new PrintWriter (new FileWriter (HIGHSCORES_FILE));
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
   */
  private void writeHighScores (String winnerName, int numOfMoves, String loserName)
  {
    while (true)
    {
      try
      {
        BufferedReader input = new BufferedReader (new FileReader (HIGHSCORES_FILE));
        if (!(input.readLine ().equals (header)))
        {
          createNewSaveFile ();
          new Message ("Invalid save file! New file created.", "Error!");
        }
        PrintWriter output = new PrintWriter (new FileWriter (HIGHSCORES_FILE, true));
        output.println (winnerName + " v. " + loserName);
        output.println (winnerName);
        output.println (numOfMoves);
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
   */
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
   */
  private boolean clearHighScores (char clear)
  {
    if (clear == 'c' || clear == 'C')
    {
      createNewSaveFile ();
      return false;
    }
    return true;
  } 
}