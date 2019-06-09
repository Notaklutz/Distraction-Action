import java.awt.*;
import java.io.File;
import java.io.IOException;
/**
 * @author Ryan Phan
 * @version 2 - June 2, 2019
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 * Displays UI elements and stores the status of the player (Focus levels, documents, etc.)
 * </p>
 */

/**
 * Change Log
 * June 2, 2019 - Created PlayerStatus
 * June 3, 2019 - Added functionality to Documents counter
 */ 
public class PlayerStatus {
   /**
    * Stores the player's "focus" levels or health level
    */
    public static int FOCUS = 100;
    /**
     * Stores how many documents the player collected
     */
    public static int DOCUMENTS = 0;
    /**
     * Stores the amount of time until next wave of objects will spawn
     */
    public static int TIMETILLSPAWN = 275;
   /**
    * Font used in the UI elements
    */
    private Font statusFont;
   /**
    * Stores how long the user has been alive
    */
    private int timeAlive = 0;
   /**
    * Stores the seconds the player has been alive
    * (Not proper seconds, used to more easily gauge when things should spawn)
    */
    private int seconds = 0;

   /**
    * Updates the timeAlive and keeps the health bar from going too low.
    */
    public void tick(){
        timeAlive++;
        FOCUS = LevelThreeGame.clamp(FOCUS, 0, 100);
    }

    /**
     * Gets the seconds alive
     * @return seconds
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Sets the time till spawn in seconds
     * @param secondsTillSpawn seconds until next spawn wave
     */
    public void setSeconds(int secondsTillSpawn) {
        this.seconds = secondsTillSpawn;
    }

   /**
    * Initializes the font used
    */
   private void initFont(){
        try {
            statusFont = Font.createFont(Font.TRUETYPE_FONT, new File("Apple.ttf")).deriveFont(25f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /**
    * Used to reset the states when the level ends
    */
    public void resetStats()
    {
        FOCUS = 100;
        DOCUMENTS = 0;
        TIMETILLSPAWN = 275;
    }
	
   /**
    * Draws the UI elements
    * @param g Used to draw to the screen
    */
    public void paintComponent(Graphics g){
        // UI Labels
        initFont();
        g.setColor(Color.WHITE);
        g.setFont(statusFont);
        g.drawString("Focus: ", 25, 50);
        g.drawString("Documents: " + DOCUMENTS + "/10", 575, 50);
        // BORDER
        g.setColor(Color.BLACK);
        g.fillRect(175, 20, 306, 40);
        // Distraction
        g.setColor(new Color(199, 0, 50));
        g.fillRect(178, 23, 300, 34);
        // FOCUS
        g.setColor(new Color(0, 200, 200));
        g.fillRect(178, 23, FOCUS * 3, 34);

    }
}
