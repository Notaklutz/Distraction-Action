import javax.swing.*;
import java.awt.*;
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
 *  Displays the main menu of the game.
 * </p>
 * Change Log
 * May 14, 2019 - Created MainMenu extending TextOnly
 * June 1, 2019 - Created MainMenu extending NavigationScreen
 * </pre>
 */

public class MainMenu extends NavigationScreen {
  /**
   * Stores the amount of buttons in the main menu. Used for spacing purposes.
   */
  private int btnCount;
  /**
   * The various buttons of the main menu
   */
  private JButton start, selectLvl, instructions, highScores, credits, exit;

  /**
   * <p>
   * This constructor creates the main menu by initializing the fonts and layout of the
   * panel. Afterward, it prints the title, the buttons, and the footer of the panel.
   * It also sets the background to grey and the panel visibility to true.
   * </p>
   *
   * @param d The game frame
   */
  public MainMenu(DistractionAction d) 
  {
    game = d;
    initializeFontsAndLayout();
    spacingValue = 100;
    printTitle();
    printText();
    printFooter();
    this.setBackground(DistractionAction.GREY);
    this.setVisible(true);
  }

  /**
   * <p>
   * Adds the buttons to the main menu panel.
   * </p>
   */
  public void printText() {
    start = buttonCreator("START GAME");
    selectLvl = buttonCreator("SELECT LEVEL");
    instructions = buttonCreator("INSTRUCTIONS");
    highScores = buttonCreator("HIGH SCORES");
    credits = buttonCreator("CREDITS");
    exit = buttonCreator("EXIT");
    
    this.add(start);
    this.add(selectLvl);
    this.add(instructions);
    this.add(highScores);
    this.add(credits);
    this.add(exit);
  }

  /**
   * <p>
   * Used to perform actions when a button is pressed.
   * </p>
   *
   * @param e The ActionEvent to be processed
   */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == start) {
      game.fullGame = true;
      game.receivePlayerName();
    } else if (e.getSource() == selectLvl) {
      game.levelSelection();
    } else if (e.getSource() == instructions) {
      game.instructions(3);
    } else if (e.getSource() == highScores) {
      game.highScores();
    } 
    else if (e.getSource() == credits)
      game.credits();
    else if (e.getSource() == exit) {
      game.goodbye();
    }
  }
}