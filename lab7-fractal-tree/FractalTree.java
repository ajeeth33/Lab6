import javax.swing.*;
import java.awt.*;

public class FractalTree extends JPanel {

    private final int MAX_DEPTH = 9;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int startX = getWidth() / 2;
        int startY = getHeight() - 50;

        drawTree(g, startX, startY, -90, MAX_DEPTH);
    }

    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0) {
            return;
        }

        int length = depth * 12;

        int x2 = x1 + (int)(length * Math.cos(Math.toRadians(angle)));
        int y2 = y1 + (int)(length * Math.sin(Math.toRadians(angle)));

        g.drawLine(x1, y1, x2, y2);

        drawTree(g, x2, y2, angle - 20, depth - 1);
        drawTree(g, x2, y2, angle + 20, depth - 1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.add(new FractalTree());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        System.out.println("Fractal tree window opened.");
    }
}
