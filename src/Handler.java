import java.awt.*;
import java.util.ArrayList;

public class Handler {

    ArrayList<GameObject> objects = new ArrayList<GameObject>();

    public void tick(){
        for (int i = 0; i < objects.size(); i++){
            GameObject tempObj = objects.get(i);
            tempObj.tick();
        }
    }

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
