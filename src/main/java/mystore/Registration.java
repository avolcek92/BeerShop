package mystore;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static javax.swing.GroupLayout.Alignment.LEADING;


public class Registration extends MyFrame {
    Bacground bacground = new Bacground();
    public void registration()  {
        //final JFrame frame = new JFrame("Registration");
        JPanel panel = new JPanel();
        JLabel komentaras = new JLabel("Create cool man account");
        JLabel komentaras1 = new JLabel("Name, Lastname");
        final JTextField pavadinimas = new JTextField();
        JLabel komentaras2 = new JLabel("E-mail");
        final JTextField pastas = new JTextField();
        final JLabel miestas = new JLabel("City");
        final JTextField miestass = new JTextField("");
        JLabel komentaras3 = new JLabel("Address");
        final JTextField adresas = new JTextField("");
        JLabel komentaras6 = new JLabel("Password");
        final JPasswordField slaptazodis = new JPasswordField();
        JLabel komentaras7 = new JLabel("Confirm password");
         final JPasswordField slaptazodis2 = new JPasswordField();
        JButton button1 = new JButton("Register now");
        JButton button2 = new JButton("Cancel");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GroupLayout stilius = new GroupLayout(panel);
        panel.setLayout(stilius);
        stilius.setAutoCreateGaps(true);
        stilius.setAutoCreateContainerGaps(true);
        stilius.setHorizontalGroup(stilius.createParallelGroup(LEADING)
                .addComponent(komentaras)
                .addComponent(komentaras1)
                .addComponent(pavadinimas)
                .addComponent(komentaras2)
                .addComponent(pastas)
                .addComponent(miestas)
                .addComponent(miestass)
                .addComponent(komentaras3)
                .addComponent(adresas)
                .addComponent(komentaras6)
                .addComponent(slaptazodis)
                .addComponent(komentaras7)
                .addComponent(slaptazodis2)
                .addGroup(stilius.createSequentialGroup()
                        .addComponent(button1)
                        .addComponent(button2)));
        stilius.setVerticalGroup(stilius.createSequentialGroup()
                .addComponent(komentaras)
                .addComponent(komentaras1)
                .addComponent(pavadinimas)
                .addComponent(komentaras2)
                .addComponent(pastas)
                .addComponent(miestas)
                .addComponent(miestass)
                .addComponent(komentaras3)
                .addComponent(adresas)
                .addComponent(komentaras6)
                .addComponent(slaptazodis)
                .addComponent(komentaras7)
                .addComponent(slaptazodis2)
                .addGroup(stilius.createParallelGroup(LEADING)
                        .addComponent(button2)
                        .addComponent(button1)));

        frame.setName("Registration");
        frame.setPreferredSize(new Dimension(400, 400));
        frame.pack();
        frame.setVisible(true);
        frame.add(panel);
        setLocationToTopRight(frame);

        button2.addActionListener(
                new ActionListener() {
                    public void actionPerformed  (ActionEvent evt) {
                        frame.dispose();
                        bacground.closeBackground();
                    }}
        );
        button1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                       String name = pavadinimas.getText();
                       String email = pastas.getText();
                       String address = adresas.getText();
                       String city = miestass.getText();
                       char[] password = slaptazodis.getPassword();
                       char[] password1 = slaptazodis2.getPassword();
                       if (Arrays.toString(password).equals(Arrays.toString(password1)) & email.contains("@") & Arrays.toString(password).length() > 7 & Arrays.toString(password).matches(".*\\d+.*")) {
                            WriteToFile writeToFile = new WriteToFile(name,email,address,city,password,password1);
                             try {
                                 writeToFile.fileWriter();
                           } catch (Exception e) {
                                 e.printStackTrace();
                            }
                           JOptionPane.showMessageDialog(frame, "Registration is successful","Alert",JOptionPane.WARNING_MESSAGE);
                           Login login = new Login();
                           login.login();
                           frame.dispose();


                        }
                        else {
                           JOptionPane.showMessageDialog(frame, "Wrong email or password","Alert",JOptionPane.WARNING_MESSAGE);



                        }
                    }
                }
        );


    }
}
