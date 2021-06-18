package b2_loop_in_java.thuc_hanh;

import java.util.Scanner;

public class InterestRate {
    public static void main(String[] args) {
        double money = 0;
        int month = 0;
        double rate = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter investment amount: ");
        money = input.nextDouble();
        System.out.println("Enter number of months: ");
        month = input.nextInt();
        System.out.println("Enter annual interest rate in percentage: ");
        rate = input.nextDouble();
        double interestMoney = 0;
        for (int i = 0; i < month; i++) {
            interestMoney += money * (rate / 100) / 12 * month;
        }
        System.out.println("Total of interest: " + interestMoney);
    }
}
