import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JComboBox comboBox;
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(500,500);


        String[] animals = {"dog","cat","bird"};

        comboBox= new JComboBox(animals);
        comboBox.addActionListener(this);

//        comboBox.setEditable(true);
//        System.out.println( comboBox.getItemCount());
        comboBox.addItem("horse");
        comboBox.insertItemAt("uwu", 3); // this will add element at given index
        comboBox.setSelectedIndex(3);
//        comboBox.removeItemAt(4);
//        comboBox.removeAllItems();

        this.add(comboBox);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==comboBox){
//            System.out.println(comboBox.getSelectedItem());
            System.out.println(comboBox.getSelectedIndex());

        }

    }
}
