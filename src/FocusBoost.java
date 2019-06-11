import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Ryan Phan
 * @version 3 - June 6, 2019
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 * Creates the blueprints for a focus boost, which takes the form of a water bottle and
 * regenerates the user's focus by 50%.
 * </p>
 * <p>
 * <pre>
 * Change Log
 * June 4, 2019 - Created FocusBoost
 * June 6, 2019 - Gave FocusBoost a new icon
 * June 8, 2019 - Changed FocusBoost icon to better match the rest of the icons
 *                and modified hit-box accordingly
 * </pre>
 * </p>
 */
class FocusBoost extends GameObject {
    /**
     * Image used as the boost icon
     */
    private BufferedImage img;

    /**
     * This constructor will call the superclass to FocusBoost to set its x and y-coordinates,
     * and then it will retrieve the image used to represent the boost.
     *
     * @param x The x-coordinate of the boost
     * @param y The y-coordinate of the boost
     * @param id Used for identification purposes in other classes used in level three
     */
    public FocusBoost(int x, int y, ID id) {
        super(x, y, id);

        try {
            img = ImageIO.read(DistractionAction.class.getResourceAsStream("LevelThree/water-bottle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Retrieves the hit-box of the distraction, to allow for collision detection.
     */
    public Rectangle getBounds() {
        return new Rectangle(x + 10, y + 5, 35, 45);
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
        g.drawImage(img, x, y, null);
    }
}