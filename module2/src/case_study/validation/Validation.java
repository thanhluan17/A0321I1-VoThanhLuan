package case_study.validation;

import java.util.Scanner;

public class Validation {
    static Scanner scanner = new Scanner(System.in);

    public static String checkInput(String temp, String regex, String error) {
        boolean check = true;
        do {
            if (temp.matches(regex)) {
                check = false;
            } else {
                System.out.println(error + " Enter again: ");
                temp = scanner.nextLine();
            }
        } while (check);
        return temp;
    }
}
