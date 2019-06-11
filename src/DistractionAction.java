import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author Kevin Nguyen
 * @version 9 - June 9, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * This is the driver class for the Distraction Action game. It runs the entire program.
 * <br>
 * Time Spent: 2 hours
 * </p>
 * <p>
 * <pre>
 * Change Log
 * May 20, 2019 - Created DistractionAction class with JFrame and main method. Code does not compile.
 * May 21, 2019 - Created instance of Goodbye screen and set to work with the JFrame.
 * May 26, 2019 - Created instances of MainMenu, LevelSelection, HighScores, and Instructions to work with
 *                the JFrame. Added a method to close the window after a delay. Added methods to switch between
 *                panels. Added custom class constructor and created an instance of the class in the main method,
 *                rather than doing everything in the main method.
 * May 28, 2019 - Created instances of LevelOneBook and LevelOneQuiz. Added panel switch methods for LevelOneBook 
 *                and LevelOneQuiz.
 * May 30, 2019 - Created instance of MatchingGame. Added panel switch method for MatchingGame.
 * June 2, 2019 - Updated switch panel method for LevelOneBook to focus the panel to allow it to work with KeyListener.
 * June 4, 2019 - Added width and height constants and switch panel method for PlayerNameReceiver. Also added
 *                addScore() method and addToHighScore() method.
 * June 5, 2019 - Created instance of Credits class and created switch panel method for Credits.
 * June 9, 2019 - Created instance of ObjectLegend class and created switch panel method for ObjectLegend.
 * </pre>
 * </p>
 */ 
public class DistractionAction
{
  /**
   * This frame will be used to display the game on.
   */ 
  public JFrame frame;
  /**
   * The width of the frame.
   */ 
  public static final int WIDTH = 1000;
  /**
   * The height of the frame.
   */ 
  public static final int HEIGHT = 800;
  /**
   * The MainMenu object that will display the game's main menu.
   */ 
  private MainMenu mainMenuScreen;
  /**
   * The ReceivePlayerName object that will ask the user to enter their name.
   */ 
  private PlayerNameReceiver playerNameScreen;
  /**
   * This LevelOneBook object will display the book in level one.
   */ 
  private LevelOneBook bookScreen;
  /**
   * This LevelOneQuiz object will display the quiz in level one.
   */ 
  private LevelOneQuiz quizScreen;
  /**
   * This MatchingGame object will display the matching game in level two.
   */ 
  private MatchingGame matchingScreen;
  /**
   * This ObjectLegend object will display the object legend of level three.
   */
  private ObjectLegend legendScreen;
  /**
   * This LevelThree object will display the arena in level three.
   */
  private LevelThreeGame levelThree;
  /**
   * This EndScreen object will display the end screen after a full game.
   */
  private EndScreen end;
  /**
   * This LevelSelection object will display the game's level selection screen.
   */ 
  private LevelSelection levelSelectionScreen;
  /**
   * This HighScores object will display the game's high scores.
   */ 
  private HighScores highScoresScreen;
  /**
   * This Instructions object will display the instructions of the quiz.
   */ 
  private Instructions quizInstructionsScreen;
  /**
   * This Instructions object will display the instructions of the matching game.
   */ 
  private Instructions matchingInstructionsScreen;
  /**
   * This Instructions object will display the instructions of the dodging arena.
   */ 
  private Instructions dodgingInstructionsScreen;
  /**
   * This Instructions object will display the general instructions of the game.
   */ 
  private Instructions generalInstructionsScreen;
  /**
   * This Credits object will display the game's credits screen.
   */ 
  private Credits creditsScreen;
  /**
   * This Goodbye object will display the game's goodbye screen.
   */ 
  private Goodbye goodbyeScreen;
  /**
   * This grey colour for the background of most of the screens.
   */ 
  public static final Color GREY = new Color (64, 64, 64);
  /**
   * Whether or not the player entered a level from the main menu or level selection.
   */ 
  public boolean fullGame;
  /**
   * The player's name.
   */ 
  public String playerName;
  /**
   * The player's score.
   */ 
  public int playerScore;
  
  /**
   * This constructor will create a DistractionAction object. It will create a SplashScreen object and initialize
   * frame, mainMenuScreen, legendScreen, quizInstructionsScreen, matchingInstructionsScreen, dodgingInstructionsScreen, 
   * generalInstructionsScreen, levelSelectionScreen, creditsScreen, and goodbyeScreen. It will set the size of the frame
   * to 1000x800, ensure that the frame will dispose when the 'x' button is pressed on the window, make the frame
   * not resizable, centre the frame, set it's content pane to the main menu, and ensure that the frame is visible.
   */ 
  public DistractionAction()
  {
    new SplashScreen();
    frame = new JFrame("Distraction Action");
    mainMenuScreen = new MainMenu(this);
    legendScreen = new ObjectLegend(this);
    quizInstructionsScreen = new Instructions(this, 0);
    matchingInstructionsScreen = new Instructions(this, 1);
    dodgingInstructionsScreen = new Instructions(this, 2);
    generalInstructionsScreen = new Instructions(this, 3);
    levelSelectionScreen = new LevelSelection(this);
    creditsScreen = new Credits(this);
    goodbyeScreen = new Goodbye(this);
    frame.setSize(WIDTH, HEIGHT);
    frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setContentPane(mainMenuScreen);
    frame.setVisible(true);
  }
  
  /**
   * This method will switch the panel to the main menu screen.
   */ 
  public void mainMenu()
  {
    frame.setContentPane(mainMenuScreen);
    mainMenuScreen.updateUI();
  }
  /**
   * This method will switch the panel to the receive player name screen.
   */ 
  public void receivePlayerName()
  {
    playerNameScreen = new PlayerNameReceiver(this);
    frame.setContentPane(playerNameScreen);
    playerNameScreen.updateUI();
  }
  /**
   * This method will switch the panel to the book in level one.
   */ 
  public void book()
  {
    bookScreen = new LevelOneBook(this);
    frame.setContentPane(bookScreen);
    bookScreen.updateUI();
  }
  /**
   * This method will switch the panel to the quiz in level one.
   */ 
  public void quiz()
  {
    quizScreen = new LevelOneQuiz(this);
    frame.setContentPane(quizScreen);
    quizScreen.updateUI();
  }
  /**
   * This method will switch the panel to the matching game.
   */ 
  public void matchingGame()
  {
    matchingScreen = new MatchingGame(this);
    frame.setContentPane(matchingScreen);
    matchingScreen.updateUI();
  }
  /**
   * This method will switch the panel to the object legend.
   */
  public void objectLegend()
  {
    frame.setContentPane(legendScreen);
    legendScreen.updateUI();
  }
  /**
   * This method will switch the panel to the dodging arena.
   */
  public void levelThreeGame()
  {
    levelThree = new LevelThreeGame(this);
    frame.setContentPane(levelThree);
    levelThree.start();
    levelThree.updateUI();
  }
  /**
   * This method will switch the panel to the end screen.
   */
  public void endScreen()
  {
    end = new EndScreen(this);
    frame.setContentPane(end);
    end.updateUI();
  }
  /**
   * This method will switch the panel to the level selection screen.
   */ 
  public void levelSelection()
  {
    playerScore = 0;
    frame.setContentPane(levelSelectionScreen);
    levelSelectionScreen.updateUI();
  }
  /**
   * This method will switch the panel to the high scores screen.
   */
  public void highScores()
  {
    highScoresScreen = new HighScores(this);
    frame.setContentPane(highScoresScreen);
    highScoresScreen.updateUI();
  }
  
  /**
   * This method will switch the panel to one of the instruction screens.
   * 
   * @param room An int parameter that is used to determine what version of the instructions screen will the panel be switched to.
   */ 
  public void instructions(int room)
  {
    if (room == 0)
    {
      frame.setContentPane(quizInstructionsScreen);
      quizInstructionsScreen.updateUI();
    }
    else if (room == 1)
    {
      frame.setContentPane(matchingInstructionsScreen);
      matchingInstructionsScreen.updateUI();
    }
    else if (room == 2)
    {
      frame.setContentPane(dodgingInstructionsScreen);
      dodgingInstructionsScreen.updateUI();
    }
    else
    {
      frame.setContentPane(generalInstructionsScreen);
      generalInstructionsScreen.updateUI();
    }
  }
  
  /**
   * This method will switch the panel to the credits screen.
   */ 
  public void credits()
  {
    frame.setContentPane(creditsScreen);
    creditsScreen.updateUI();
  }
  
  /**
   * This method will switch the panel to the goodbye screen.
   */ 
  public void goodbye()
  {
    frame.setContentPane(goodbyeScreen);
    goodbyeScreen.updateUI();
    closeWindow(3250);
  }
  /**
   * This method will dispose the frame after a set amount of time.
   * 
   * @param delay How many milliseconds before the frame disposes.
   */ 
  private void closeWindow(int delay)
  {
    ActionListener windowCloser = new ActionListener() 
    {
      public void actionPerformed(ActionEvent evt) 
      {
        frame.dispose(); 
      }
    };
    new Timer(delay, windowCloser).start();
  }
  
  /**
   * This method will add a specific amount to playerScore.
   * 
   * @param score The amount to be added to playerScore.
   */
  public void addScore(int score)
  {
    playerScore += score;
  }
  
  /**
   * This method will add the player's score to the high scores file.
   */ 
  public void addToHighScores()
  {
    highScoresScreen = new HighScores(this);
    highScoresScreen.writeHighScores(playerName, playerScore);
    playerScore = 0;
  }
  
  /**
   * This is the main method. It will create a DistractionAction object.
   * 
   * @param args The String[] parameter that will receive data from the command line.
   */ 
  public static void main (String[] args)
  {
    new DistractionAction();
  }
}