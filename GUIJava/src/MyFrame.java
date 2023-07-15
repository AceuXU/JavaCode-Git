import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame(){

        // Copy of main class

        this.setTitle("UwU");
        this.setSize(420,420);  // sets x and y dimensions
        this.setVisible(true);   // make frame visible
        this.setResizable(false);  // prevent frame from being resized
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon image = new ImageIcon("Owl.png");
        this.setIconImage(image.getImage());  // this will change icon of this
        this.getContentPane().setBackground(new Color(122, 44,222));
    }
}
