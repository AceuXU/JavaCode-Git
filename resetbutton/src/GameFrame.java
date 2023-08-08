import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    GamePanel gamePanel;
    JButton resetButton;
    GameFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,600);
        this.setLayout(null);

        resetButton = new JButton();
        resetButton.setText("Reset");
        resetButton.setSize(100,50);
        resetButton.setLocation(0,200);
        resetButton.addActionListener(this);

        gamePanel = new GamePanel();

        this.add(resetButton);
        this.add(gamePanel);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==resetButton){
            this.remove(gamePanel);
            gamePanel = new GamePanel();
            this.add(gamePanel);
            SwingUtilities.updateComponentTreeUI(this);
            System.out.println("new color generated");
        }
    }
}
