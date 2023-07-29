import javax.swing.*;
import java.awt.*;

public class Myframe extends JFrame {

    MyPannel pannel;
    Myframe(){
        pannel = new MyPannel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);

        this.add(pannel);
        this.pack();
        this.setLocationRelativeTo(this);
        this.setVisible(true);



    }
}
