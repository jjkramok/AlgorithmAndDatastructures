package week2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kramok on 13-2-2017.
 */
public class MinkowskiFractal extends JPanel {
    static final int width = 1260;
    static final int height = 780;
    static final double factor = 0.707; //Math.sqrt(2);

    public MinkowskiFractal() {}

    public void drawFractal(Graphics g, int x1, int y1, int x2, int y2) {


        //Base case: stop if next step is only one pixel different
        if (Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1) {
            g.drawLine(x1 + width / 2, height / 2 - y1, x2 + width / 2, height / 2 - y2);
            return;
        }

        int pl; //part length, should be a fourth of the whole length

        //Check for direction and cardinality of the line (upwards / downwards and vertical or horizontal)
        if (x1 == x2) {
            //Vertical line
            if (y1 < y2) {
                //Upwards
                pl = (y2 - y1) / 4;
                drawFractal(g,x1,y1,x1,y1+pl);
                drawFractal(g,x1,y1+pl,x1-pl,y1+pl);
                drawFractal(g,x1-pl,y1+pl,x1- pl,y1+2*pl);
                drawFractal(g,x1-pl,y1+2*pl,x1,y1+2*pl);
                drawFractal(g,x1,y1+2*pl,x1+pl,y1+2*pl);
                drawFractal(g,x1+pl,y1+2*pl,x1+pl,y1+3*pl);
                drawFractal(g,x1+pl,y1+3*pl,x1,y1+3*pl);
                drawFractal(g,x1,y1+3*pl,x1,y1+4*pl);
            } else {
                //Downwards
                pl = (y1 - y2) / 4;
                drawFractal(g,x1,y1,x1,y1-pl);
                drawFractal(g,x1,y1-pl,x1+pl,y1- pl);
                drawFractal(g,x1+pl,y1-pl,x1+pl,y1- 2*pl);
                drawFractal(g,x1+pl,y1-2*pl,x1,y1- 2*pl);
                drawFractal(g,x1,y1-2*pl,x1- pl,y1-2*pl);
                drawFractal(g,x1-pl,y1- 2*pl,x1-pl,y1- 3*pl);
                drawFractal(g,x1-pl,y1- 3*pl,x1,y1-3*pl);
                drawFractal(g,x1,y1-3*pl,x1,y1- 4*pl);
            }
        } else if (y1 == y2) {
            //Horizontal line
            if (x1 < x2) {
                //Rightwards
                pl = (x2 - x1) / 4;
                drawFractal(g, x1, y1, x1+pl, y1);
                drawFractal(g, x1+pl, y1, x1+pl, y1+pl);
                drawFractal(g, x1+pl, y1+pl, x1+pl*2, y1+pl);
                drawFractal(g, x1+pl*2, y1+pl, x1+pl*2, y1);
                drawFractal(g, x1+pl*2, y1, x1+pl*2, y1-pl);
                drawFractal(g, x1+pl*2, y1-pl, x1+pl*3, y1-pl);
                drawFractal(g, x1+pl*3, y1-pl, x1+pl*3, y1);
                drawFractal(g, x1+pl*3, y1, x1+pl*4, y1);
            } else {
                //Leftwards
                pl = (x1 - x2) / 4;
                drawFractal(g,x1,y1,x1-pl,y1);
                drawFractal(g,x1-pl,y1,x1- pl,y1-pl);
                drawFractal(g,x1-pl,y1- pl,x1-2*pl,y1- pl);
                drawFractal(g,x1-2*pl,y1- pl,x1-2*pl,y1);
                drawFractal(g,x1-2*pl,y1,x1- 2*pl,y1+pl);
                drawFractal(g,x1-2*pl,y1+pl,x1- 3*pl,y1+pl);
                drawFractal(g,x1-3*pl,y1+pl,x1- 3*pl,y1);
                drawFractal(g,x1-3*pl,y1,x1- 4*pl,y1);
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        g.setColor(getForeground());
        drawFractal(g, -512, 0, 512, 0);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Minkowski Fractal");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MinkowskiFractal panel = new MinkowskiFractal();
        frame.setContentPane(panel);
        frame.setSize(width, height);
        frame.setVisible(true);
    }
}
