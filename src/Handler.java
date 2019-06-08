import java.awt.*;
import java.util.ArrayList;
/**
 * @author Ryan Phan
 * @version ??? - June 6, 2019
 * 
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 * 
 * <p>
 * MORE TO BE ADDED
 * </p>
 */

/**
 * Change Log
 * June 2, 2019 - Created Handler
 */ 
public class Handler {
   /**
    * PLACEHOLDER
    */
    ArrayList<GameObject> objects = new ArrayList<GameObject>();
   /**
    * PLACEHOLDER
    */
    public void tick(){
        for (int i = 0; i < objects.size(); i++){
            GameObject tempObj = objects.get(i);
            tempObj.tick();
        }
    }
   /**
    * PLACEHOLDER
    */
    public void paintComponent(Graphics2D g){
        for (int i = 0; i < objects.size(); i++){
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
