import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.ImageGraphicAttribute;

public class MyFrame extends JFrame implements ActionListener {
    JRadioButton pizzaButton;
    JRadioButton sandwichButton;
    JRadioButton burgerButton;
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(400,500);

        pizzaButton = new JRadioButton("pizza");
        sandwichButton = new JRadioButton("sandwich");
        burgerButton = new JRadioButton("burger");

        ButtonGroup group = new ButtonGroup();
        group.add(pizzaButton);
        group.add(sandwichButton);
        group.add(burgerButton);

        pizzaButton.addActionListener(this);
        sandwichButton.addActionListener(this);
        burgerButton.addActionListener(this);

        this.add(pizzaButton);
        this.add(sandwichButton);
        this.add(burgerButton);


        this.pack();
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==pizzaButton){
            System.out.println("you will get pizza");
        }
        else if (e.getSource()==sandwichButton){
            System.out.println("you will get sandwich");
        }
        else if (e.getSource()==burgerButton){
            System.out.println("you will get burger");

        }
    }
}
