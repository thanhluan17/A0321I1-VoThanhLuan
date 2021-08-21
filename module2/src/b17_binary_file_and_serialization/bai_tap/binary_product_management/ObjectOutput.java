package b17_binary_file_and_serialization.bai_tap.binary_product_management;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutput {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("src/b17_binary_file_and_serialization/bai_tap/binary_product_management/data.dat");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            List<Product> products=new ArrayList<>();
            Product product1=new Product(1,"Washing machine","Sam Sung",5000000,"Clean your clothes");
            Product product2=new Product(2,"Refrigerator","Toshiba",4000000,"Freeze everything");
            Product product3=new Product(3,"Electric Fan","Fan",500000,"So cool");
            products.add(product1);
            products.add(product2);
            products.add(product3);
            objectOutputStream.writeObject(products);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
