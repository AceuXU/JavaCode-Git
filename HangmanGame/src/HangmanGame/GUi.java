package HangmanGame;

import javax.swing.*;

public class GUi extends JFrame {

    JFrame frame;
    GUi(){
        frame.setSize(500,500);
        frame.setResizable(true);
        frame.setTitle("Hangman Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
