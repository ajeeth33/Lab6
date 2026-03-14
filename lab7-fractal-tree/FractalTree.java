import javax.swing.*;
import java.awt.*;

public class FractalTree extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int startX = getWidth() / 2;
        int startY = getHeight() - 100;

        drawTree(g, startX, startY, -90, 100, 8);
    }

    public void drawTree(Graphics g, int x1, int y1, double angle, int length, int depth) {
        if (depth == 0) {
            return;
        }

        int x2 = x1 + (int)(length * Math.cos(Math.toRadians(angle)));
        int y2 = y1 + (int)(length * Math.sin(Math.toRadians(angle)));

        g.drawLine(x1, y1, x2, y2);

        drawTree(g, x2, y2, angle - 20, length - 15, depth - 1);
        drawTree(g, x2, y2, angle + 20, length - 15, depth - 1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fractal Tree");
        FractalTree panel = new FractalTree();

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        System.out.println("Fractal tree displayed.");
    }
}
