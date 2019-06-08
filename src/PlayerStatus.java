import java.awt.*;
import java.io.File;
import java.io.IOException;
/**
 * @author Ryan Phan
 * @version ??? - June 6, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * MORE TO BE ADDED
 * </p>
 */

/**
 * Change Log
 * June 2, 2019 - Created PlayerStatus
 */ 
public class PlayerStatus {
   /**
    * PLACEHOLDER
    */
    public static int FOCUS = 100;
   /**
    * PLACEHOLDER
    */
    private Font statusFont;
   /**
    * PLACEHOLDER
    */
    public static int DOCUMENTS = 0;
   /**
    * PLACEHOLDER
    */
    private int timeAlive = 0;
   /**
    * PLACEHOLDER
    */
    public static int TIMETILLSPAWN = 275;
   /**
    * PLACEHOLDER
    */
    private int seconds = 0;

   /**
    * PLACEHOLDER
    */
    public void tick(){
        timeAlive++;
        FOCUS = LevelThreeGame.clamp(FOCUS, 0, 100);
    }

   /**
    * PLACEHOLDER
    */
    public int getSeconds() {
        return seconds;
    }

   /**
    * PLACEHOLDER
    */
    public void setSeconds(int secondsTillSpawn) {
        this.seconds = secondsTillSpawn;
    }

   /**
    * PLACEHOLDER
    */
    public void initFont(){
        try {
            statusFont = Font.createFont(Font.TRUETYPE_FONT, new File("Apple.ttf")).deriveFont(25f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /**
    * PLACEHOLDER
    */
    public void resetStats()
    {
        FOCUS = 100;
        DOCUMENTS = 0;
        TIMETILLSPAWN = 275;
    }
	
   /**
    * PLACEHOLDER
    */
    public void paintComponent(Graphics g){
        initFont();
        g.setColor(Color.WHITE);
        g.drawString("Timer: " + timeAlive, 50, 100);
        g.drawString("Seconds: " + seconds, 50, 125);
        g.setFont(statusFont);
        g.drawString("Focus: ", 25, 50);
        g.drawString("Documents: " + DOCUMENTS + "/10", 575, 50);
        // BORDER
        g.setColor(Color.BLACK);
        g.fillRect(175, 20, 306, 40);
        // Distraction
        g.setColor(Color.RED);
        g.fillRect(178, 23, 300, 34);
        // FOCUS
        g.setColor(Color.BLUE);
        g.fillRect(178, 23, FOCUS * 3, 34);

    }
}
