import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        // Layout Manager = Defines the natural layout for components within a container
        // Grid Layout = places components in a grid of cells.
        // each component takes all the available space within its cell,
        // and each cell is the same size.

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(3, 3, 10, 10));

        class ButtonClickListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text of the clicked button
                String buttonText = e.getActionCommand();
                System.out.println("Button clicked: " + buttonText);
            }
        }
        ButtonClickListener buttonClickListener = new ButtonClickListener();

        frame.add(createButton("1", buttonClickListener));
        frame.add(createButton("2", buttonClickListener));
        frame.add(createButton("3", buttonClickListener));
        frame.add(createButton("4", buttonClickListener));
        frame.add(createButton("5", buttonClickListener));
        frame.add(createButton("6", buttonClickListener));
        frame.add(createButton("7", buttonClickListener));
        frame.add(createButton("8", buttonClickListener));
        frame.add(createButton("9", buttonClickListener));

        //        frame.add(new JButton("10")); // quick way to create button without creating instance

        frame.setVisible(true);

    }
    private static JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }
}
