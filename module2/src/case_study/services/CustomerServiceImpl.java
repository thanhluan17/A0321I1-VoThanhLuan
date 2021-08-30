package case_study.services;

import case_study.data.ReadAndWrite;
import case_study.models.Customer;
import case_study.ulti.Validation;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class CustomerServiceImpl implements CustomerService {
    private static final String REGEX_AGE_DOB = "/^(0?[1-9]|1[012])[- /.](0?[1-9]|[12][0-9]|3[01])[- /.](19|20)?[0-9]{2}$/";
    private static List<Customer> customerList;
    private static Scanner scanner = new Scanner(System.in);

    static {
        customerList = new LinkedList<>();
        customerList.add(new Customer("Vo Thanh Luan", "17/01/2000", true, "212464739",
                "0383422211", "naul17@gmail.com", "001", "Diamond", "Quang Ngai"));
        customerList.add(new Customer("Nguyen Van B", "09/09/2000", true, "212371625",
                "0383361721", "nguyen71@gmail.com", "002", "Gold", "Da Nang"));
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public Customer checkExist(String id) {
        for (Customer customer : customerList) {
            if (customer.getCustomerId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void display() {
        customerList = (List<Customer>) ReadAndWrite.readFile("src\\case_study\\data\\customer.csv");
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void addNew() {
        String customerId;
        do {
            System.out.println("Enter customer id: ");
            customerId = scanner.nextLine();
            if (checkExist(customerId) != null) {
                System.out.println("Id existed! Enter again: ");
            }
        } while (checkExist(customerId) != null);
        System.out.println("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.println("Enter date of birth: ");
        String dob = scanner.nextLine();
        int checkGender;
        System.out.println("Enter customer gender: '1' for male, '0' for female!");
        checkGender = scanner.nextInt();
        boolean gender = true;
        if (checkGender == 0) {
            gender = false;
        }
        scanner.skip("\\R");
        System.out.println("Enter identity number: ");
        String identity = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.println("Enter email address: ");
        String email = scanner.nextLine();
        System.out.println("Enter customer type: ");
        String cusType = scanner.nextLine();
        System.out.println("Enter customer address: ");
        String address = scanner.nextLine();
        customerList.add(new Customer(name, dob, gender, identity, phone, email, customerId, cusType, address));
        ReadAndWrite.writeFile(customerList, "src\\case_study\\data\\customer.csv");
        System.out.println("Add success!");
    }

    @Override
    public void update() {
        String id;
        do {
            System.out.println("Enter customer id to edit: ");
            id = scanner.nextLine();
            if (checkExist(id) == null) {
                System.out.println("Customer not exist! Enter again: ");
            }
        } while (checkExist(id) == null);
        Customer customer = checkExist(id);
        int choice = -1;
        do {
            System.out.println("Select info want to edit: ");
            System.out.println("1. Phone number");
            System.out.println("2. Email");
            System.out.println("3. Customer type");
            System.out.println("4. Address");
            System.out.println("5. Return to main menu");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.skip("\\R");
            switch (choice) {
                case 1:
                    System.out.println("Enter new phone number: ");
                    String phone = scanner.nextLine();
                    customer.setPhoneNumber(phone);
                    break;
                case 2:
                    System.out.println("Enter new phone email address: ");
                    String email = scanner.nextLine();
                    customer.setEmail(email);
                    break;
                case 3:
                    System.out.println("Enter new customer type: ");
                    String cusType = scanner.nextLine();
                    customer.setCusType(cusType);
                    break;
                case 4:
                    System.out.println("Enter new address: ");
                    String address = scanner.nextLine();
                    customer.setAddress(address);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice! Exit!");
            }
        } while (true);
    }

    private String checkDoB() {
        return Validation.checkDateOfBirth(scanner.nextLine(), REGEX_AGE_DOB);
    }
}
