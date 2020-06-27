package tables;


import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFromFile {
    String email;
    char [] password;
    boolean found = false;

    public ReadFromFile(String email, char[] password, boolean found) {
        this.email = email;
        this.password = password;
        this.found=found;
    }

    public void fileReader() throws Exception {
        BufferedReader fileReader = new BufferedReader(new FileReader("src\\main\\resources\\file.txt"));
        String line;
        String pass = String.valueOf(password);
        while((line = fileReader.readLine()) !=null){
            if(line.contains(" "+email+" ")&&line.contains(" "+pass+"")) {
                found = true;
            }
        }
    }
}


