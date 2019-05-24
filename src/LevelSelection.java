import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Lvl Selection Menu of Distraction Action
 */
public class LevelSelection extends TextOnly
  implements ActionListener {
  private int btnCount;
  
  private JButton lvl1;
  private JButton lvl2;
  private JButton lvl3;
  private JButton menuBtn;
  
  /**
   *
   */
  public LevelSelection(DistractionAction d) {
    game = d;
    initializeFontsAndLayout();
    ge.registerFont(bigTitle);
    ge.registerFont(smallTitle);
    ge.registerFont(buttonFont);
    ge.registerFont(defaultFont);
    printTitle();
    printText();
    printFooter();
    this.setBackground(DistractionAction.GREY);
    this.setVisible(true);
  }
  
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
   * @param e
   */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == lvl1) {
      game.deficienciesRoom();
    } else if (e.getSource() == lvl2) {
      game.panicRoom();
    } else if (e.getSource() == lvl3) {
      game.escapeRoom();
    } else if (e.getSource() == menuBtn) {
      game.mainMenu();
    }
    
  }
}
