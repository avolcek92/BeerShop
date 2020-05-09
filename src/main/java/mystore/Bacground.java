package mystore;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Bacground extends JFrame {
    public static JFrame frame = new JFrame("Gentlemen Store");


         public Bacground()  {
             JLabel background=new JLabel(new ImageIcon("C:\\JAVA\\Projects\\image4.png"));
             frame.setLayout(new BorderLayout());
             frame.add(background);
             background.setLayout(new FlowLayout());
             frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
             frame.disable();
             frame.setVisible(true);
    }


    public void closeBackground(){
      frame.dispose();




    }
}
