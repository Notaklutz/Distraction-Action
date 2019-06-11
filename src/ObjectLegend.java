import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author Kevin Nguyen
 * @version 2 - June 9, 2019
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 * This class will display the objects in the Dodging Arena along with a brief description of each. It extends Screen.
 * <br>
 * Time Spent: 1 hour
 * </p>
 * <p>
 * <pre>
 * June 8, 2019 - Created and finished ObjectLegend class.
 * June 9, 2019 - Removed KeyListener. Added Key Bindings.
 * </pre>
 * </p>
 */
public class ObjectLegend extends Screen
{
  /**
   * This constructor will create an ObjectLegend object and assign the passed in DistractionAction object to game. It will initialize the custom fonts
   * and initialize the layout of the panel. It will also call the printTitle() method, the printText() method for the correct room,
   * and the printFooter() method. Finally, it will set the panel to visible.
   *
   * @param d The DistractionAction object that contains the frame that ObjectLegend will be displayed on.
   */
  public ObjectLegend(DistractionAction d)
  {
    game = d;
    initializeFontsAndLayout();
    this.setBackground(DistractionAction.GREY);
    printTitle();
    displayLegend();
    printFooter();
    setVisible(true);
  }

  /**
   * This method will display the object legend.
   * <p>
   * <pre>
   * Variable Name            Variable Type        Description
   * legend                   JLabel               The JLabel that will display the object legend image.
   * continueLabel            JLabel               The JLabel that will display "PRESS ENTER TO CONTINUE.".
   * </pre>
   * </p>
   */
  private void displayLegend()
  {
    JLabel legend = new JLabel(new ImageIcon(DistractionAction.class.getClassLoader().getResource("LevelThree/ObjectLegend.png")));
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, legend, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.VERTICAL_CENTER, legend, 300, SpringLayout.VERTICAL_CENTER, game.frame);
    add(legend);
    JLabel continueLabel = new JLabel ("PRESS ENTER TO CONTINUE.");
    continueLabel.setFont (defaultFont);
    continueLabel.setForeground(DARK_RED);
    layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, continueLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
    layout.putConstraint(SpringLayout.NORTH, continueLabel, 610, SpringLayout.SOUTH, game.frame);
    add(continueLabel);

    InputMap input = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    input.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "Continue");
    ActionMap action = this.getActionMap();
    action.put("Continue", new AbstractAction()
            {
              public void actionPerformed(ActionEvent e)
              {
                game.levelThreeGame();
              }
            }
    );
  }
}