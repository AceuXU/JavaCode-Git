import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;

    Image enemy;
    Image background;
    Timer timer;

    int XVelocity = 1;
    int YVelocity = 1;
    int x = 0;
    int y = 0;

    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);


        enemy = new ImageIcon("rocket.png").getImage();
        timer = new Timer(100,this);
        timer.start();
    }

    public void paint(Graphics g){
        super.paint(g); // this will print background

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(background, x,y,null);
        graphics2D.drawImage(enemy, x,y,null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       /* if (x>=PANEL_WIDTH-enemy.getWidth(null) || x<0){
            XVelocity = XVelocity * -1;
        }

        x = x + XVelocity;
        repaint();
        */
        if (y>=PANEL_WIDTH-enemy.getHeight(null) || x<0){
            YVelocity = YVelocity * -1;
        }

        y = y + YVelocity;

    }
}

