import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Ryan Phan
 * @version 6 - June 2, 2019
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 * Creates a damage reduction boost, which decreases the amount of focus lost to
 * distractions. Represented by headphones.
 * </p>
 * <p>
 * <pre>
 * Change Log
 * June 7, 2019 - Created DamageReductionBoost
 * June 8, 2019 - Gave DamageReductionBoost a proper icon and modified hit-box
 * </pre>
 * </p>
 */
public class DamageReductionBoost extends GameObject {
    /**
     * Image used as the boost icon
     */
    private BufferedImage img;

    /**
     * This constructor will call the superclass to DamageReductionBoost to set its x and y-coordinates,
     * and then it will retrieve the image used to represent the boost.
     *
     * @param x  The x-coordinate of the boost
     * @param y  The y-coordinate of the boost
     * @param id Used for identification purposes in other classes used in level three
     */
    public DamageReductionBoost(int x, int y, ID id) {
        super(x, y, id);

        try {
            img = ImageIO.read(DistractionAction.class.getResourceAsStream("LevelThree/headphones.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Needed to be overridden as DamageReductionBoost isn't abstract
     */
    public void tick() {
    }

    /**
     * Retrieves the hit-box of the distraction, to allow for collision detection.
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, 55, 51);
    }

    /**
     * Draws the boost to the screen.
     * @param g Used to draw to the screen
     */
    @Override
    public void paintComponent(Graphics2D g) {
        g.drawImage(img, x, y, null);
    }
}
