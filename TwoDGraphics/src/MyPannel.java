import javax.swing.*;
import java.awt.*;

public class MyPannel extends JPanel {

    Image image;

    MyPannel() {

        image = new ImageIcon("rocket.png").getImage();
        this.setPreferredSize(new Dimension(500,500));

    }
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(image,0,0,null);
//        g2D.setPaint(Color.red);
//        g2D.setStroke(new BasicStroke(10));
//        g2D.drawLine(0, 0, 500, 500);
//
//        g2D.setPaint(Color.GREEN);
//        g2D.drawRect(0,0,100,100);
//        g2D.fillRect(0,0,100,100);
//
//        g2D.setPaint(Color.ORANGE);
//        g2D.drawOval(100,110,150,200);
//        g2D.fillOval(100,110,150,200);
//
//
        g2D.setPaint(Color.RED);
        g2D.fillArc(0,0,100,100,0,180);
        g2D.setPaint(Color.white);
        g2D.fillArc(0,0,100,100,180,180);
//        g2D.drawArc(0,0,100,100,180,180);

        int[] xPoints = {150,250,350};
        int[] yPoints ={300,150,300};
        g2D.setPaint(Color.yellow);
        g2D.fillPolygon(xPoints,yPoints,3);

//        g2D.setPaint(Color.magenta);
//        g2D.drawString("YOu are a cutie <3 ",100,50);
//        g2D.setFont(new Font("Ink Free", Font.BOLD, 20));
//
//        g2D.drawImage(image,0,0,null);
    }

}
