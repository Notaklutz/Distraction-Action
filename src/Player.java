import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
/**
 * @author Ryan Phan
 * @version 6 - June 2, 2019
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 * Creates the player and controls it the users interactions with the
 * in-game environment. Represented by a light bulb.
 * </p>
 * <p>
 * <pre>
 * Change Log
 * June 1, 2019 - Created Player
 * June 6, 2019 - Changed render() into paintComponent().
 * </pre>
 * </p>
 */
public class Player extends GameObject {
    /**
     * Handles the objects present on screen
     */
    private Handler handler;
    /**
     * Used in collision to for spawning
     */
    private Random r = new Random();
    /**
     * Image used as the player avatar
     */
    private BufferedImage img;
    /**
     * Damage taken every time the avatar hits a distraction
     */
    private int dmgTaken = 25;

    /**
     * This constructor will call the superclass to Player to set its x and y-coordinates,
     * and then it will retrieve the image used to represent the boost.
     * @param x  The x-coordinate of the player
     * @param y  The y-coordinate of the player
     * @param id Used for identification purposes in other classes used in level three
     * @param handler Handles the objects present on screen
     */
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        try {
            img = ImageIO.read(DistractionAction.class.getResourceAsStream("LevelThree/light-bulb.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Retrieves the hit-box of the distraction, to allow for collision detection.
     */
    public Rectangle getBounds() {
        return new Rectangle(x + 10, y, 40, 60);
    }

    /**
     * Updates the player as they move and keep them from leaving the
     * frame.
     */
    public void tick() {
        x += velX;
        y += velY;

        // REPLACE WITH WIDTH AND HEIGHT CONSTANTS
        x = LevelThreeGame.clamp(x, 0, DistractionAction.WIDTH - 57);
        y = LevelThreeGame.clamp(y, 0, DistractionAction.HEIGHT - 90);

        collision();
    }

    /**
     * Getter method for dmgTaken.
     * @return The amount of damage taken
     */
    public int getDmgTaken() {
        return dmgTaken;
    }

    /**
     * Controls collision events if any object comes in contact with the player.
     * <p>
     * <pre>
     * Variable Name            Variable Type        Description
     * tempObj                  GameObject           Used to check what object the user collided with
     * tmpObj                   GameObject           Used to modify the velocity of each distraction
     * </pre>
     * </p>
     */
    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObj = handler.objects.get(i);

            if (tempObj.getId() == ID.BasicDistraction) {
                if (getBounds().intersects(tempObj.getBounds())) {
                    handler.remove(tempObj);
                    PlayerStatus.FOCUS-= dmgTaken;
                    handler.add(new BasicDistraction(r.nextInt(900) + 25, r.nextInt(600) + 75, ID.BasicDistraction));
                }
            }

            if (tempObj.getId() == ID.Document) {
                if (getBounds().intersects(tempObj.getBounds())) {
                    PlayerStatus.DOCUMENTS++;
                    handler.remove(tempObj);
                    handler.add(new Document(r.nextInt(701) + 100, r.nextInt(601) + 100, ID.Document));
                    if (PlayerStatus.TIMETILLSPAWN > 50) {
                        PlayerStatus.TIMETILLSPAWN -= 30;
                    }
                }
            }
            
            if (tempObj.getId() == ID.FocusBoost) {
                if (getBounds().intersects(tempObj.getBounds())) {
                    handler.remove(tempObj);
                    PlayerStatus.FOCUS += 50;
                }
            }

            if (tempObj.getId() == ID.DamageReductionBoost) {
                if (getBounds().intersects(tempObj.getBounds())) {
                    handler.remove(tempObj);
                    dmgTaken-=5;
                }
            }

            if (tempObj.getId() == ID.SlowBoost) {
                if (getBounds().intersects(tempObj.getBounds())) {
                    for (int j = 0; j < handler.objects.size(); j++) {
                        GameObject tmpObj = handler.objects.get(j);
                        if (tmpObj.getId() == ID.BasicDistraction && tmpObj.getVelX() > 1 && tmpObj.getVelY() > 1) {
                            tmpObj.setVelX(tmpObj.getVelX() - 1);
                            tmpObj.setVelY(tmpObj.getVelY() - 1);
                        }
                    }
                    handler.remove(tempObj);
                }
            }
        }
    }

    /**
     * Draws the player to the screen.
     * @param g Used to draw to the screen
     */
    public void paintComponent(Graphics2D g) {
        g.drawImage(img, x, y, null );
    }
}
