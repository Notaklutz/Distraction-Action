import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Ryan Phan
 * @version 1 14.04.19
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 *  Displays Distractions 101, a book that teaches the user about various
 *  distractions and some ways to avoid them.
 * </p>
 */
public class LevelOneBook extends Screen implements ActionListener {
  /**
   *  The background image of the panel. Displays a library setting. 
   */   
  private JLabel background = new JLabel(new ImageIcon(getClass().getResource("\\Pictures\\Library.jpg")));
  /**
   *  The book to be displayed. Labeled Distactions 101, and is empty. Will be filled though the use
   *  of JLabels.
   */
  private JLabel book = new JLabel(new ImageIcon(getClass().getResource("\\Pictures\\Book.png")));
  /**
   * Used to check what button was pressed. True would mean next page was pressed and false means last page
   * was pressed.
   */
  private boolean nextPressed;
  /**
   * Button used to advance the page. 
   */
  private JButton next;
  /**
   * Button used to go back a page.
   */
  private JButton last;
  /**
   * Stores the current page the user is viewing
   */
  private int currentPage = 2;
  /**
   * Stores the lines of text to be displayed in the book.
   */
  private JLabel[][] lines = new JLabel[6][9];
  
  /**
   * <p>
   * This constructor will create a LevelOneBook object. It will initialize the custom fonts
   * and initialize the layout of the panel. printText() is called to output text to the current
   * page of the book. updatePages() updates the JLabels being displayed to the book.
   * </p>
   *
   * @param d The game frame
   */
  public LevelOneBook(DistractionAction d) {
    game = d;
    initializeFontsAndLayout();
    setLayout(layout);
    printText();
    updatePages();
    displayBook();
    add(background);
    setVisible(true);
  }
  
 /**
  * <p>
  * This adds the book and the arrows used to turn the pages.
  * </p>
  */
  private void displayBook() {
    add(book);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, book, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, book, 50, SpringLayout.NORTH, this);
    
    last = buttonCreator("<");
    layout.putConstraint(SpringLayout.WEST, last, 275, SpringLayout.WEST, this);
    next = buttonCreator(">");
    layout.putConstraint(SpringLayout.WEST, next,675, SpringLayout.WEST, this);
    add(next);
    add(last);
  }

  /**
   * <p>
   * Used to create the buttons used to turn the page.
   * </p>
   *
   * @param text The string to be displayed on the button.
   * @return The created button.
   *
   */
  private JButton buttonCreator(String text) {
    JButton button = new JButton(text);
    button.setFont(buttonFont);
    button.setForeground(Color.white);
    button.setFocusPainted(false);
    button.setMargin(new Insets(0, 0, 0, 0));
    button.setContentAreaFilled(false);
    button.setOpaque(false);
    layout.putConstraint(SpringLayout.NORTH, button, 700, SpringLayout.NORTH, game.frame);
    button.addActionListener(this);
    return button;
  }
  
 /**
  * <p>
  * Initializes the JLabels containing each line of text inside the book.
  * </p>
  */
  public void printText() {
    lines[0][0] = new JLabel("In today's day and age,");
    lines[0][1] = new JLabel("social media is a major");
    lines[0][2] = new JLabel("distraction for students.");
    lines[0][3] = new JLabel("Avoid these distractions");
    lines[0][4] = new JLabel("by turning off your phones");
    lines[0][5] = new JLabel("and putting them in another");
    lines[0][6] = new JLabel("room.");
    
    lines[1][0] = new JLabel("Feeling musical? Be careful");
    lines[1][1] = new JLabel("what you listen to while");
    lines[1][2] = new JLabel("studying! Music with lyrics");
    lines[1][3] = new JLabel("can actually be distracting.");
    lines[1][4] = new JLabel("Try listening to music");
    lines[1][5] = new JLabel("without lyrics instead!");
    lines[1][6] = new JLabel("It's been proven to improve");
    lines[1][7] = new JLabel("information retention.");
    
    lines[2][0] = new JLabel("Are you often bothered by");
    lines[2][1] = new JLabel("your parents, siblings, or");
    lines[2][2] = new JLabel("friends? Try asking them to");
    lines[2][3] = new JLabel("give you a bit of privacy");
    lines[2][4] = new JLabel("whenever you need to study");
    lines[2][5] = new JLabel("or do schoolwork. As much");
    lines[2][6] = new JLabel("as they may tempt you, you");
    lines[2][7] = new JLabel("have to find the strength");
    lines[2][8] = new JLabel("to say no.");
    
    lines[3][0] = new JLabel("Do you cram study sessions?");
    lines[3][1] = new JLabel("Although it may seem");
    lines[3][2] = new JLabel("counterintuitive, taking");
    lines[3][3] = new JLabel("short breaks will keep");
    lines[3][4] = new JLabel("you refreshed and focused.");
    lines[3][5] = new JLabel("After about an hour of hard");
    lines[3][6] = new JLabel("work, take a few minutes");
    lines[3][7] = new JLabel("to use the washroom, grab");
    lines[3][8] = new JLabel("a drink, or talk to someone.");
    
    lines[4][0] = new JLabel("Are you trying to study");
    lines[4][1] = new JLabel("but keep getting distracted");
    lines[4][2] = new JLabel("by external noises or");
    lines[4][3] = new JLabel("movements? Try moving your");
    lines[4][4] = new JLabel("study session somewhere");
    lines[4][5] = new JLabel("else to maintain a sense of");
    lines[4][6] = new JLabel("peace and quiet.");
    
    lines[5][0] = new JLabel("Now it's time for a quiz!");
    
    for (int x = 0; x < lines.length; x++)
    {
      for (JLabel j : lines[x])
      {
        try
        {
          add (j);
          j.setVisible(false); // Ensures they don't all show up at once
          j.setFont(bookFont);
          j.setForeground(Color.BLUE);
        }
        catch (NullPointerException e)
        { 
        }
      }
    }
  }

  /**
   * <p>
   * Updates the book pages every time the button is pressed.
   * </p>
   */
  private void updatePages() {
    for (int x = 0; x < lines.length; x++)
    {
      for (JLabel j : lines[x])
      {
        try
        {
          j.setVisible(false);
        }
        catch (NullPointerException e)
        {        
        }
      }
    }
    
    if (currentPage - 2 == 0)
    {
      for (int x = 0; x < lines[0].length; x++)
      {
        try
        {
          lines[0][x].setVisible(true);
          layout.putConstraint(SpringLayout.NORTH, lines[0][x], x * 50 + 150, SpringLayout.NORTH, game.frame);
          layout.putConstraint(SpringLayout.WEST, lines[0][x], 120, SpringLayout.WEST, this);
        }
        catch (NullPointerException e)
        {           
        }
        try
        {
          lines[1][x].setVisible(true);
          layout.putConstraint(SpringLayout.NORTH, lines[1][x], x * 50 + 100, SpringLayout.NORTH, game.frame);
          layout.putConstraint(SpringLayout.WEST, lines[1][x], 520, SpringLayout.WEST, this);
        }
        catch (NullPointerException e)
        {
        }
      }
    }
    else if (currentPage - 2 == 2)
    {
      for (int x = 0; x < lines[0].length; x++)
      {
        try
        {
          lines[2][x].setVisible(true);
          layout.putConstraint(SpringLayout.NORTH, lines[2][x], x * 50 + 150, SpringLayout.NORTH, game.frame);
          layout.putConstraint(SpringLayout.WEST, lines[2][x], 120, SpringLayout.WEST, this);
        }
        catch (NullPointerException e)
        {
        }
        
        try
        {
          lines[3][x].setVisible(true);
          layout.putConstraint(SpringLayout.NORTH, lines[3][x], x * 50 + 100, SpringLayout.NORTH, game.frame);
          layout.putConstraint(SpringLayout.WEST, lines[3][x], 520, SpringLayout.WEST, this);
        }
        catch (NullPointerException e)
        {
        }
      }
    }
    else if (currentPage - 2 == 4)
    {
      for (int x = 0; x < lines[0].length; x++)
      {
        try
        {
          lines[4][x].setVisible(true);
          layout.putConstraint(SpringLayout.NORTH, lines[4][x], x * 50 + 150, SpringLayout.NORTH, game.frame);
          layout.putConstraint(SpringLayout.WEST, lines[4][x], 120, SpringLayout.WEST, this);
        }
        catch (NullPointerException e)
        {
        }
        try
        {
          lines[5][x].setVisible(true);
          layout.putConstraint(SpringLayout.NORTH, lines[5][x], x * 50 + 100, SpringLayout.NORTH, game.frame);
          layout.putConstraint(SpringLayout.WEST, lines[5][x], 520, SpringLayout.WEST, this);
        }
        catch (NullPointerException e)
        {
        }
      }
    }
  }

  /**
   * <p>
   * Used to perform actions when a button is pressed.
   * </p>
   *
   * @param e The ActionEvent to be processed
   *
   */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == next && currentPage < 6) {
      currentPage+= 2;
      nextPressed = true;
      updatePages();
    }
    else if (e.getSource() == last && currentPage > 2) {
      currentPage-=2;
      nextPressed = false;
      updatePages();
    }
    else if (currentPage == 6)
    {
     game.quiz(); 
    }
  }
}