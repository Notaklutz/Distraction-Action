import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author Kevin Nguyen
 * @version 6 - June 9, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * This class will instruct the user on how to play each room of the game. It also contains a method to print the
 * general instructions of the game. This class extends Screen.
 * <br>
 * Time Spent: 2 hours
 * </p>
 * <p>
 * <pre>
 * Change Log
 * May 19, 2019 - Created Instructions class and overrided printText() method. Code does not compile yet.
 * May 23, 2019 - Used SpringLayout to properly add and space out JLabels to panel. Also made Instructions class
 *                implement KeyListener to move between different screens at the press of a key.
 * May 26, 2019 - Changed constructor to accept an instance of the driver class as a parameter as well as an int
 *                for the specfic room. Added overloaded printText methods (printText(int panic) and printText(String
 *                escape)) for the instructions of different rooms.
 * May 28, 2019 - Added generalInstructions() method.
 * June 2, 2019 - Changed printText() to levelOneInstructions(), printText(int panic) to levelTwoInstructions,
 *                and printText(String escape) to levelThreeInstructions(). Updated encapsulation of methods.
 * June 9, 2019 - Removed KeyListener. Added Key Bindings.
 * </pre>
 * </p>
 */ 
public class Instructions extends Screen
{
  /**
   * This int will be used to determine what version of the Instructions class the object is. 0 is for the deficiencies room,
   * 1 is for the panic room, 2 is for the escape room, and any other int is for the general instructions.
   */ 
  private int room;
  
  /**
   * This constructor will create an Instructions object and assign the passed in parameter to game. It will initialize the custom fonts 
   * and initialize the layout of the panel. It will also call the printTitle() method, the printText() method for the correct room, 
   * and the printFooter() method. Finally, it will configure the input and action maps of the class and set the panel to visible.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * input                    InputMap             The InputMap of the panel.
   * action                   ActionMap            The ActionMap of the panel.
   * </pre>
   *  </p>
   * 
   * @param d The DistractionAction object that contains the frame that instructions will be displayed on.
   * @param room An int parameter that is used to distinguish the correct constructor for the instructions of each room. 0 is for the deficiencies room, 1 is for the panic room, and 2 is for the escape room. Any other int is for the general instructions.
   */   
  public Instructions(DistractionAction d, int room)
  {
    game = d;
    this.room = room;
    initializeFontsAndLayout();
    this.setBackground(DistractionAction.GREY);
    printTitle();
    if (room == 0)
      levelOneInstructions();
    else if (room == 1)
      levelTwoInstructions();
    else if (room == 2)
      levelThreeInstructions();
    else
      generalInstructions();
    printFooter();

    InputMap input = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    input.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "Continue");
    ActionMap action = this.getActionMap();
    action.put("Continue", new AbstractAction()
            {
              public void actionPerformed(ActionEvent e)
              {
                if (room == 0)
                {
                   game.book();
                }
                else if (room == 1)
                {
                  game.matchingGame();
                }
                else if (room == 2)
                {
                 game.objectLegend();
                }
                else
                  game.mainMenu();
                }
              }
    );

    setVisible(true);
  }
  
  /**
   * This method will print the instructions of Quick Quiz.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * quiz                     JLabel               The JLabel that will display "Quick Quiz".
   * line1                    JLabel               The JLabel that will display "In Quick Quiz, you will learn".
   * line2                    JLabel               The JLabel that will display "about common distractions that can occur".
   * line3                    JLabel               The JLabel that will display "when studying. Afterwards, you will take".
   * line4                    JLabel               The JLabel that will display "a quiz to test your knowledge. Simply".
   * line5                    JLabel               The JLabel that will display "click the button corresponding to the".
   * line6                    JLabel               The JLabel that will display "answer of your choice to select it.".
   * line7                    JLabel               The JLabel that will display "PRESS ENTER TO CONTINUE.".
   * </pre>
   * </p>
   */ 
  private void levelOneInstructions()
  {
    JLabel quiz = new JLabel ("Quick Quiz"); 
    quiz.setFont (defaultFont);
    quiz.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, quiz, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, quiz, 90, SpringLayout.NORTH, game.frame);
    this.add(quiz);
    
    JLabel line1 = new JLabel ("In Quick Quiz, you will learn"); 
    line1.setFont (defaultFont);
    line1.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line1, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line1, 150, SpringLayout.SOUTH, game.frame);
    this.add(line1);
    
    JLabel line2 = new JLabel ("about common distractions that can occur");
    line2.setFont (defaultFont);
    line2.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line2, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line2, 50, SpringLayout.SOUTH, line1);
    this.add(line2);
    
    JLabel line3 = new JLabel ("when studying. Afterwards, you will take");
    line3.setFont (defaultFont);
    line3.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line3, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line3, 50, SpringLayout.SOUTH, line2);
    this.add(line3);
    
    JLabel line4 = new JLabel ("a quiz to test your knowledge. Simply");
    line4.setFont (defaultFont);
    line4.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line4, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line4, 50, SpringLayout.SOUTH, line3);
    this.add(line4);
    
    JLabel line5 = new JLabel ("click the button corresponding to the");
    line5.setFont (defaultFont);
    line5.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line5, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line5, 50, SpringLayout.SOUTH, line4);
    this.add(line5);
    
    JLabel line6 = new JLabel ("answer of your choice to select it.");
    line6.setFont (defaultFont);
    line6.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line6, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line6, 50, SpringLayout.SOUTH, line5);
    this.add(line6);
    
    JLabel line7 = new JLabel ("PRESS ENTER TO CONTINUE.");
    line7.setFont (defaultFont);
    line7.setForeground(DARK_RED);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line7, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line7, 50, SpringLayout.SOUTH, line6);
    this.add(line7);
  }
  
  /**
   * This method will print the instructions of Matching Mayhem.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * matching                 JLabel               The JLabel that will display "Matching Mayhem".
   * line1                    JLabel               The JLabel that will display "In Matching Mayhem, you will have to match".
   * line2                    JLabel               The JLabel that will display "cards that have ways to avoid distractions".
   * line3                    JLabel               The JLabel that will display "on them. Be careful though! If you click the".
   * line4                    JLabel               The JLabel that will display "distraction cards more than two times, you lose!".
   * line5                    JLabel               The JLabel that will display "Be sure to remember which cards are where.".
   * line6                    JLabel               The JLabel that will display "PRESS ENTER TO CONTINUE.".
   * </pre>
   * </p>
   */ 
  private void levelTwoInstructions()
  {
    JLabel matching = new JLabel ("Matching Mayhem"); 
    matching.setFont (defaultFont);
    matching.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, matching, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, matching, 90, SpringLayout.NORTH, game.frame);
    this.add(matching);
    
    JLabel line1 = new JLabel ("In Matching Mayhem, you will have to match"); 
    line1.setFont (defaultFont);
    line1.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line1, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line1, 150, SpringLayout.SOUTH, game.frame);
    this.add(line1);
    
    JLabel line2 = new JLabel ("cards that have ways to avoid distractions");
    line2.setFont (defaultFont);
    line2.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line2, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line2, 50, SpringLayout.SOUTH, line1);
    this.add(line2);
    
    JLabel line3 = new JLabel ("on them. Be careful though! If you click the");
    line3.setFont (defaultFont);
    line3.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line3, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line3, 50, SpringLayout.SOUTH, line2);
    this.add(line3);
    
    JLabel line4 = new JLabel ("distraction cards more than two times, you lose!");
    line4.setFont (defaultFont);
    line4.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line4, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line4, 50, SpringLayout.SOUTH, line3);
    this.add(line4);
    
    JLabel line5 = new JLabel ("Be sure to remember which cards are where.");
    line5.setFont (defaultFont);
    line5.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line5, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line5, 50, SpringLayout.SOUTH, line4);
    this.add(line5);
    
    JLabel line6 = new JLabel ("PRESS ENTER TO CONTINUE.");
    line6.setFont (defaultFont);
    line6.setForeground(DARK_RED);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line6, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line6, 50, SpringLayout.SOUTH, line5);
    this.add(line6);
  }
  
  /**
   * This method will print the instructions of Dodging Arena.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * dodge                    JLabel               The JLabel that will display "Dodging Arena".
   * line1                    JLabel               The JLabel that will display "In the Dodging Arena, you will have to apply".
   * line2                    JLabel               The JLabel that will display "your knowledge of distractions and how to".
   * line3                    JLabel               The JLabel that will display "avoid them by using the WASD keys to dodge".
   * line4                    JLabel               The JLabel that will display "incoming distractions while collecting".
   * line5                    JLabel               The JLabel that will display "boosts and data files in order to finish".
   * line6                    JLabel               The JLabel that will display "your essay and get the highest mark possible.".
   * line7                    JLabel               The JLabel that will display "PRESS ENTER TO CONTINUE.".
   * </pre>
   * </p>
   */ 
  private void levelThreeInstructions()
  {
    JLabel dodge = new JLabel ("Dodging Arena"); 
    dodge.setFont (defaultFont);
    dodge.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, dodge, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, dodge, 90, SpringLayout.NORTH, game.frame);
    this.add(dodge);
    
    JLabel line1 = new JLabel ("In the Dodging Arena, you will have to apply"); 
    line1.setFont (defaultFont);
    line1.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line1, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line1, 150, SpringLayout.SOUTH, game.frame);
    this.add(line1);
    
    JLabel line2 = new JLabel ("your knowledge of distractions and how to");
    line2.setFont (defaultFont);
    line2.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line2, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line2, 50, SpringLayout.SOUTH, line1);
    this.add(line2);
    
    JLabel line3 = new JLabel ("avoid them by using the WASD keys to dodge");
    line3.setFont (defaultFont);
    line3.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line3, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line3, 50, SpringLayout.SOUTH, line2);
    this.add(line3);
    
    JLabel line4 = new JLabel ("incoming distractions while collecting");
    line4.setFont (defaultFont);
    line4.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line4, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line4, 50, SpringLayout.SOUTH, line3);
    this.add(line4);
    
    JLabel line5 = new JLabel ("boosts and documents in order to finish");
    line5.setFont (defaultFont);
    line5.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line5, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line5, 50, SpringLayout.SOUTH, line4);
    this.add(line5);
    
    JLabel line6 = new JLabel ("your essay and get the highest mark possible.");
    line6.setFont (defaultFont);
    line6.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line6, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line6, 50, SpringLayout.SOUTH, line5);
    this.add(line6);
    
    JLabel line7 = new JLabel ("PRESS ENTER TO CONTINUE.");
    line7.setFont (defaultFont);
    line7.setForeground(DARK_RED);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line7, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line7, 50, SpringLayout.SOUTH, line6);
    this.add(line7);
  }
  
  /**
   * This method will print the instructions of the Escape Room.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * generalInstructions      JLabel               The JLabel that will display "General Instructions".
   * line1                    JLabel               The JLabel that will display "This game will teach you about common".
   * line2                    JLabel               The JLabel that will display "distractions that can happen when".
   * line3                    JLabel               The JLabel that will display "studying or working on school assignments.".
   * line4                    JLabel               The JLabel that will display "We'll also teach you about how to avoid".
   * line5                    JLabel               The JLabel that will display "these distractions and be successful in school.".
   * line6                    JLabel               The JLabel that will display "This is done over 3 fun levels. Enjoy!".
   * line7                    JLabel               The JLabel that will display "PRESS ENTER TO RETURN TO THE MAIN MENU.".
   * </pre>
   * </p>
   */ 
  private void generalInstructions()
  {
    JLabel generalInstructions = new JLabel ("General Instructions"); 
    generalInstructions.setFont (defaultFont);
    generalInstructions.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, generalInstructions, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, generalInstructions, 90, SpringLayout.NORTH, game.frame);
    this.add(generalInstructions);
    
    JLabel line1 = new JLabel ("This game will teach you about common"); 
    line1.setFont (defaultFont);
    line1.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line1, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line1, 150, SpringLayout.SOUTH, game.frame);
    this.add(line1);
    
    JLabel line2 = new JLabel ("distractions that can happen when");
    line2.setFont (defaultFont);
    line2.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line2, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line2, 50, SpringLayout.SOUTH, line1);
    this.add(line2);
    
    JLabel line3 = new JLabel ("studying or working on school assignments.");
    line3.setFont (defaultFont);
    line3.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line3, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line3, 50, SpringLayout.SOUTH, line2);
    this.add(line3);
    
    JLabel line4 = new JLabel ("We'll also teach you about how to avoid");
    line4.setFont (defaultFont);
    line4.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line4, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line4, 50, SpringLayout.SOUTH, line3);
    this.add(line4);
    
    JLabel line5 = new JLabel ("these distractions and be successful in school.");
    line5.setFont (defaultFont);
    line5.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line5, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line5, 50, SpringLayout.SOUTH, line4);
    this.add(line5);
    
    JLabel line6 = new JLabel ("This is done over 3 fun levels. Enjoy!");
    line6.setFont (defaultFont);
    line6.setForeground(Color.white);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line6, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line6, 50, SpringLayout.SOUTH, line5);
    this.add(line6);
    
    JLabel line7 = new JLabel ("PRESS ENTER TO RETURN TO THE MAIN MENU.");
    line7.setFont (defaultFont);
    line7.setForeground(DARK_RED);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, line7, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, line7, 50, SpringLayout.SOUTH, line6);
    this.add(line7);
  }
}