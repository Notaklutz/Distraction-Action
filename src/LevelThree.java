import javax.swing.*;


public class LevelThree extends JPanel {
    public LevelThree(LevelThreeGame levelThree){
        add(levelThree);
        addNotify();
        levelThree.start();
    }
}
