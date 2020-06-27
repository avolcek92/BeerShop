package tables;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;


public class OrderedBag extends MyFrame {


    public void orderedBag()  {

        Bacground bacground = new Bacground();
        frame.setName("Cart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLocation(880,100);
        frame.setVisible(true);


        JPanel panel = new JPanel();
        JLabel label = new JLabel("Amount is: "+sum);
        JButton button = new JButton("Go to Pay");
        frame.add(panel, BorderLayout.SOUTH);
        panel.setBackground(Color.white);
        panel.add(label);
        panel.add(button);
        //panel.add(button1);
        JPanel panel1 = new JPanel();
        frame.add(panel1, BorderLayout.NORTH);
        panel1.setBackground(Color.white);

        JScrollPane scroll = new JScrollPane();
        scroll.setSize(400, 400);
        frame.add(scroll, BorderLayout.CENTER);


        final JTable table = new JTable();
        scroll.setViewportView(table);

        final DefaultTableModel model = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return Double.class;
                    case 4:
                        return Integer.class;

                    default:
                        return String.class;
                }
            }

            public boolean isCellEditable(int row, int column) {
                if (column < 6) {
                    return false;
                }
                return true;
            }
        };


        table.setModel(model);
        model.addColumn("Name");
        model.addColumn("Type");
        model.addColumn("Strong");
        model.addColumn("Price");
        model.addColumn("Quantity");


        for (Object[] a : fullBag) {
            System.out.println((String) Arrays.toString(a));
        }

        for (int i = 0; i <fullBag.size(); i++) {
            model.addRow((fullBag.get(i)));

        }
    }
}


