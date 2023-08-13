import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Myframe extends JFrame implements ActionListener {

    JButton button;
    JTextField textField;
    Myframe(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(430,450);

        button = new JButton("Sumbit");
        button.addActionListener(this);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));
        textField.setFont(new Font("Consolas",Font.BOLD,35));
        textField.setForeground(Color.cyan);
        textField.setBackground(Color.black);
        textField.setText("enter your name");

        this.add(button);
        this.add(textField);
        this.pack();
        this.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            System.out.println("welcome " + textField.getText());
//            button.setEnabled(false);
//            textField.setEditable(false);
        }
    }
}
