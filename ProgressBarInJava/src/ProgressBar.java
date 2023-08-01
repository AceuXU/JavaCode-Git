import java.awt.*;
import javax.swing.*;
public class ProgressBar {

    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar(0,100);
    int currentHP;
    int  maximumHP =100;

    ProgressBar(){

        bar.setValue(0);
        bar.setBounds(0,0,500,50);
        bar.setStringPainted(true);
        bar.setFont(new Font("MV Boli",Font.BOLD,25));
        bar.setForeground(Color.red);
        bar.setBackground(Color.BLACK);
//        bar.setString(currentHP+"/"+maximumHP+" HP");




        frame.add(bar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);

        fill();

    }
    public void fill(){
        int counter = 0;
        while (counter<=100){
            bar.setValue(counter);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter +=1;
        }
        bar.setString("DONE!");
        bar.setString(currentHP+"0/"+maximumHP+" HP");


    }
}
