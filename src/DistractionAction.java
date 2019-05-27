import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
/**
 * @author Kevin Nguyen
 * @version 1 - May 14, 2019
 * <p>
 * Temp driver class
 * </p>
 */
public class DistractionAction
{
  public JFrame frame = new JFrame("Distraction Action");
  
  private MainMenu mainMenuScreen;
  
  private DeficienciesRoom deficienciesScreen;
  
  private PanicRoom panicScreen;
  
  private EscapeRoom escapeScreen;
  
  private LevelSelection levelSelectionScreen;
  
  private HighScores highScoresScreen;
  
  private Instructions deficienciesInstructionsScreen;
  
  private Instructions panicInstructionsScreen;
  
  private Instructions escapeInstructionsScreen;
  
  private Instructions generalInstructionsScreen;
  
  private Goodbye goodbyeScreen;
  
  public static final Color GREY = new Color (64, 64, 64);
  
  public boolean fullGame;
  
  public DistractionAction()
  {
    mainMenuScreen = new MainMenu(this);
    deficienciesInstructionsScreen = new Instructions(this, 0);
    panicInstructionsScreen = new Instructions(this, 1);
    escapeInstructionsScreen = new Instructions(this, 2);
    generalInstructionsScreen = new Instructions(this, 3);
    deficienciesScreen = new DeficienciesRoom(this);
    panicScreen = new PanicRoom(this);
    escapeScreen = new EscapeRoom(this);
    levelSelectionScreen = new LevelSelection(this);
    goodbyeScreen = new Goodbye(this);
    frame.setSize(1000, 800);
    frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setContentPane(mainMenuScreen);
    frame.setVisible(true);
  }
  
  public void mainMenu()
  {
    frame.setContentPane(mainMenuScreen);
    mainMenuScreen.updateUI();
  }
  
  public void deficienciesRoom()
  {
    frame.setContentPane(deficienciesScreen);
    deficienciesScreen.updateUI();
    instructions(0);
  }
  
  public void panicRoom()
  {
    frame.setContentPane(panicScreen);
    panicScreen.updateUI();
    instructions(1);
  }
  
  public void escapeRoom()
  {
    frame.setContentPane(escapeScreen);
    escapeScreen.updateUI();
    instructions(2);
  }
  
  public void levelSelection()
  {
    frame.setContentPane(levelSelectionScreen);
    levelSelectionScreen.updateUI();
  }
  
  public void highScores()
  {
    highScoresScreen = new HighScores(this);
    frame.setContentPane(highScoresScreen);
    highScoresScreen.updateUI();
  }
  
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
  
  public void goodbye()
  {
    frame.setContentPane(goodbyeScreen);
    goodbyeScreen.updateUI();
    closeWindow(3250);
  }
  
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
  
  public static void main (String[] args)
  {
    new DistractionAction();
  }
}