package week2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tim H on 13-2-2017.
 */
public class HTreeFractal extends JPanel {
    static final int width = 1260;
    static final int height = 780;
    static final double factor = 0.707; //Math.sqrt(2);

    public HTreeFractal() {}

    public void drawFractal(Graphics g, int x, int y, int len, boolean hor, int depth) {
        int x1, x2, y1, y2;
        if (hor) {
            x1 = x - len;
            x2 = x + len;
            y1 = y;
            y2 = y;
        } else {
            x1 = x;
            x2 = x;
            y1 = y - len;
            y2 = y + len;
        }
        g.drawLine(x1 + width/2, height/2 - y1, x2 + width/2, height/2 - y2);

        if (depth > 0) {
            int newLen = (int) (len * factor);
            drawFractal(g, x1, y1, newLen, !hor, depth-1);
            drawFractal(g, x2, y2, newLen, !hor, depth-1);
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        g.setColor(getForeground());
        drawFractal(g,0, 0, 200, true, 12);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HTreeFractal HTree");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        HTreeFractal panel = new HTreeFractal();
        frame.setContentPane(panel);
        frame.setSize(width, height);
        frame.setVisible(true);
    }
}
