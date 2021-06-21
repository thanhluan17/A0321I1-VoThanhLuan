package b2_loop_in_java.bai_tap;

public class DisplayPrime2Assign {
    public static boolean checkPrime(int number) {
        int count = 0;
        if (number >= 2) {
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int count = 0;
        int number = 0;
        System.out.println("20 first prime number: \n");
        while (count < 20) {
            if (checkPrime(number)) {
                System.out.println(number);
                count += 1;
            }
            number += 1;
        }
        System.out.println("First prime number less than 100: \n");
        number = 0;
        while (number <= 100) {
            if (checkPrime(number)) {
                System.out.println(number);
                count += 1;
            }
            number += 1;
        }
    }
}
