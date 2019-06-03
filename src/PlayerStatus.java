import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PlayerStatus {

    public static int FOCUS = 100;
    Font statusFont;
    public static int DOCUMENTS = 0;

    public void tick(){
        FOCUS--;
        FOCUS = LevelThreeGame.clamp(FOCUS, 0, 100);
    }

    public void initFont(){
        try {
            statusFont = Font.createFont(Font.TRUETYPE_FONT, new File("Apple.ttf")).deriveFont(25f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics g){
        initFont();
        g.setFont(statusFont);
        g.setColor(Color.WHITE);
        g.drawString("Focus: ", 25, 50);
        g.drawString("Documents: " + Integer.toString(DOCUMENTS) + "/10", 600, 50);
        // BORDER
        g.setColor(Color.BLACK);
        g.fillRect(175, 20, 306, 40);
        // Distraction
        g.setColor(Color.RED);
        g.fillRect(178, 23, 300, 34);
        // FOCUS
        g.setColor(Color.BLUE);
        g.fillRect(178, 23, FOCUS * 3, 34);

    }
}
