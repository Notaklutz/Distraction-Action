import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y, ID id){
        super(x, y, id);
    }

    public void tick(){
        x+= velX;
        y+= velY;

        // REPLACE WITH WIDTH AND HEIGHT CONSTANTS
        x = LevelThreeGame.clamp(x, 0, 1000 - 56);
        y = LevelThreeGame.clamp(y, 0, 800 - 79);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 50, 50);
    }
}
