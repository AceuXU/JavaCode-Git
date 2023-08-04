import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    JButton myButton = new JButton("Button");
    JButton myButton2 = new JButton("Button2");

    MyFrame(){
        myButton.setBounds(100,100,200,100);
        myButton.addActionListener(
                (e) -> System.out.println("You clicked a button")
        );

        myButton2.setBounds(100,200,200,100);
        myButton2.addActionListener(
                (e) -> System.out.println("You clicked a 2nd button")
        );

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(420,420);
        this.setVisible(true);
        this.add(myButton);
        this.add(myButton2);
    }
}
