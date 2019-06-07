import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
/**
 * @author Ryan Phan
 * @version ??? - June 6, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * Creates the blueprints for a distraction, which takes the form of several random 
 * distractions and dimisihes the user's focus bar.
 * MORE TO BE ADDED
 * </p>
 */

/**
 * Change Log
 * June 2, 2019 - Created BasicDistraction
 */ 
public class BasicDistraction extends GameObject {
    Handler handler;
    Random r = new Random();
    private ArrayList<BufferedImage> distractions = new ArrayList<BufferedImage>();

    public BasicDistraction(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        try {
            distractions.add(ImageIO.read( new File("facebook.png" )));
        } catch (IOException e) {
            e.printStackTrace();
        }


        velX = r.nextInt(7) + 1;
        velY = r.nextInt(7) + 1;
        this.handler = handler;
    }
    
    public Rectangle getBounds(){
      return new Rectangle(x, y, 32, 32);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        // TO BE REPLACED WITH WIDTH AND HEIGHT
        if (y <= 0 || y >= 800 - 50){
            velY *= -1;
        }
        if (x <= 0 || x >= 1000 - 25){
            velX *= -1;
        }
    }


    @Override
    public void paintComponent(Graphics2D g) {
        g.setColor(Color.RED);
        g.draw(getBounds());
        g.drawImage( distractions.get(r.nextInt(distractions.size())), x, y, null );
    }
}
