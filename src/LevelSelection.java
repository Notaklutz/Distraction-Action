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
 *  Displays the level selection menu of the game.
 * </p>
 */
public class LevelSelection extends TextOnly implements ActionListener {
  /**
   * Stores the amount of buttons in the level selection menu. Used for spacing purposes.
   */
  private int btnCount;
  /**
   * The various buttons of the level selection menu
   */
  private JButton lvl1, lvl2, lvl3, menuBtn;

  /**
   * <p>
   * This constructor creates the menu by initializing the fonts and layout of the
   * panel. Afterward, it prints the title, the buttons, and the footer of the panel.
   * It also sets the background to grey and the panel visibility to true.
   * </p>
   *
   * @param d The game frame
   */
  public LevelSelection(DistractionAction d) {
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
   * Adds the buttons to the level selection panel.
   * </p>
   */
  public void printText() {
    lvl1 = buttonCreator("LEVEL 1: DEFICIENCIES");
    lvl2 = buttonCreator("LEVEL 2: PANIC");
    lvl3 = buttonCreator("LEVEL 3: ESCAPE");
    menuBtn = buttonCreator("MAIN MENU");
    
    this.add(lvl1);
    this.add(lvl2);
    this.add(lvl3);
    this.add(menuBtn);
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
  private JButton buttonCreator(String text) {
    JButton button = new JButton(text);
    btnCount++;
    button.setFont(buttonFont);
    button.setForeground(Color.white);
    button.setFocusPainted(false);
    button.setMargin(new Insets(0, 0, 0, 0));
    button.setContentAreaFilled(false);
    button.setOpaque(false);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, button, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, button, btnCount * 140, SpringLayout.NORTH, game.frame);
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
    game.fullGame = false;
    if (e.getSource() == lvl1) {
      game.instructions(0);
    } else if (e.getSource() == lvl2) {
      game.instructions(1);
    } else if (e.getSource() == lvl3) {
      game.instructions(2);
    } else if (e.getSource() == menuBtn) {
      game.mainMenu();
    }
    
  }
}
