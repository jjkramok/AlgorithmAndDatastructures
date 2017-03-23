package week7;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Tim H on 23/3/2017.
 */
public class NineDieFractal extends JPanel {
    static final int width = 1260;
    static final int height = 1060;

    public NineDieFractal() {}

    public void drawFractal(Graphics g, int x, int y, int len) {

        int pl = len / 3;
        int hl = len / 2;
        //Base case: stop if next step is only a two pixel difference
        if (len <= 2) {
            return;
        }

        //Draw 9 boxes : clockwise
        if (len < 20){
            g.drawRect(x + hl, y - (pl / 2), pl, pl); //upper
            g.drawRect(x + (pl / 2), y + hl, pl, pl);
            g.drawRect(x + (pl / 2), y + (pl / 2), pl, pl); //right
            g.drawRect(x + (pl / 2), y - (pl / 2), pl, pl);
            g.drawRect(x - (pl / 2), y - (pl / 2), pl, pl); //down
            g.drawRect(x - hl, y - (pl / 2), pl, pl);
            g.drawRect(x - hl, y + (pl / 2), pl, pl); //left
            g.drawRect(x - hl, y + hl, pl, pl);
            g.drawRect(x - (pl / 2), y + (pl / 2), pl, pl); //self
        }

        //continue recursively in the five marked boxes (see Ex 2.) : clockwise
        drawFractal(g, x+pl, y+pl, pl);
        drawFractal(g, x+pl, y-pl, pl);
        drawFractal(g, x-pl, y-pl, pl);
        drawFractal(g, x-pl, y+pl, pl);
        drawFractal(g, x, y, pl);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        g.setColor(getForeground());
        drawFractal(g, 630, 530, 530);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Minkowski Fractal");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        NineDieFractal panel = new NineDieFractal();
        frame.setContentPane(panel);
        frame.setSize(width, height);
        frame.setVisible(true);
    }
}
