import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * @author Kevin Nguyen
 * @version 1 - May 30, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * This class will display a game where the user will have to match cards with
 * methods to avoid distractions on them. They will have to avoid pressing the cards
 * with the distractions on them more than once. This class extends TextOnly and ActionListener
 * </p>
 */
public class MatchingGame extends TextOnly implements ActionListener
{
  /**
   * This array will be used to store the back of the cards.
   */ 
  private JButton[] backCards = new JButton[12];
  /**
   * This array will be used to store the front of the cards.
   */ 
  private JButton[] faceCards = new JButton[12];
  /**
   * This array will be used to store the images that will be used to create
   * the JButtons which will be the front of the cards.
   */ 
  private ImageIcon[] images = new ImageIcon[12];
  /**
   * This array will be used to store the String identifiers for each of the cards.
   * These Strings will be used to check whether or not two cards match.
   */ 
  private String[] imageIdentifier = new String[] {"Water", "Water", "Music", "Music", 
    "Hourglass", "Hourglass", "Headphones", "Headphones", "NoPhones", "NoPhones", "TextMessage", "SocialMedia"};
  /**
   * This JButton will be used to store the first card that the player selected.
   */ 
  private JButton currentCard1 = null;
  /**
   * This JButton will be used to store the second card that the player selected.
   */ 
  private JButton currentCard2 = null;
  /**
   * This int stores the number of strikes that the player has received.
   */ 
  private int numStrikes;
  /**
   * This int stores the number of matches that the player has made.
   */ 
  private int numMatches;
  /**
   * This JLabel will display the current number of matches that the player has made.
   */ 
  private JLabel matches;
  /**
   * This JLabel will display the current number of strikes that the player has received.
   */ 
  private JLabel strikes;
  /**
   * This JButton will allow the user to play the matching game again.
   */ 
  private JButton tryAgain;
  /**
   * This JButton will allow the user to go to the next level or go back to level selection,
   * depending on whether or not the user is playing a full game.
   */ 
  private JButton nextLevelOrLevelSelection;
  /**
   * This JButton stores the back of the first card selected by the user.
   */ 
  private JButton firstBackCard;
  /**
   * This JButton stores the back of the second card selected by the user.
   */ 
  private JButton secondBackCard;
  /**
   * This MatchingGame variable stores the current MatchingGame object. It is
   * used to access methods of the MatchingGame class in inner classes.
   */ 
  private MatchingGame matchGame;
  /**
   * This int stores the index (in faceCards) of the first card that the player selected.
   */ 
  private int firstCardIndex = 0;
  
  /**
   * This constructor will create a MatchingGame object. It will initialize the fonts and layout of the game, 
   * set the background colour, calls the printText() method, and makes the panel visible.
   *
   * @param d The DistractionAction object that contains the frame that instructions will be displayed on.
   */   
  public MatchingGame(DistractionAction d)
  {
    game = d;
    matchGame = this;
    initializeFontsAndLayout();
    setBackground(DistractionAction.GREY);
    printText();
    setVisible(true);
  }
  
  /**
   * This method will display everything that is needed for the game. It initializes the images array,
   * the backCards array, and the faceCards array. It also randomizes the order of the images array and
   * the imageIdentifier array. It then uses putConstraint() to properly position all of the necessary components
   * and adds them to the panel.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * index                    int                  Stores a random index from 0-11 to randomize the elements of images and imageIdentifier.
   * </pre>
   * </p>
   */ 
  public void printText()
  {
    images[0] = new ImageIcon("Water.png");
    images[1] = new ImageIcon("Water.png");
    images[2] = new ImageIcon("Music.png");
    images[3] = new ImageIcon("Music.png");
    images[4] = new ImageIcon("Hourglass.png");
    images[5] = new ImageIcon("Hourglass.png");
    images[6] = new ImageIcon("Headphones.png");
    images[7] = new ImageIcon("Headphones.png");
    images[8] = new ImageIcon("NoPhones.png");
    images[9] = new ImageIcon("NoPhones.png");
    images[10] = new ImageIcon("TextMessage.png");
    images[11] = new ImageIcon("SocialMedia.png");
    
    matches = new JLabel("Matches: " + numMatches);
    strikes = new JLabel("Strikes: " + numStrikes);
    
    matches.setFont(buttonFont);
    matches.setForeground(Color.WHITE);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, matches, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, matches, 575, SpringLayout.NORTH, game.frame);
    
    strikes.setFont(buttonFont);
    strikes.setForeground(Color.WHITE);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, strikes, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, strikes, 650, SpringLayout.NORTH, game.frame);
    
    add(matches);
    add(strikes);
    
    for (int x = 0; x < images.length; x++)
    {
      int index = (int)(Math.random() * 12);
      
      ImageIcon i = images[index];
      images[index] = images[x];
      images[x] = i;
      
      String s = imageIdentifier[index];
      imageIdentifier[index] = imageIdentifier[x];
      imageIdentifier[x] = s;
    }
    
    for (int x = 0; x < backCards.length; x++)
    {
      backCards[x] = cardCreator(new ImageIcon ("Back.png"));
      backCards[x].setVisible(true);
      backCards[x].addActionListener(this);
      this.add(backCards[x]);
      
      faceCards[x] = cardCreator(images[x]);
      this.add(faceCards[x]);
    }
    
    for (int x = 0; x < 12; x++)
    {
      if (x <= 5)
      {
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, backCards[x], x * 150 - 375, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, backCards[x], 50, SpringLayout.NORTH, game.frame);
        
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, faceCards[x], x * 150 - 375, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, faceCards[x], 50, SpringLayout.NORTH, game.frame);
      }
      else
      {
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, backCards[x], (x - 6) * 150 - 375, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, backCards[x], 300, SpringLayout.NORTH, game.frame);
        
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, faceCards[x], (x - 6) * 150 - 375, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, faceCards[x], 300, SpringLayout.NORTH, game.frame);
      }
    }
  }
  
  /**
   * This method will display the results after the game is finished. It sets all of the elements of the game to invisible,
   * and depending on whether or not the user got less than 3 strikes, displays whether the player won or lost. If the player
   * wins, they are given the option to try again, go to the next level (full game), or return to the level selection (not full game).
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * result                   JLabel               The JLabel that will display whether or not the user won.
   * </pre>
   * </p>
   */ 
  private void printResults() 
  {
    // Screen erase
    for (int a = 0; a < backCards.length; a++)
    {
      backCards[a].setVisible(false);
      faceCards[a].setVisible(false);
    }
    
    matches.setVisible(false);
    strikes.setVisible(false);
    
    JLabel result; 
    
    if (numStrikes < 3)
    {
      result = new JLabel("You won!");
    }
    else
    {
      result = new JLabel("You got 3 strikes! Try again!");
    }
    
    if (numStrikes >= 3)
      result.setFont(choiceFont);
    else
      result.setFont(buttonFont);
    result.setForeground(Color.WHITE);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, result, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, result, 250, SpringLayout.NORTH, game.frame);
    
    tryAgain = resultButtonCreator("Try Again");
    
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, tryAgain, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, tryAgain, 550, SpringLayout.NORTH, game.frame);
    
    if (game.fullGame == true)
      nextLevelOrLevelSelection = resultButtonCreator("Next Level");
    else
      nextLevelOrLevelSelection = resultButtonCreator("Level Selection");
    
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nextLevelOrLevelSelection, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, nextLevelOrLevelSelection, 625, SpringLayout.NORTH, game.frame);
    
    add(tryAgain);
    add(result);
    if (numStrikes < 3)
    {
      add(nextLevelOrLevelSelection);
    }
    
    revalidate();
  }
  
  /**
   * This method will create a JButton which will appear as a card in the game.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * button                   JButton              The JButton that will be used as a card in the game.
   * </pre>
   * </p>
   * 
   * @param image The ImageIcon that will be used to create a new JButton that will act as a card.
   * @return The JButton that will appear as a card in the game.
   */ 
  private JButton cardCreator(ImageIcon image)
  {
    JButton button = new JButton(image);
    button.setFont(buttonFont);
    button.setForeground(Color.WHITE);
    button.setFocusPainted(false);
    button.setMargin(new Insets(0, 0, 0, 0));
    button.setContentAreaFilled(false);
    button.setOpaque(false);
    return button;
  }
  
  /**
   * This method will create a JButton which will be used in the results screen of the game.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * button                   JButton              The JButton that will be used in the results screen.
   * </pre>
   * </p>
   * 
   * @param text The String to be displayed on the button.
   * @return The JButton that will be used in the results screen.
   */
  private JButton resultButtonCreator(String text) 
  {
    JButton button = new JButton(text);
    button.setFont(buttonFont);
    button.setForeground(Color.WHITE);
    button.setFocusPainted(false);
    button.setMargin(new Insets(0, 0, 0, 0));
    button.setContentAreaFilled(false);
    button.setOpaque(false);
    button.addActionListener(this);
    return button;
  }
  
  /**
   * This method will increment numStrikes by one and update the panel to reflect the current number of strikes.
   * It will also hide the distraction cards and set the current card variables to null.
   */
  public void strike()
  {       
    numStrikes++; 
    
    remove(strikes);
    
    strikes = new JLabel("Strikes: " + numStrikes);
    
    strikes.setFont(buttonFont);
    strikes.setForeground(Color.WHITE);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, strikes, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, strikes, 650, SpringLayout.NORTH, game.frame);
    
    add(strikes);
    
    new Thread() 
    {
      public void run() 
      {
        try 
        {
          this.sleep(750);
        } 
        catch (InterruptedException e) 
        {
        }
        firstBackCard.setVisible(true);
        secondBackCard.setVisible(true);
        try
        {
          currentCard1.setVisible(false);
          currentCard2.setVisible(false);
        }
        catch (NullPointerException e)
        {
        }
        
        matchGame.revalidate();
        
        currentCard1 = null;
        currentCard2 = null;
      }
    }.start();
  }
  
  /**
   * This method will add action listeners to all the JButtons in backCards.
   */
  private void actionListenerAdder()
  {
    for (JButton j : backCards)
      j.addActionListener(this);
  }
  
  /**
   * This method will remove action listeners from all the JButtons in backCards.
   */
  private void actionListenerRemover()
  {
    for (JButton j : backCards)
      j.removeActionListener(this);
  }
  
  /**
   * This method will determine whether or not an end condition of the game has been met.
   * 
   * @return Whether or not an end condition of the game has been met.
   */
  private boolean end()
  {
    if (numStrikes >= 3 || numMatches >= 5)
      return true;
    return false;
  }
  
  /**
   * This method will perform different functions depending on the JButton that is pressed. When playing the game,
   * it will add and remove buttons from currentCard1 and currentCard2. It will also check for matching cards as well
   * as distractions. Finally, it will check for the win condition (matches == 5) and invoke the printResults() method.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * x                        int                  An int that will be used to go through each element in backCards and faceCards. It is incremented by one each time the while loop executes.
   * stop                     boolean              A boolean that will act as one of the end conditions of the while loop.
   * </pre>
   * </p>
   * 
   * @param e The ActionEvent that was triggered by a button press.
   */
  public void actionPerformed(ActionEvent e)
  {      
    actionListenerRemover(); // Prevents cards from being selected
    
    if (e.getSource() == tryAgain)
    {
      game.matchingGame(); 
    }
    else if (game.fullGame == false && e.getSource() == nextLevelOrLevelSelection)
    {
      game.levelSelection();
    }
    else if (e.getSource() == nextLevelOrLevelSelection)
    {
      game.instructions(2);
    }
    
    int x = 0;
    boolean stop = false;
    
    while (stop == false && x != 12) // while loop to check each button in backCards to determine where the ActionEvent came from
    {  
      if (currentCard1 == null && e.getSource() == backCards[x]) // checks for empty first card
      { 
        currentCard1 = faceCards[x];
        firstBackCard = backCards[x];
        firstCardIndex = x;
        backCards[x].setVisible(false);
        faceCards[x].setVisible(true);
        revalidate();
        stop = true;
        
        if (imageIdentifier[x].equals("TextMessage") || imageIdentifier[x].equals("SocialMedia")) // Check for distraction
        {          
          strike();
          if (numStrikes == 3)
            break;
        }
      }
      else if (currentCard1 != null && currentCard2 == null && e.getSource() == backCards[x]) // checks for empty second card
      {       
        currentCard2 = faceCards[x];
        secondBackCard = backCards[x];
        secondBackCard.setVisible(false);
        currentCard2.setVisible(true);
        
        revalidate();
        
        if (imageIdentifier[x].equals("TextMessage") || imageIdentifier[x].equals("SocialMedia")) // Check for distraction
        {        
          strike();
          if (numStrikes == 3) // exit while loop if strikes are 3
            break;
        }      
        else if (imageIdentifier[firstCardIndex].equals(imageIdentifier[x])) // Check for match
        {
          numMatches++; 
          
          remove(matches);
          
          matches = new JLabel("Matches: " + numMatches);
          
          matches.setFont(buttonFont);
          matches.setForeground(Color.WHITE);
          layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, matches, 0, SpringLayout.HORIZONTAL_CENTER, this);
          layout.putConstraint(SpringLayout.NORTH, matches, 575, SpringLayout.NORTH, game.frame);
          
          add(matches);
          
          revalidate();
          
          currentCard1 = null;
          currentCard2 = null; 
        }
        else
        {             
          new Thread() // creates 750-millisecond delay before resetting cards
          {
            public void run() 
            {
              try 
              {
                this.sleep(750);
              } 
              catch (InterruptedException e) 
              {
              }
              firstBackCard.setVisible(true);
              secondBackCard.setVisible(true);
              try
              {
                currentCard1.setVisible(false);
                currentCard2.setVisible(false);
              }
              catch (NullPointerException e)
              {
              }
              
              matchGame.revalidate();
              
              currentCard1 = null;
              currentCard2 = null;
            }
          }.start();
        }
      }
      x++;
    }      
    stop = false;
    if (end()) // Checks for win condition
    {    
      new Thread() // Creates one-second delay before printing results
      {
        public void run() 
        {
          try 
          {
            this.sleep(1000);
          } 
          catch (InterruptedException e) 
          {
          }
          matchGame.printResults();
        }
      }.start();
    }
    else // if end conditions have NOT been met
    {
      actionListenerAdder(); // Allows cards to be selected
    }
  }
}