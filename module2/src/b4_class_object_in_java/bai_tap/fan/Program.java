package b4_class_object_in_java.bai_tap.fan;

import static b4_class_object_in_java.bai_tap.fan.Fan.FAST;
import static b4_class_object_in_java.bai_tap.fan.Fan.MEDIUM;

public class Program {
    public static void main(String[] args) {
        Fan f1 = new Fan(FAST, true, 10, "yellow");
        Fan f2 = new Fan(MEDIUM, false, 5, "blue");
        System.out.println(f1.toString());
        System.out.println(f2.toString());
    }
}
