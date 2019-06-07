import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
/**
 * @author Kevin Nguyen
 * @version 1 - May 14, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * This is the driver class for the Distraction Action game. It runs the entire program.
 * </p>
 */
public class DistractionAction
{
  /**
   * This frame will be used to display the game on.
   */ 
  public JFrame frame = new JFrame("Distraction Action");
  /**
   * Frame Width
   */
  public final int WIDTH = 1000;
  /**
   * Frame Height
   */
  public final int HEIGHT = 800;
  /**
   * The MainMenu object that will display the game's main menu.
   */ 
  private MainMenu mainMenuScreen;
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
   * This LevelThree object will display the arena in level three.
   */
  private LevelThreeGame levelThree;
  /**
   * This LevelSelection object will display the game's level selection screen.
   */ 
  private LevelSelection levelSelectionScreen;
  /**
   * This HighScores object will display the game's high scores.
   */ 
  private HighScores highScoresScreen;
  /**
   * This Instructions object will display the instructions of the deficiencies room.
   */ 
  private Instructions deficienciesInstructionsScreen;
  /**
   * This Instructions object will display the instructions of the panic room.
   */ 
  private Instructions panicInstructionsScreen;
  /**
   * This Instructions object will display the instructions of the escape room.
   */ 
  private Instructions escapeInstructionsScreen;
  /**
   * This Instructions object will display the general instructions of the game.
   */ 
  private Instructions generalInstructionsScreen;
  /**
   * This Instructions object will display the game's goodbye screen.
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
   * This constructor will create a DistractionAction object...
   */ 
  public DistractionAction()
  {
    //new SplashScreen();
    mainMenuScreen = new MainMenu(this);
    //levelThree = new LevelThreeGame(this);
    deficienciesInstructionsScreen = new Instructions(this, 0);
    panicInstructionsScreen = new Instructions(this, 1);
    escapeInstructionsScreen = new Instructions(this, 2);
    generalInstructionsScreen = new Instructions(this, 3);
    levelSelectionScreen = new LevelSelection(this);
    goodbyeScreen = new Goodbye(this);
    frame.setSize(WIDTH, HEIGHT);
    frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    //frame.setContentPane(levelThree);
    levelThreeGame();
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
   * This method will switch the panel to the level selection screen.
   */ 
  public void levelSelection()
  {
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
      frame.setContentPane(deficienciesInstructionsScreen);
      deficienciesInstructionsScreen.updateUI();
      deficienciesInstructionsScreen.setFocusable(true);
      deficienciesInstructionsScreen.requestFocus();
      deficienciesInstructionsScreen.requestFocusInWindow();
    }
    else if (room == 1)
    {
      frame.setContentPane(panicInstructionsScreen);
      panicInstructionsScreen.updateUI();
      panicInstructionsScreen.setFocusable(true);
      panicInstructionsScreen.requestFocus();
      panicInstructionsScreen.requestFocusInWindow();
    }
    else if (room == 2)
    {
      frame.setContentPane(escapeInstructionsScreen);
      escapeInstructionsScreen.updateUI();
      escapeInstructionsScreen.setFocusable(true);
      escapeInstructionsScreen.requestFocus();
      escapeInstructionsScreen.requestFocusInWindow();
    }
    else
    {
      frame.setContentPane(generalInstructionsScreen);
      generalInstructionsScreen.updateUI();
      generalInstructionsScreen.setFocusable(true);
      generalInstructionsScreen.requestFocus();
      generalInstructionsScreen.requestFocusInWindow();
    }
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
   * This is the main method. It will create a DistractionAction object.
   * 
   * @param args The String[] parameter that will receive data from the command line.
   */ 
  public static void main (String[] args)
  {
    new DistractionAction();
  }
}