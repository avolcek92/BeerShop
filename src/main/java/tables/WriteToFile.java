package tables;

import java.io.FileWriter;

public class WriteToFile {
    String name;
    String email;
    String city;
    String address;
    char[] password;
    char[] password1;

    public WriteToFile( String name, String email,String address, String city, char[] password, char[] password1) {
        this.name = name;
        this.email = email;
        this.address=address;
        this.city = city;
        this.password = password;
        this.password1 = password1;

    }

    public void fileWriter() throws Exception{
        FileWriter fileWriter = new FileWriter("C:\\JAVA\\Projects\\MyOnlineShop\\src\\main\\resources\\file.txt", true);
        fileWriter.write("\n");
        fileWriter.write(name+" ");
        fileWriter.write(email+" ");
        fileWriter.write(address+" ");
        fileWriter.write(city+" ");
        fileWriter.write(password);
        fileWriter.close();


    }
}
