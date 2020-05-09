package tables;

import javax.swing.*;
import java.awt.*;

public class Bacground extends JFrame {
    public static JFrame frame = new JFrame("Gentlemen Store");


         public Bacground()  {
             JLabel background=new JLabel(new ImageIcon("C:\\JAVA\\Projects\\MyOnlineShop\\src\\main\\resources\\image4.png"));
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
