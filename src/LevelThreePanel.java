import java.awt.*;
import javax.swing.*;
import java.io.*;
/**
 * @author Ryan Phan
 * @version ??? - June 6, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * --------------------------------------------------DEPRECATED - DO NOT USE------------------------------------------------------
 * </p>
 */

/**
 * Change Log
 * June 5, 2019 - Created LevelThreePanel
 */ 
public class LevelThreePanel extends JPanel{
  public LevelThreeGame gameCanvas;
      
  public LevelThreePanel(DistractionAction d){
    gameCanvas = new LevelThreeGame(d);
    setLayout(new FlowLayout());
    setVisible(true);
    add(gameCanvas);
  }
}