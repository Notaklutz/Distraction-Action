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

    public static int FOCUS = 100;
    Font statusFont;
    public static int DOCUMENTS = 0;
    private int timeAlive = 0;
    public static int TIMETILLSPAWN = 275;
    private int seconds = 0;

    public void tick(){
        timeAlive++;
        FOCUS = LevelThreeGame.clamp(FOCUS, 0, 100);
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int secondsTillSpawn) {
        this.seconds = secondsTillSpawn;
    }

    public void initFont(){
        try {
            statusFont = Font.createFont(Font.TRUETYPE_FONT, new File("Apple.ttf")).deriveFont(25f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resetStats()
    {
        FOCUS = 100;
        DOCUMENTS = 0;
        TIMETILLSPAWN = 275;
    }
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
