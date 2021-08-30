package case_study.controllers;

import case_study.services.*;

import java.util.Scanner;

public class FuramaController {
    Scanner scanner = new Scanner(System.in);
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    FacilityServiceImpl facilityService = new FacilityServiceImpl();
    BookingServiceImpl bookingService = new BookingServiceImpl();
    ContractServiceImpl contractService = new ContractServiceImpl();
    PromotionServiceImpl promotionService = new PromotionServiceImpl();
    int choice;

    public void displayMainMenu() {
        System.out.println("-----Main Menu-----");
        System.out.println("1. Employee Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Facility Management");
        System.out.println("4. Booking Management");
        System.out.println("5. Promotion  Management");
        System.out.println("6. Exit");
        System.out.println("-----------------");
        System.out.print("Enter your choice: ");
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice! Enter again!");
            displayMainMenu();
        }
        switch (choice) {
            case 1:
                employeeManagement();
                break;
            case 2:
                customerManagement();
                break;
            case 3:
                facilityManagement();
                break;
            case 4:
                bookingManagement();
                break;
            case 5:
                promotionManagement();
                break;
            case 6:
                System.exit(0);
        }
    }

    public void employeeManagement() {
        do {
            System.out.println("-----Employee Menu-----");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return main menu");
            System.out.println("-----------------");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice! Enter again!");
                employeeManagement();
            }
            switch (choice) {
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.addNew();
                    break;
                case 3:
                    employeeService.update();
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        } while (true);
    }

    public void customerManagement() {
        do {
            System.out.println("-----Customer Menu-----");
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Return main menu");
            System.out.println("-----------------");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice! Enter again!");
                customerManagement();
            }
            switch (choice) {
                case 1:
                    customerService.display();
                    break;
                case 2:
                    customerService.addNew();
                    break;
                case 3:
                    customerService.update();
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        } while (true);

    }

    public void facilityManagement() {
        do {
            System.out.println("-----Facility Menu-----");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display facility need maintain");
            System.out.println("4. Return main menu");
            System.out.println("-----------------");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice! Enter again!");
                facilityManagement();
            }
            switch (choice) {
                case 1:
                    facilityService.display();
                    break;
                case 2:
                    facilityService.addNew();
                    break;
                case 3:
                    facilityService.displayMaintain();
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        } while (true);

    }

    public void bookingManagement() {
        do {
            System.out.println("-----Booking Menu-----");
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new contract");
            System.out.println("4. Display list contract");
            System.out.println("5. Edit contract");
            System.out.println("6. Return main menu");
            System.out.println("-----------------");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice! Enter again!");
                bookingManagement();
            }
            switch (choice) {
                case 1:
                    bookingService.addNew();
                    break;
                case 2:
                    bookingService.display();
                    break;
                case 3:
                    contractService.addNew();
                    break;
                case 4:
                    contractService.display();
                    break;
                case 5:
                    contractService.update();
                    break;
                case 6:
                    displayMainMenu();
                    break;
            }
        } while (true);
    }

    public void promotionManagement() {
        do {
            System.out.println("-----Promotion Menu-----");
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            System.out.println("-----------------");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice! Enter again!");
                promotionManagement();
            }
            switch (choice) {
                case 1:
                    promotionService.display();
                    break;
                case 2:
                    break;
                case 3:
                    displayMainMenu();
                    break;
            }
        } while (true);

    }
}
