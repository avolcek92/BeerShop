package tables;
import org.apache.commons.lang.StringUtils;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ReadFromBeerStock {
    List <Object[]> file = new ArrayList<Object[]>();
    public void beerstockReader() throws Exception {
        String name;
        String type;
        Double strong;
        Double price;


        BufferedReader fileReader = new BufferedReader(new FileReader("C:\\JAVA\\Projects\\BeerStock.txt"));
        String line;

        while ((line = fileReader.readLine()) != null) {
            String[] list = StringUtils.split(line, "/");
            name = (String) Array.get(list, 0);
            type = (String) Array.get(list, 1);
            strong = Double.parseDouble((String) Array.get(list, 2));
            price = Double.parseDouble((String) Array.get(list, 3));
            int quantity =1;
            Object[] lines = new Object[]{name, type, strong, price, false, quantity };
            file.add(lines);
        }
        }


    }

