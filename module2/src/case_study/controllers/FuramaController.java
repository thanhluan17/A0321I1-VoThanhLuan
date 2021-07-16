package case_study.controllers;

import java.util.Scanner;

public class FuramaController {
    Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        System.out.println("-----Main Menu-----");
        System.out.println("1. Employee Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Facility  Management");
        System.out.println("4. Booking Management");
        System.out.println("5. Promotion  Management");
        System.out.println("6. Exit");
        System.out.println("-----------------");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                employeeManagement();
                break;
            case "2":
                customerManagement();
                break;
            case "3":
                facilityManagement();
                break;
            case "4":
                bookingManagement();
                break;
            case "5":
                promotionManagement();
                break;
            case "6":
                System.exit(0);
            default:
                System.out.println("Invalid selection! Input selection to continue.");
                scanner.nextLine();
                displayMainMenu();
        }
    }

    public void employeeManagement() {
        System.out.println("-----Employee Menu-----");
        System.out.println("1. Display list employees");
        System.out.println("2. Add new employee");
        System.out.println("3. Edit employee");
        System.out.println("4. Return main menu");
        System.out.println("-----------------");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();
    }

    public void customerManagement() {
        System.out.println("-----Customer Menu-----");
        System.out.println("1. Display list customers");
        System.out.println("2. Add new customer");
        System.out.println("3. Edit customer");
        System.out.println("4. Return main menu");
        System.out.println("-----------------");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();
    }

    public void facilityManagement() {
        System.out.println("-----Facility Menu-----");
        System.out.println("1. Display list facility");
        System.out.println("2. Add new facility");
        System.out.println("3. Edit facility maintenance");
        System.out.println("4. Return main menu");
        System.out.println("-----------------");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();
    }

    public void bookingManagement() {
        System.out.println("-----Booking Menu-----");
        System.out.println("1. Add new booking");
        System.out.println("2. Display list booking");
        System.out.println("3. Create new contracts");
        System.out.println("4. Display list contracts");
        System.out.println("5. Edit contracts");
        System.out.println("6. Return main menu");
        System.out.println("-----------------");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();
    }

    public void promotionManagement() {
        System.out.println("-----Promotion Menu-----");
        System.out.println("1. Display list customers use service");
        System.out.println("2. Display list customers get voucher");
        System.out.println("3. Return main menu");
        System.out.println("-----------------");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();
    }

}