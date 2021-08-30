package b18_string_and_regex.bai_tap.validate_class_name;

import java.util.Scanner;

public class ClassExampleTest {
    private static final ClassExample classExample = new ClassExample();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter class name to check: ");
        String className = scanner.nextLine();
        boolean isValid = classExample.validate(className);
        System.out.println("Class name: " + className + ", isValid: " + isValid);
    }
}
