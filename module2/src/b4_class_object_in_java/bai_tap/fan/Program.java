package b4_class_object_in_java.bai_tap.fan;

public class Program {
    private static final int SLOW = 1;
    private static final int MEDIUM = 2;
    private static final int FAST = 3;

    public static void main(String[] args) {
        Fan f1 = new Fan(FAST, true, 10, "yellow");
        Fan f2 = new Fan(MEDIUM, false, 5, "blue");
        System.out.println(f1.toString());
        System.out.println(f2.toString());
    }
}
