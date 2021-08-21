package b16_io_text_file.bai_tap.read_file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static final String FILE_SOURCE = "D:\\Codegym\\A0321I1-VoThanhLuan\\module2\\src\\b16_io_text_file\\bai_tap\\read_file\\country.csv";
    public static final String COMMA = ",";

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(FILE_SOURCE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
