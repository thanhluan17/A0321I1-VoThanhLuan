package bean;

import java.util.Comparator;

public class ArrayListSort implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
    }
}

