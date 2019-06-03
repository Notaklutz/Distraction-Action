import java.awt.*;

public class BasicDistraction extends GameObject {

    public BasicDistraction(int x, int y, ID id) {
        super(x, y, id);

        velX = 5;
        velY = 5;
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
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 25, 25);
    }
}
