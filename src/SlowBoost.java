import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
/**
 * @author Ryan Phan
 * @version 1 - June 6, 2019
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 * Creates the blueprints for a slow boost, which takes the form of a hourglass and
 * slows down the distraction speeds.
 * </p>
 */

/**
 * Change Log
 * June 8, 2019 - Created SlowBoost
 */
public class SlowBoost extends GameObject {
    /**
     * Image used as the boost icon
     */
    private BufferedImage img;

    /**
     * This constructor will call the superclass to SlowBoost to set its x and y-coordinates,
     * and then it will retrieve the image used to represent the boost.
     *
     * @param x The x-coordinate of the boost
     * @param y The y-coordinate of the boost
     * @param id Used for identification purposes in other classes used in level three
     */
    public SlowBoost(int x, int y, ID id) {
        super(x, y, id);
        File hourglass = new File(System.getProperty("user.dir") + "\\Resources\\LevelThree\\hourglass.png");

        try {
            img = ImageIO.read(hourglass);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Retrieves the hit-box of the distraction, to allow for collision detection.
     */
    public Rectangle getBounds(){
        return new Rectangle(x, y, 48, 55);
    }

    /**
     * Needed to be overridden as FocusBoost isn't abstract
     */
    @Override
    public void tick() {
    }

    /**
     * Draws the boost to the screen.
     * @param g Used to draw to the screen
     */
    @Override
    public void paintComponent(Graphics2D g) {
        g.drawImage( img, x, y, null );
    }
}