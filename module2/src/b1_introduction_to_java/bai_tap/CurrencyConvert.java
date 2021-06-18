package b1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class CurrencyConvert {
    public static void main(String[] args) {
        double rate = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter money to convert (USD): ");
        double usd = scanner.nextDouble();
        double vnd = usd * rate;
        System.out.println(usd + " USD to VND = " + vnd + "VND");
    }
}
