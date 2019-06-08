import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
/**
 * @author Ryan Phan
 * @version ??? - June 6, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * Creates the blueprints for a focus boost, which takes the form of a water bottle and 
 * regenerates the user's health.
 * MORE TO BE ADDED
 * </p>
 */

/**
 * Change Log
 * June 4, 2019 - Created FocusBoost
 */ 
public class FocusBoost extends GameObject {
   /**
    * PLACEHOLDER
    */
    Handler handler;
   /**
    * PLACEHOLDER
    */
    private BufferedImage img;

   /**
    * PLACEHOLDER
    */
    public FocusBoost(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        try {
            img = ImageIO.read( new File("water-bottle.png" ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /**
    * PLACEHOLDER
    */
    public Rectangle getBounds(){
        return new Rectangle(x + 10, y + 10, 30, 40);
    }

   /**
    * PLACEHOLDER
    */
    @Override
    public void tick() {
    }

   /**
    * PLACEHOLDER
    */
    @Override
    public void paintComponent(Graphics2D g) {
        g.setColor(Color.RED);
        g.draw(getBounds());
        g.drawImage( img, x, y, null );
    }
}