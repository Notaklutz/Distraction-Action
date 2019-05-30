import java.awt.*;
import javax.swing.*;
import java.io.*;
/*
 * @author Kevin Nguyen
 * @version 1 - May 14, 2019
 * <p>
 * This abstract class will be the parent class of any classes that are mostly text-based,
 * with a method to print the title and an abstract method to print text. It extends JPanel.
 * </p>
 */
public abstract class TextOnly extends JPanel
{
  /**
   * The graphics environment of the class.
   */   
  protected GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
  /**
   * The variable that stores an object of the SpringLayout class.
   */   
  protected SpringLayout layout = new SpringLayout();
  /**
   * The custom font for the large letters in the game logo.
   */   
  protected Font bigTitle;
  /**
   * The custom font for the small letters in the game logo.
   */   
  protected Font smallTitle;
  /**
   * The custom font for the buttons in the main menu, level selection, and high score screens.
   */
  protected Font buttonFont;
  /**
   * The font for the high scores and goodbye screens.
   */   
  protected Font highScoresAndGoodbyeFont;
  /**
   * The font for the game's book in level one.
   */   
  protected Font bookFont;
  /**
   * The default font of the game.
   */   
  protected Font defaultFont;
  /**
   * The font for level 1's quiz.
   */   
  protected Font quizFont;
  /**
   * The light grey colour that is used in the game's text.
   */   
  protected final Color LIGHT_GREY = new Color (190, 190, 190); 
  /**
   * The yellow colour that is used in the game's text.
   */   
  protected final Color YELLOW = new Color (255, 205, 0);
  /**
   * The red colour that is used in the game's text.
   */   
  protected final Color RED = new Color (194, 85, 85);   
  /**
   * The JLabel for the big D in the game's logo.
   */   
  protected JLabel bigD = new JLabel();
  /**
   * The JLabel for the regular words in the game's logo.
   */   
  protected JLabel midTitle = new JLabel();
  /**
   * The JLabel for the big N in the game's logo.
   */   
  protected JLabel bigN = new JLabel();
  /**
   * The JLabel for the first part of the footer ("2019 KODIAK").
   */   
  protected JLabel footer1 = new JLabel();
  /**
   * The JLabel for the second part of the footer ("RED").
   */   
  protected JLabel footer2 = new JLabel();
  /**
   * The DistractionAction object that will contain the frame that all of the screens will be displayed on.
   */   
  protected DistractionAction game;
  
  /**
   * This method will initialize the custom fonts that are needed for the game as well as the panel's layout.
   */
  public void initializeFontsAndLayout()
  {
    try
    {
      bigTitle = Font.createFont(Font.TRUETYPE_FONT, new File("Apple.ttf")).deriveFont(Font.BOLD, 80f);
      smallTitle = Font.createFont(Font.TRUETYPE_FONT, new File("Apple.ttf")).deriveFont(Font.BOLD, 47f);
      buttonFont = Font.createFont(Font.TRUETYPE_FONT, new File("Apple.ttf")).deriveFont(Font.BOLD, 40f);
      highScoresAndGoodbyeFont = Font.createFont(Font.TRUETYPE_FONT, new File("Apple.ttf")).deriveFont(30f);
      bookFont = Font.createFont(Font.TRUETYPE_FONT, new File("Apple.ttf")).deriveFont(13f);
      defaultFont = Font.createFont(Font.TRUETYPE_FONT, new File("Apple.ttf")).deriveFont(20f);
      quizFont = Font.createFont(Font.TRUETYPE_FONT, new File("Apple.ttf")).deriveFont(25f);
    }
    catch (IOException|FontFormatException e) 
    {
    } 
    this.setLayout(layout);
  }
  
  /**
   * This method will print the logo of the game, Distraction Action.
   */
  public void printTitle()
  {
    bigD.setFont(bigTitle);
    bigD.setForeground(YELLOW);
    bigD.setText("D");
    layout.putConstraint(SpringLayout.WEST, bigD, 20, SpringLayout.WEST, game.frame);
    layout.putConstraint(SpringLayout.NORTH, bigD, 10, SpringLayout.NORTH, game.frame);
    this.add(bigD);
    
    midTitle.setFont(smallTitle);
    midTitle.setForeground(YELLOW);
    midTitle.setText("ISTRACTION ACTIO");
    layout.putConstraint(SpringLayout.WEST, midTitle, -10, SpringLayout.EAST, bigD);
    layout.putConstraint(SpringLayout.NORTH, midTitle, 10, SpringLayout.NORTH, game.frame);
    this.add(midTitle);
    
    bigN.setFont(bigTitle);
    bigN.setForeground(YELLOW);
    bigN.setText("N");
    layout.putConstraint(SpringLayout.WEST, bigN, -5, SpringLayout.EAST, midTitle);
    layout.putConstraint(SpringLayout.NORTH, bigN, 10, SpringLayout.NORTH, game.frame);
    this.add(bigN);
  }
  
  /**
   * This method will print "2019 KODIAK RED" at the bottom of the screen.
   */
  public void printFooter()
  {
    footer1.setFont(defaultFont);
    footer1.setForeground(LIGHT_GREY);
    footer1.setText("2019 KODIAK");
    layout.putConstraint(SpringLayout.WEST, footer1, 340, SpringLayout.WEST, game.frame);
    layout.putConstraint(SpringLayout.SOUTH, footer1, 750, SpringLayout.NORTH, game.frame);
    this.add(footer1);
    
    footer2.setFont(defaultFont);
    footer2.setForeground(RED);
    footer2.setText("RED");
    layout.putConstraint(SpringLayout.WEST, footer2, 15, SpringLayout.EAST, footer1);
    layout.putConstraint(SpringLayout.SOUTH, footer2, 750, SpringLayout.NORTH, game.frame);
    this.add(footer2);
  }
  
  /**
   * This is a generic print method that will be overriden by TextOnly's subclasses.
   */
  public abstract void printText();
}

