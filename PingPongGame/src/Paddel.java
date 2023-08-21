import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddel extends Rectangle {

    int id;
    int yVelocity;
    int speed = 10;

    Paddel(int x, int y, int PADDEL_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDEL_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

    public void keyPressed(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                    move();
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(0);

                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);

                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(0);

                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(0);

                }
                break;
        }
    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public void move() {
        y = y + yVelocity;
    }

    public void draw(Graphics g) {
        if (id == 1)
            g.setColor(Color.BLUE);
        else g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
}
