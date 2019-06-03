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
 */
public class MainMenu extends TextOnly implements ActionListener {
  /**
   * Stores the amount of buttons in the main menu. Used for spacing purposes.
   */
  private int btnCount;
  /**
   * The various buttons of the main menu
   */
  private JButton start, selectLvl, instructions, highScores, exit;

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
    exit = buttonCreator("EXIT");
    
    this.add(start);
    this.add(selectLvl);
    this.add(instructions);
    this.add(highScores);
    this.add(exit);
  }

  /**
   * <p>
   * Used to create the main menu's buttons.
   * </p>
   *
   * @param text The string to be displayed on the button.
   * @return The created button.
   *
   */
  private JButton buttonCreator(String text) 
  {
    JButton button = new JButton(text);
    btnCount++;
    button.setFont(buttonFont);
    button.setForeground(Color.white);
    button.setFocusPainted(false);
    button.setMargin(new Insets(0, 0, 0, 0));
    button.setContentAreaFilled(false);
    button.setOpaque(false);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, button, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, button, btnCount * 120, SpringLayout.NORTH, game.frame);
    button.addActionListener(this);
    return button;
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
    if (e.getSource() == start) {
      game.fullGame = true;
      game.instructions(0);
    } else if (e.getSource() == selectLvl) {
      game.levelSelection();
    } else if (e.getSource() == instructions) {
      game.instructions(3);
    } else if (e.getSource() == highScores) {
      game.highScores();
    } else if (e.getSource() == exit) {
      game.goodbye();
    }
  }
}