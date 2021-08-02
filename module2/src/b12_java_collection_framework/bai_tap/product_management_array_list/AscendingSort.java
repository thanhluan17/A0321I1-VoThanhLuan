package b12_java_collection_framework.bai_tap.product_management_array_list;

import java.util.Comparator;

public class AscendingSort implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() > o2.getId()) {
            return 1;
        } else if (o1.getPrice() == o2.getId()) {
            return 0;
        } else {
            return -1;
        }
    }
}
