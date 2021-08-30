package b18_string_and_regex.bai_tap.validate_phone_number;

import java.util.Scanner;

public class PhoneNumberExampleTest {
    private static final PhoneNumberExample phoneNumberExample = new PhoneNumberExample();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter class name to check: ");
        String phoneNumber = scanner.nextLine();
        boolean isValid = phoneNumberExample.validate(phoneNumber);
        System.out.println("Class name: " + phoneNumber + ", isValid: " + isValid);
    }
}
