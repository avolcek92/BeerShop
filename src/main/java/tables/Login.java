package tables;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static javax.swing.GroupLayout.Alignment.CENTER;
import static javax.swing.GroupLayout.Alignment.LEADING;

public class Login extends MyFrame {
    public void login() {

        //final JFrame frame = new JFrame("Login");
        JPanel panel = new JPanel();

        JLabel textLabel = new JLabel("Welcome to shop for Gentlemen Store!");
        JLabel textLabel0 = new JLabel("To buy Gentleman Elixir, please to login!");
        JLabel textLabel1 = new JLabel("Email         ");
        final JTextField prisijungimas = new JTextField();
        JLabel textLabel2 = new JLabel("Password");
        final JPasswordField slaptazodis = new JPasswordField();
        JButton button2 = new JButton("Login");
        JButton button1 = new JButton("Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GroupLayout stilius = new GroupLayout(panel);
        panel.setLayout(stilius);
        stilius.setAutoCreateGaps(true);
        stilius.setAutoCreateContainerGaps(true);

        stilius.setHorizontalGroup(stilius.createParallelGroup(CENTER)
                .addComponent(textLabel)
                .addComponent(textLabel0)
                .addGroup(stilius.createSequentialGroup()
                        .addComponent(textLabel1)
                        .addComponent(prisijungimas))
                .addGroup(stilius.createSequentialGroup()
                        .addComponent(textLabel2)
                        .addComponent(slaptazodis))
                .addGroup(stilius.createSequentialGroup()
                        .addComponent(button2)
                        .addComponent(button1)));
        stilius.setVerticalGroup(stilius.createSequentialGroup()
                .addComponent(textLabel)
                .addComponent(textLabel0)
                .addGroup(stilius.createParallelGroup(LEADING)
                        .addComponent(textLabel1)
                        .addComponent(prisijungimas))
                .addGroup(stilius.createParallelGroup(LEADING)
                        .addComponent(textLabel2)
                        .addComponent(slaptazodis))
                .addGroup(stilius.createParallelGroup(LEADING)
                        .addComponent(button1)
                        .addComponent(button2)));

        frame.setPreferredSize(new Dimension(300, 180));
        frame.setName("Login");
        frame.pack();
        frame.setVisible(true);
        frame.add(panel);
        setLocationToTopRight(frame);

        button1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        Registration registration = new Registration();
                        registration.registration();
                        frame.dispose();


                    }
                }
        );
        button2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        String email = prisijungimas.getText();
                        char[] password = slaptazodis.getPassword();
                        if (email.contains("@") & Arrays.toString(password).length() > 7 & Arrays.toString(password).matches(".*\\d+.*")) {
                        ReadFromFile readFromFile = new ReadFromFile(email,password,false);
                        try {
                            readFromFile.fileReader();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if(readFromFile.found==true){
                            frame.dispose();
                            EventQueue.invokeLater(new Runnable() {
                                public void run() {
                                    try {
                                        MyTable form=new MyTable();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            return;
                        }
                    }
                        JOptionPane.showMessageDialog(frame, "Wrong email or password","Alert",JOptionPane.WARNING_MESSAGE);
                    }
                }
        );
    }
}
