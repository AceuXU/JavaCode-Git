import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // JPanel = a GUI component that functions as a container to hold other components

        JLabel label = new JLabel();
        label.setText("HI");

        JPanel redpanel = new JPanel();
        redpanel.setBackground(Color.red);
        redpanel.setBounds(0,0,250,250);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250,0,250,250);

        JPanel greenPanel = new JPanel();
        redpanel.setBackground(Color.BLACK);
        redpanel.setBounds(0,250,500,250);
        greenPanel.setLayout(new BorderLayout());


        JFrame frame = new JFrame(); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.setVisible(true);

        frame.add(redpanel);
        frame.add(bluePanel);
    }
}
