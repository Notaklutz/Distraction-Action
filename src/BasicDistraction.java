import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Ryan Phan
 * @version 6 - June 2, 2019
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 * Creates the blueprints for a distraction, which takes the form of several random
 * distractions and decreases the user's focus bar.
 * </p>
 */

/**
 * Change Log
 * June 2, 2019 - Created BasicDistraction
 * June 4, 2019 - Added Facebook logo as icon
 * June 6, 2019 - Changed render() into paintComponent().
 * June 8, 2019 - Removed original facebook logo and added several new
 *                icons.
 */

public class BasicDistraction extends GameObject {
    /**
     * Stores the images used for the distraction sprites
     * (Icons made by Freepik from www.flaticon.com )
     */
    private ArrayList<BufferedImage> distractions = new ArrayList<BufferedImage>();


    /**
     * This constructor will call initSprites to retrieve and add images into distractions. In order
     * to ensure that a random icon is shown, shuffle() is used to shift the array around. The
     * initial velocity of the Distraction is also set here.
     *
     * @param x The x-coordinate of the distraction
     * @param y The y-coordinate of the distraction
     * @param id Used for identification purposes in other classes used in level three
     */
    public BasicDistraction(int x, int y, ID id) {
        super(x, y, id);

        // Initializes the sprites and shuffles them around
        initSprites();
        shuffle();

        // Randomizes the initial velocity to keep game play interesting
        Random r = new Random();
        velX = r.nextInt(8) + 2;
        velY = r.nextInt(8) + 2;
    }

    /**
     * This method will retrieve and initialize the sprites used to represent distractions in the game.
     * Afterwards, these icons are added to the distractions array.
     * <p>
     * <pre>
     * Variable Name            Variable Type        Description
     * index                    int                  Stores a random index from 0-11 to randomize the elements of images and imageIdentifier.
     * </pre>
     * </p>
     */
    public void initSprites() {
        File facebook = new File(System.getProperty("user.dir") + "\\Resources\\LevelThree\\facebook.png");
        File twitter = new File(System.getProperty("user.dir") + "\\Resources\\LevelThree\\twitter.png");
        File email = new File(System.getProperty("user.dir") + "\\Resources\\LevelThree\\email.png");
        File notification = new File(System.getProperty("user.dir") + "\\Resources\\LevelThree\\notification.png");
        File speaker = new File(System.getProperty("user.dir") + "\\Resources\\LevelThree\\speaker.png");
        try {
            distractions.add(ImageIO.read(facebook));
            distractions.add(ImageIO.read(twitter));
            distractions.add(ImageIO.read(email));
            distractions.add(ImageIO.read(notification));
            distractions.add(ImageIO.read(speaker));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the hit-box of the distraction, to allow for collision detection.
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, 48, 48);
    }

    /**
     * Used to move the object around the screen, bouncing whenever it hits the edge of the frame.
     */
    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= DistractionAction.HEIGHT - 75) {
            velY *= -1;
        }
        if (x <= 0 || x >= DistractionAction.WIDTH - 52) {
            velX *= -1;
        }
    }

    /**
     * Randomly permutes the icons in the distractions ArrayList to ensure a random icon
     * is displayed every time a distraction spawns.
     */
    private void shuffle() {
        for (int k = distractions.size() - 1; k > 0; k--) {
            int howMany = k + 1;
            int start = 0;
            int randPos = (int) (Math.random() * howMany) + start;
            BufferedImage temp = distractions.get(k);
            distractions.set(k, distractions.get(randPos));
            distractions.set(randPos, temp);
        }
    }


    /**
     * Draws the distraction to the screen.
     * @param g Used to draw to the screen
     */
    @Override
    public void paintComponent(Graphics2D g) {
        g.drawImage(distractions.get(0), x, y, null);
    }
}
