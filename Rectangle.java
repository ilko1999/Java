import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

public class Rectangle extends Frame {
    private ArrayList<Integer> x = new ArrayList<>();
    private ArrayList<Integer> y = new ArrayList<>();
    private int r = 5;
    private int startX = 100, startY = 100, width = 400, height = 400;

    Rectangle() {
        super("Rectangle");

        this.setSize(1024,768);
        setBackground(Color.WHITE);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int X = e.getX();
                int Y = e.getY();
                int R = 5;

                if (X > startX + R && X < (startX + width - R) && Y > startY + R && Y < (startY + height - R)) {
                    x.add(X);
                    y.add(Y);

                    repaint();
                }
            }
        });
    }

    public static void main(String[] args) {
        new Rectangle();
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(startX,startY, width, height);

        for (int i = 0; i < x.size(); i++) {
            int X = x.get(i);
            int Y = y.get(i);

            int diameter = 2 * r;
            Random R = new Random();
            int rgb1 = R.nextInt(255) + 1;
            int rgb2 = R.nextInt(255) + 1;
            int rgb3 = R.nextInt(255) + 1;
            g.fillOval(X - r, Y - r, diameter, diameter);
            g.setColor(new Color(rgb1, rgb2, rgb3));
        }
    }
}