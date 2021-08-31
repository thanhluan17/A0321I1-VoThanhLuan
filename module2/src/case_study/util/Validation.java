package case_study.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

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

    public static String checkDateOfBirth(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(temp, formatter);
                    LocalDate now = LocalDate.now();

                    int current = Period.between(age, now).getYears();
                    if (current < 100 && current > 18) {
                        check = false;
                    } else {
                        throw new AgeException("Age > 18 and Age < 100! Enter again: ");
                    }
                } else {
                    throw new AgeException("Invalid date! Enter again: ");
                }
            } catch (AgeException ex) {
                System.out.println(ex.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }
}
