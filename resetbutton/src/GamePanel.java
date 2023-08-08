import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {

    Random random;
    GamePanel(){
        // code for game goes here
        random = new Random();

        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        this.setSize(500,500);
        this.setLocation(100,0);
        this.setBackground(new Color(r,g,b));
    }
}
