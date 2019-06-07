import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Handler handler;
    Random r = new Random();

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 50);
    }

    public void tick() {
        x += velX;
        y += velY;

        // REPLACE WITH WIDTH AND HEIGHT CONSTANTS
        x = LevelThreeGame.clamp(x, 0, 1000 - 56);
        y = LevelThreeGame.clamp(y, 0, 800 - 79);

        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObj = handler.objects.get(i);

            if (tempObj.getId() == ID.BasicDistraction) {
                if (getBounds().intersects(tempObj.getBounds())) {
                    PlayerStatus.FOCUS-= 2;
                }
            }

            if (tempObj.getId() == ID.Document) {
                if (getBounds().intersects(tempObj.getBounds())) {
                    PlayerStatus.DOCUMENTS++;
                    handler.remove(tempObj);
                    handler.add(new Document(r.nextInt(701) + 100, r.nextInt(601) + 100, ID.Document, handler));
                    if (PlayerStatus.TIMETILLSPAWN > 50) {
                        PlayerStatus.TIMETILLSPAWN -= 25;
                    }
                }
            }
            
            if (tempObj.getId() == ID.HealthBoost) {
                if (getBounds().intersects(tempObj.getBounds())) {
                    handler.remove(tempObj);
                    PlayerStatus.FOCUS += 50;
                }
            }
            
        }
    }

    public void paintComponent(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 50, 50);
    }
}
