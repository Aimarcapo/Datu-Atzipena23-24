
    import javax.swing.*;
import java.awt.*;

public class MarioJump extends JFrame {
    private int marioY = 200; // Posición inicial de Mario en el eje Y

    public MarioJump() {
        setTitle("Mario Jump");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);

        JumpPanel panel = new JumpPanel();
        add(panel);

        Timer timer = new Timer(50, e -> {
            marioY -= 10; // Simula el salto de Mario
            if (marioY <= 100) {
                marioY = 200; // Reinicia la posición de Mario cuando llega al suelo
            }
            panel.repaint();
        });
        timer.start();
    }

    class JumpPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawMario(g);
        }

        private void drawMario(Graphics g) {
            // Dibuja el cuerpo de Mario
            g.setColor(Color.RED);
            g.fillRect(100, marioY, 50, 50);

            // Dibuja la cabeza de Mario
            g.setColor(Color.BLUE);
            g.fillOval(110, marioY - 30, 30, 30);

            // Dibuja los ojos de Mario
            g.setColor(Color.WHITE);
            g.fillOval(118, marioY - 25, 8, 8);
            g.fillOval(128, marioY - 25, 8, 8);

            // Dibuja los brazos de Mario
            g.setColor(Color.RED);
            g.fillRect(90, marioY + 5, 20, 5);
            g.fillRect(150, marioY + 5, 20, 5);

            // Dibuja los botones de Mario
            g.setColor(Color.YELLOW);
            g.fillOval(123, marioY + 15, 5, 5);
            g.fillOval(123, marioY + 25, 5, 5);
            g.fillOval(123, marioY + 35, 5, 5);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MarioJump marioJump = new MarioJump();
            marioJump.setVisible(true);
        });
    }
}


