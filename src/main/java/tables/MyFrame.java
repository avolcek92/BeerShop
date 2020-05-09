package tables;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class MyFrame  extends JFrame {
    public static List<Object[]> fullBag = new ArrayList<Object[]>();
    JFrame frame = new JFrame();
    public static double sum;



    static void setLocationToTopRight(JFrame frame) {
        GraphicsConfiguration config = frame.getGraphicsConfiguration();
        Rectangle bounds = config.getBounds();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(config);
        int x = bounds.x + bounds.width - insets.right - frame.getWidth();
        int y = bounds.y + insets.top;
        frame.setLocation(x - 30, y + 50);
    }

}