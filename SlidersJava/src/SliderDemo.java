import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderDemo implements ChangeListener {
    JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider slider;
    SliderDemo(){
        frame = new JFrame("Slider Demo");
        panel = new JPanel();
        label = new JLabel();
        slider = new JSlider(0,100,50);

        slider.setPreferredSize(new Dimension(400,400));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setMajorTickSpacing(25);
        slider.setPaintLabels(true);
        slider.setFont(new Font("Ink Free",Font.BOLD,15));
        slider.setOrientation(SwingConstants.VERTICAL);

        slider.addChangeListener(this); // to detect change in temp when user slides

        label.setText("°C = " + slider.getValue());
        label.setFont(new Font("Ink Free",Font.BOLD,20));

        panel.add(slider);
        panel.add(label);

        frame.add(panel);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void stateChanged(ChangeEvent e) {

        label.setText("°C = " + slider.getValue());
    }
}
