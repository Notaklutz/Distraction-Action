import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Document extends GameObject {
    Handler handler;
    private BufferedImage img;

    public Document(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        try {
            img = ImageIO.read( new File("document.png" ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Rectangle getBounds(){
        return new Rectangle(x + 8, y + 1, 41, 56);
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
