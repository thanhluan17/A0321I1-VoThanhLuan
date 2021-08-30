package case_study.services;

import case_study.data.ReadAndWrite;
import case_study.models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employeeList;
    private static Scanner scanner = new Scanner(System.in);

    static {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("Vo Thanh Luan", "17/01/2000", true, "212464739",
                "0383422211", "thanhluandev17@gmail.com", "001", "College", "IT", 1000));
        employeeList.add(new Employee("Nguyen Van A", "21/12/2000", true, "212371683",
                "0332718476", "anguyen31@gmail.com", "002", "College", "IT", 1000));
    }

    public Employee checkExist(String id) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public void display() {
        //employeeList = (List<Employee>) ReadAndWrite.readFile("src\\case_study\\data\\employee.csv");
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public void addNew() {
        String employeeId;
        do {
            System.out.println("Enter employee id: ");
            employeeId = scanner.nextLine();
            if (checkExist(employeeId) != null) {
                System.out.println("Id existed! Enter again: ");
            }
        } while (checkExist(employeeId) != null);
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.println("Enter date of birth: ");
        String dob = scanner.nextLine();
        int checkGender;
        System.out.println("Enter employee gender: '1' for male, '0' for female!");
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
        System.out.println("Enter eduction: ");
        String education = scanner.nextLine();
        System.out.println("Enter employee position: ");
        String position = scanner.nextLine();
        System.out.println("Enter salary: ");
        int salary = scanner.nextInt();
        scanner.skip("\\R");
        employeeList.add(new Employee(name, dob, gender, identity, phone, email, employeeId, education, position, salary));
        ReadAndWrite.writeFile(employeeList, "src\\case_study\\data\\employee.csv");
        System.out.println("Add success!");
    }

    @Override
    public void update() {
        String id;
        do {
            System.out.println("Enter employee id to edit: ");
            id = scanner.nextLine();
            if (checkExist(id) == null) {
                System.out.println("Employee not exist! Enter again: ");
            }
        } while (checkExist(id) == null);
        Employee employee = checkExist(id);
        int choice = -1;
        do {
            System.out.println("Select info want to edit: ");
            System.out.println("1. Phone number");
            System.out.println("2. Email");
            System.out.println("3. Position");
            System.out.println("4. Salary");
            System.out.println("5. Return to main menu");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.skip("\\R");
            switch (choice) {
                case 1:
                    System.out.println("Enter new phone number: ");
                    String phone = scanner.nextLine();
                    employee.setPhoneNumber(phone);
                    break;
                case 2:
                    System.out.println("Enter new phone email address: ");
                    String email = scanner.nextLine();
                    employee.setEmail(email);
                    break;
                case 3:
                    System.out.println("Enter new position: ");
                    String position = scanner.nextLine();
                    employee.setPosition(position);
                    break;
                case 4:
                    System.out.println("Enter new salary: ");
                    int salary = scanner.nextInt();
                    employee.setSalary(salary);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice! Exit!");
            }
        } while (true);
    }
}
