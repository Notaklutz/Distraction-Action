import java.awt.*;
import javax.swing.*;
import java.io.*;
/*
@author Kevin Nguyen
@version 1 - May 14, 2019
<p>
This abstract class will be the parent class of any classes that are mostly text-based,
with a method to print the title and an abstract method to print text.
</p>
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
  * The default font of the game.
  */   
  protected Font defaultFont;
 /**
  * The light grey colour that is used in the game's text.
  */   
  protected Color lightGrey = new Color (190, 190, 190); 
 /**
  * The yellow colour that is used in the game's text.
  */   
  protected Color yellow = new Color (255, 205, 0);
 /**
  * The red colour that is used in the game's text.
  */   
  protected Color red = new Color (194, 85, 85);   
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
  * This method will initialize the custom fonts that are needed for the game as well as the panel's layout.
  */
  public void initializeFontsAndLayout()
  {
    try
    {
      bigTitle = Font.createFont(Font.TRUETYPE_FONT, new File("Apple.ttf")).deriveFont(Font.BOLD, 60f);
      smallTitle = Font.createFont(Font.TRUETYPE_FONT, new File("Apple.ttf")).deriveFont(Font.BOLD, 30f);
      defaultFont = Font.createFont(Font.TRUETYPE_FONT, new File("Apple.ttf")).deriveFont(20f);
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
    bigD.setForeground(yellow);
    bigD.setText("D");
    layout.putConstraint(SpringLayout.WEST, bigD, 180, SpringLayout.WEST, DistractionAction.frame);
    layout.putConstraint(SpringLayout.NORTH, bigD, 10, SpringLayout.NORTH, DistractionAction.frame);
    this.add(bigD);
    midTitle.setFont(smallTitle);
    midTitle.setForeground(yellow);
    midTitle.setText("ISTRACTION ACTIO");
    layout.putConstraint(SpringLayout.WEST, midTitle, -10, SpringLayout.EAST, bigD);
    layout.putConstraint(SpringLayout.NORTH, midTitle, 10, SpringLayout.NORTH, DistractionAction.frame);
    this.add(midTitle);
    bigN.setFont(bigTitle);
    bigN.setForeground(yellow);
    bigN.setText("N");
    layout.putConstraint(SpringLayout.WEST, bigN, -5, SpringLayout.EAST, midTitle);
    layout.putConstraint(SpringLayout.NORTH, bigN, 10, SpringLayout.NORTH, DistractionAction.frame);
    this.add(bigN);
  }
  
 /**
  * This method will print "2019 KODIAK RED" at the bottom of the screen.
  */
  public void printFooter()
  {
    footer1.setFont(defaultFont);
    footer1.setForeground(lightGrey);
    footer1.setText("2019 KODIAK");
    layout.putConstraint(SpringLayout.WEST, footer1, 340, SpringLayout.WEST, DistractionAction.frame);
    layout.putConstraint(SpringLayout.SOUTH, footer1, 750, SpringLayout.NORTH, DistractionAction.frame);
    this.add(footer1);
    footer2.setFont(defaultFont);
    footer2.setForeground(red);
    footer2.setText("RED");
    layout.putConstraint(SpringLayout.WEST, footer2, 15, SpringLayout.EAST, footer1);
    layout.putConstraint(SpringLayout.SOUTH, footer2, 750, SpringLayout.NORTH, DistractionAction.frame);
    this.add(footer2);
  }
  
 /**
  * This is a generic print method that will be overriden by TextOnly's subclasses.
  */
  public abstract void printText();
}

