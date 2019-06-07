import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class FocusBoost extends GameObject {
    Handler handler;
    private BufferedImage img;

    public FocusBoost(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        try {
            img = ImageIO.read( new File("water-bottle.png" ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Rectangle getBounds(){
        return new Rectangle(x + 10, y + 10, 30, 40);
    }

    @Override
    public void tick() {
    }

    @Override
    public void paintComponent(Graphics2D g) {
        g.setColor(Color.RED);
        g.draw(getBounds());
        g.drawImage( img, x, y, null );
    }
}