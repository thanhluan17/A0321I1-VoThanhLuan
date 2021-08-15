package b16_io_text_file.bai_tap.copy_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {

    public static final String FILE_TARGET = "D:\\Codegym\\A0321I1-VoThanhLuan\\module2\\src\\b16_io_text_file\\bai_tap\\copy_file\\country1.csv";
    public static final String FILE_SOURCE = "D:\\Codegym\\A0321I1-VoThanhLuan\\module2\\src\\b16_io_text_file\\bai_tap\\copy_file\\country.csv";
    public static final String COMMA = ",";

    public static void writeCSV(List list) {
        File file = new File(FILE_TARGET);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(list);
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List readCSV() {
        List list = new ArrayList();
        File file = new File(FILE_SOURCE);
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(COMMA);
                String infoCountry = null;
                for (int i = 0; i < 6; i++) {
                    infoCountry = infoCountry + country[i];
                }
                list.add(infoCountry);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }

    public static void main(String[] args) {
        File inputFile = new File(FILE_SOURCE);
        File outputFile = new File(FILE_TARGET);
        if (!inputFile.exists() && outputFile.exists()) {
            System.out.println("Source file doesn't exist and Destination file exists.");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter(outputFile)));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                bufferedWriter.write(line);
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


