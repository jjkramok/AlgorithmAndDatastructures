package week2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tim H on 13-2-2017.
 */
public class PythagorasFractal extends JPanel {
    static final int width = 1260;
    static final int height = 780;
    static final double factor = 0.707; //Math.sqrt(2);

    public PythagorasFractal() {}

    public void drawFractal(Graphics g, int x1, int y1, int x2, int y2) {
        g.drawLine(x1 + width/2, height/2 - y1, x2 + width/2, height/2 - y2);

        //Base case: stop if next step is only one pixel different
        if (Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1)
            return;

        int distance;
        //Check (previous) line alignment
        //Cardinals
        if (x1 == x2) {
            //Vertical: now check direction of line
            if (y1 < y2) {
                //Northwards
                distance = (int) (factor * (y2-y1));
                drawFractal(g, x2, y2, x2-distance, y2+distance);
                drawFractal(g, x2, y2, x2+distance, y2+distance);
            } else {
                //Southwards
                distance = (int) (factor * (y1-y2));
                drawFractal(g, x2, y2, x2-distance, y2-distance);
                drawFractal(g, x2, y2, x2+distance, y2-distance);
            }
        } else if (y1 == y2) {
            //Horizontal: now check direction of line
            if (x1 < x2) {
                //Eastwards
                distance = (int) (factor * (x2-x1));
                drawFractal(g, x2, y2, x2+distance, y2-distance);
                drawFractal(g, x2, y2, x2+distance, y2+distance);
            } else {
                //Westwards
                distance = (int) (factor * (x1-x2));
                drawFractal(g, x2, y2, x2-distance, y2-distance);
                drawFractal(g, x2, y2, x2-distance, y2+distance);
            }

        //Diagonals
        } else if (x1 < x2) {
            //Eastwards: now check the y direction (postive or negative slope)
            distance = (int) (factor * (x2-x1));
            if (y1 < y2) {
                //Northwards
                drawFractal(g, x2, y2, x2+distance, y2);    //Horizontal line
                drawFractal(g, x2, y2, x2, y2+distance);    //Vertical line
            } else {
                //Southwards
                drawFractal(g, x2, y2, x2, y2-distance);    //Vertical line
                drawFractal(g, x2, y2, x2+distance, y2);    //Horizontal line
            }
        } else {
            //Westwards: now check the y direction (postive or negative slope)
            distance = (int) (factor * (x1-x2));
            if (y1 < y2) {
                //Northwards
                drawFractal(g, x2, y2, x2, y2+distance);    //Vertical line
                drawFractal(g, x2, y2, x2-distance, y2);    //Horizontal line
            } else {
                //Southwards
                drawFractal(g, x2, y2, x2, y2-distance);    //Vertical line
                drawFractal(g, x2, y2, x2-distance, y2);    //Horizontal line
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        g.setColor(getForeground());
        drawFractal(g, 0, -300, 0, -100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pythagoras Fractal Tree");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PythagorasFractal panel = new PythagorasFractal();
        frame.setContentPane(panel);
        frame.setSize(width, height);
        frame.setVisible(true);
    }
}
