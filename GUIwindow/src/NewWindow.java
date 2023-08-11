import javax.swing.*;
import java.awt.*;

public class NewWindow {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("HEy YO");

    NewWindow(){

        label.setBounds(0,0,100,40);
        label.setFont(new Font("Ink Free",Font.BOLD,27));


        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(430,430);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}

