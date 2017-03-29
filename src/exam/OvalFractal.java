package exam;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tim H on 13-2-2017.
 * Ex. 2
 */
public class OvalFractal extends JPanel {
    static final int width = 1260;
    static final int height = 780;
    static final double factor = 0.707; //Math.sqrt(2);

    public OvalFractal() {}

    public void drawFractal(Graphics g, int x, int y, int len, int hor, int depth, boolean first) {
        if (first) {
            g.drawOval(x, y, len*2, len*2);
            first = false;
        }
        int horX1, horX2, horY1, horY2;
        int vertX1, vertX2, vertY1, vertY2;
        int pl = len/2;

        //hor
        horX1 = x;
        horY1 = y + pl;

        horX2 = x + len;
        horY2 = y + pl;
        g.drawOval(horX1, horY1, len, len);
        g.drawOval(horX2, horY2, len, len);
        if (depth > 0) {
            drawFractal(g, horX1, horY1, len/2, 1, depth-1, false);
            drawFractal(g, horX2, horY2, len/2, 1, depth-1, false);
        }

        //vert
        vertX1 = x + pl;
        vertY1 = y;

        vertX2 = x + pl;
        vertY2 = y + len;
        g.drawOval(vertX1, vertY1, len, len);
        g.drawOval(vertX2, vertY2, len, len);
        if (depth > 0) {
            drawFractal(g, vertX1, vertY1, len / 2, 0, depth - 1, false);
            drawFractal(g, vertX2, vertY2, len / 2, 0, depth - 1, false);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        g.setColor(getForeground());
        drawFractal(g,0, 0, height/2, -1, 4, true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HTreeFractal HTree");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        OvalFractal panel = new OvalFractal();
        frame.setContentPane(panel);
        frame.setSize(width, height);
        frame.setVisible(true);
    }
}
