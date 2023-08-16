import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Jlabel = a GUI display area for a string of text, an image, or both

        ImageIcon image = new ImageIcon("Owl.png");

        Border border = BorderFactory.createLineBorder(Color.green);


        JLabel label = new JLabel();
        label.setText("Bro, do you even code");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT, CENTER, RIGHT, of image
        label.setVerticalTextPosition(JLabel.TOP); // set text TOP, CENTER, BOTTOM of image
        label.setForeground(new Color(240, 24, 12)); // set font color of text
        label.setFont(new Font("Mv Boli", Font.BOLD, 50)); // set font of text
        label.setIconTextGap(-32); // set gap of text to image
        label.setBackground(Color.BLACK); // to set color of background
        label.setOpaque(true); // this will display background color
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label
//        label.setBounds(110, 110, 350, 350); //set x,y position within frame as wll as dimensions


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(label);
//        frame.setLayout(null);
        frame.setVisible(true);
//        frame.pack();
    }
}
