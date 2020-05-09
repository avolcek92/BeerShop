package tables;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MyTable extends MyFrame {
    Bacground bacground = new Bacground();
    public MyTable() throws Exception {

        bacground.closeBackground();
       // JFrame frame = new JFrame("Gentlemen Store");
        frame.setName("Gentlemen Store");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(657,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JScrollPane scroll=new JScrollPane();
        scroll.setSize(400,400);
        frame.add(scroll, BorderLayout.CENTER);

        final JTable table=new JTable();
        scroll.setViewportView(table);

        JPanel panel2=new JPanel(new FlowLayout(FlowLayout.CENTER, 0,0));
        panel2.setBackground(Color.white);
        frame.add(panel2, BorderLayout.NORTH);
        int width =frame.getWidth()/256;
        for(int i = 0; i<width;i++) {
            JLabel background =  new JLabel(new ImageIcon("C:\\JAVA\\Projects\\MyOnlineShop\\src\\main\\resources\\1.jfif"));
            panel2.add(background);

        }
        JPanel panel=new JPanel();
        frame.add(panel, BorderLayout.SOUTH);
        panel.setBackground(Color.white);

        JButton btnCart=new JButton("Add to Cart");
        panel.add(btnCart);
        JButton btnOrder=new JButton("Go to Order");;
        panel.add(btnOrder);
        JButton btnLogOut=new JButton("Logout");
        panel.add(btnLogOut);
        JButton btnExit=new JButton("Exit");
        panel.add(btnExit);

        final DefaultTableModel model=new DefaultTableModel(){
            public Class<?> getColumnClass(int column)
            {
                switch(column)
                {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Double.class;
                    case 3:
                        return Double.class;
                    case 4:
                        return Boolean.class;
                    case 5:
                        return Integer.class;

                    default:
                        return String.class;
                }
            }
            public boolean isCellEditable(int row, int column) {
                if(column<4){
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
        model.addColumn("Select");
        model.addColumn("Quantity");

        final ReadFromBeerStock readFromBeerStock = new ReadFromBeerStock();
        readFromBeerStock.beerstockReader();
        for(int i=0;i<readFromBeerStock.file.size();i++)
            model.addRow((readFromBeerStock.file.get(i)));

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);

            }});
        btnCart.addActionListener(
                new ActionListener() {
                    public void actionPerformed  (ActionEvent evt) {
                        //System.out.println((String) Arrays.toString(table.getSelectedRows()));
                        List<String> column1 = new ArrayList<String>();
                        List<String> column2 = new ArrayList<String>();
                        List<String> column3 = new ArrayList<String>();
                        List<Double> column4 = new ArrayList<Double>();
                        List<String> column5 = new ArrayList<String>();
                        List<Integer> column6 = new ArrayList<Integer>();
                        for (int count = 0; count < model.getRowCount(); count++) {
                            column1.add(model.getValueAt(count, 0).toString());
                            column2.add(model.getValueAt(count, 1).toString());
                            column3.add(model.getValueAt(count, 2).toString());
                            column4.add((Double)(model.getValueAt(count, 3)));
                            column5.add(model.getValueAt(count, 4).toString());
                            column6.add((Integer)(model.getValueAt(count, 5)));
                        }
                        Double sumRow=null;
                        for (int i = 0; i < column5.size(); i++) {
                            if (column5.get(i).equals("true")) {
                                Object[] bag = new Object[]{column1.get(i), column2.get(i), column3.get(i), column4.get(i), column6.get(i)};
                                fullBag.add(bag);
                                 sumRow= column4.get(i)*column6.get(i);
                                 sum=sum+sumRow;

                            }

                        }
                        for (Object[] a : fullBag) {
                            System.out.println((String) Arrays.toString(a));
                        }


                        //System.out.println(bag);

                    }});

        btnLogOut.addActionListener(
                new ActionListener() {
                    public void actionPerformed  (ActionEvent evt) {

                    }});
        btnOrder.addActionListener(
                new ActionListener() {
                    public void actionPerformed  (ActionEvent evt) {
                        OrderedBag orderedBag= new OrderedBag();
                            orderedBag.orderedBag();
                            frame.dispose();

                    }});
    }

}
