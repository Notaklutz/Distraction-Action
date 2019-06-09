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
 * Creates the collectible documents that are used to win the game in level three.
 * 10 need to be collected in order to win.
 * </p>
 */

/**
 * Change Log
 * June 4, 2019 - Created Document
 * June 6, 2019 - Changed render() into paintComponent().
 */
public class Document extends GameObject {
    /**
     * Image used as the document icon
     */
    private BufferedImage img;

    /**
     * This constructor will call the superclass to Document to set its x and y-coordinates,
     * and then it will retrieve the image used to represent the document.
     *
     * @param x  The x-coordinate of the document
     * @param y  The y-coordinate of the document
     * @param id Used for identification purposes in other classes used in level three
     */
    public Document(int x, int y, ID id) {
        super(x, y, id);

        try {
            img = ImageIO.read(new File(System.getProperty("user.dir") + "\\Resources\\LevelThree\\document.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the hit-box of the distraction, to allow for collision detection.
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, 60, 62);
    }

    /**
     * Needed to be overridden as DamageReductionBoost isn't abstract
     */
    public void tick() {
    }

    /**
     * Draws the document to the screen.
     *
     * @param g Used to draw to the screen
     */
    public void paintComponent(Graphics2D g) {
        g.drawImage(img, x, y, null);
    }
}
