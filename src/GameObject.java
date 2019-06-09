import java.awt.*;

/**
 * @author Ryan Phan
 * @version 3 - June 6, 2019
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 * Stores all of the common variables and methods for the objects and elements
 * in level three.
 * </p>
 */

/**
 * Change Log
 * June 4, 2019 - Created GameObject
 */
public abstract class GameObject {
    /**
     * Stores the location of the object
     */
    protected int x, y;
    /**
     * Stores the identity of the object (Such as Player or BouDistraction)
     */
    protected ID id;
    /**
     * Stores the speed of the object on the x and the y-axis
     */
    protected int velX, velY;

    /**
     * This constructor will give the object an ID and set its initial location on the screen.
     *
     * @param x  The x-coordinate of the object
     * @param y  The y-coordinate of the object
     * @param id Used for identification purposes in other classes used in level three
     */
    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    /**
     * Used if the object changes on its own.
     */
    public abstract void tick();

    /**
     * Used to draw the object to the screen
     */
    public abstract void paintComponent(Graphics2D g);

    /**
     * Retrieves the hit-box of the distraction, to allow for collision detection.
     */
    public abstract Rectangle getBounds();

    /**
     * Sets the x location of the object
     *
     * @param x location of the object
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y location of the object
     *
     * @param y y location of the object
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the x location of the object
     *
     * @return x-coordinate of the object
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y location of the object
     *
     * @return y-coordinate of the object
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the ID of the object
     *
     * @param id Object Identification
     */
    public void setId(ID id) {
        this.id = id;
    }

    /**
     * Gets the ID of the object
     *
     * @return Object Identification
     */
    public ID getId() {
        return id;
    }

    /**
     * Gets velocity on x-axis
     *
     * @return velocity on x
     */
    protected int getVelX() {
        return velX;
    }

    /**
     * Sets velocity on x-axis
     *
     * @param velX velocity on x
     */
    protected void setVelX(int velX) {
        this.velX = velX;
    }

    /**
     * Gets velocity on y-axis
     *
     * @return velocity on y
     */
    protected int getVelY() {
        return velY;
    }

    /**
     * Sets velocity on x-axis
     *
     * @param velY velocity on y
     */
    protected void setVelY(int velY) {
        this.velY = velY;
    }
}
