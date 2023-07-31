import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;

public class MyFrame extends JFrame {

    Image image;
    Graphics graphics;
    Box player;
    Box Enemy;
    boolean gameOver;

    MyFrame() {
        player = new Box(100, 200, 50, 50, Color.BLUE);
        Enemy = new Box(400, 200, 50, 50, Color.RED);
        gameOver = false;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
        this.addKeyListener(new AL());
    }

    public class UpAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            player.setY(player.getY() - 25);
            checkCollision();
            repaint();
        }
    }

    public class DownAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            player.setY(player.getY() + 25);
            checkCollision();
            repaint();
        }
    }

    public class LeftAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            player.setX(player.getX() - 25);
            checkCollision();
            repaint();
        }
    }

    public class RightAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            player.setX(player.getX() + 25);
            checkCollision();
            repaint();
        }
    }

    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_W) {
                new UpAction().actionPerformed(null);
            } else if (keyCode == KeyEvent.VK_S) {
                new DownAction().actionPerformed(null);
            } else if (keyCode == KeyEvent.VK_A) {
                new LeftAction().actionPerformed(null);
            } else if (keyCode == KeyEvent.VK_D) {
                new RightAction().actionPerformed(null);
            }
        }
    }

    public void paint(Graphics g) {
        image = createImage(this.getWidth(), this.getHeight());
        graphics = image.getGraphics();
        g.drawImage(image, 0, 0, this);

        player.draw(g);
        Enemy.draw(g);
        if (gameOver) {
            g.setColor(Color.ORANGE);
            g.setFont(new Font("MV Boli", Font.PLAIN, 45));
            g.drawString("GAME OVER!", 150, 100);
        }
    }

    public void checkCollision() {
        if (player.intersects(Enemy)) {
            gameOver = true;
            System.out.println("GAME OVER");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyFrame());
    }

    class Box {
        private int x, y, width, height;
        private Color color;

        public Box(int x, int y, int width, int height, Color color) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }

        public boolean intersects(Box other) {
            return (x < other.x + other.width && x + width > other.x &&
                    y < other.y + other.height && y + height > other.y);
        }
    }
}

