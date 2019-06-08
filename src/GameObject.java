import javax.swing.*;
import java.awt.*;
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
public abstract class GameObject{
   /**
    * PLACEHOLDER
    */
    protected int x, y;
   /**
    * PLACEHOLDER
    */
    protected ID id;
   /**
    * PLACEHOLDER
    */
    protected int velX, velY;

   /**
    * PLACEHOLDER
    */
    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

   /**
    * PLACEHOLDER
    */
    public abstract void tick();
   /**
    * PLACEHOLDER
    */
    public abstract void paintComponent(Graphics2D g);
   /**
    * PLACEHOLDER
    */
    public abstract Rectangle getBounds();
   /**
    * PLACEHOLDER
    */
    public void setX(int x) {
        this.x = x;
    }
   /**
    * PLACEHOLDER
    */
    public void setY(int y) {
        this.y = y;
    }
   /**
    * PLACEHOLDER
    */
    public int getX() {
        return x;
    }
   /**
    * PLACEHOLDER
    */
    public int getY() {
        return y;
    }
   /**
    * PLACEHOLDER
    */
    public void setId(ID id) {
        this.id = id;
    }
   /**
    * PLACEHOLDER
    */
    public ID getId() {
        return id;
    }
   /**
    * PLACEHOLDER
    */
    public int getVelX() {
        return velX;
    }
   /**
    * PLACEHOLDER
    */
    public void setVelX(int velX) {
        this.velX = velX;
    }
   /**
    * PLACEHOLDER
    */
    public int getVelY() {
        return velY;
    }
   /**
    * PLACEHOLDER
    */
    public void setVelY(int velY) {
        this.velY = velY;
    }
}
