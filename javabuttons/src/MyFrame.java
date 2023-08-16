import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    JButton button;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);

        button = new JButton();
        button.setBounds(100, 100, 200, 150);
        button.setText("Button");
        button.addActionListener(e -> System.out.println("boom"));
        button.setFocusable(false);
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button.setForeground(Color.cyan);
        button.setBackground(Color.BLACK);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setEnabled(false);  // to disable button

        this.add(button);
        this.setVisible(true);

    }
}
