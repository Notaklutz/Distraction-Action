import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main Menu of Distraction Action
 */
public class MainMenu extends TextOnly
  implements ActionListener {
  private int btnCount;
  
  private JButton start;
  private JButton selectLvl;
  private JButton tutorial;
  private JButton highScores;
  private JButton exit;
  
  /**
   *
   */
  public MainMenu(DistractionAction d) 
  {
    game = d;
    initializeFontsAndLayout();
    ge.registerFont(bigTitle);
    ge.registerFont(smallTitle);
    ge.registerFont(defaultFont);
    printTitle();
    printText();
    printFooter();
    this.setBackground(DistractionAction.GREY);
    this.setVisible(true);
  }
  
  public void printText() {
    start = buttonCreator("START GAME");
    selectLvl = buttonCreator("SELECT LEVEL");
    tutorial = buttonCreator("TUTORIAL");
    highScores = buttonCreator("HIGH SCORES");
    exit = buttonCreator("EXIT");
    
    this.add(start);
    this.add(selectLvl);
    this.add(tutorial);
    this.add(highScores);
    this.add(exit);
  }
  
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
   * @param e
   */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == start) {
      game.deficienciesRoom();
    } else if (e.getSource() == selectLvl) {
      game.levelSelection();
    } else if (e.getSource() == tutorial) {
      System.out.println("Tutorial");
    } else if (e.getSource() == highScores) {
      game.highScores();
    } else if (e.getSource() == exit) {
      game.goodbye();
    }
  }
}