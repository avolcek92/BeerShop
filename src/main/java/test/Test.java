package test;

import java.awt.FlowLayout;
import javax.swing.*;
import java.io.IOException;
import java.io.*;
import javax.imageio.*;

public class Test extends JFrame {

    public Test(){
        super("window");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\JAVA\\Projects\\image4.png")))));

        }catch(IOException e)
        {
            e.printStackTrace();

        }
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {

        Test t = new Test();

    }
}