import java.awt.*;
import java.util.ArrayList;
/**
 * @author Ryan Phan
 * @version 6 - June 2, 2019
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * <p>
 * Handles all of the objects and elements present on screen in level three.
 * </p>
 * <p>
 * <pre>
 * Change Log
 * June 2, 2019 - Created Handler
 * </pre>
 * </p>
 */ 
public class Handler {
   /**
    * Stores of the objects present on screen
    */
    ArrayList<GameObject> objects = new ArrayList<>();
   /**
    * Updates the GameObjects
    */
    public void tick(){
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObj = objects.get(i);
            tempObj.tick();
        }
    }
    /**
     * Draws each GameObject to the screen
     * @param g Used to draw elements to the screen
     */
    public void paintComponent(Graphics2D g){
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObj = objects.get(i);
            tempObj.paintComponent(g);
        }
    }

    /**
     * Add GameObject to objects ArrayList
     * @param obj GameObject to be added
     */
    public void add(GameObject obj){
        this.objects.add(obj);
    }

    /**
     * Remove GameObject from objects ArrayList
     * @param obj GameObject to remove
     */
    public void remove(GameObject obj){
        this.objects.remove(obj);
    }

}
