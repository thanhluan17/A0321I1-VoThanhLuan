package b17_binary_file_and_serialization.bai_tap.binary_product_management;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectInput {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream=new FileInputStream("src/b17_binary_file_and_serialization/bai_tap/binary_product_management/data.dat");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            List<Product> products=(List<Product>) objectInputStream.readObject();
            for (Product product: products){
                System.out.println(product);
            }
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
