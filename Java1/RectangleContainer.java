import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RectangleContainer extends Frame {
    Rectangle[] RectangleArray;

    RectangleContainer() throws IOException {
        super("Rectangle");
        this.setSize(1024, 768);
        this.setBackground(Color.WHITE);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                RectangleContainer.this.dispose();
            }
        });
        this.init();
    }

    void init() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ilkoi\\Desktop\\textovFail.txt"));
        String line = reader.readLine();
        int numRect = Integer.parseInt(line);
        Rectangle[] ArrRect = new Rectangle[numRect];

        for(int i = 0; i < numRect; ++i) {
            line = reader.readLine();
            String[] numbers = line.split(" ");
            int x1 = Integer.parseInt(numbers[0]);
            int y1 = Integer.parseInt(numbers[1]);
            int x2 = Integer.parseInt(numbers[2]);
            int y2 = Integer.parseInt(numbers[3]);
            ArrRect[i] = new Rectangle(x1, y1, x2, y2);
        }

        reader.close();
        this.RectangleArray = ArrRect;
        this.repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);

        for(int i = 0; i < this.RectangleArray.length; ++i) {
            int x1 = this.RectangleArray[i].x1;
            int y1 = this.RectangleArray[i].y1;
            int x2 = this.RectangleArray[i].x2;
            int y2 = this.RectangleArray[i].y2;
            g.drawLine(x1, y1, x1, y2);
            g.drawLine(x2, y1, x2, y2);
            g.drawLine(x1, y1, x2, y1);
            g.drawLine(x1, y2, x2, y2);
        }

    }
}