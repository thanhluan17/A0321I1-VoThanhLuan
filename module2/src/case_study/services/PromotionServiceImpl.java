package case_study.services;

import case_study.models.Booking;
import case_study.models.Customer;
import case_study.ulti.BookingComparator;

import java.util.*;

public class PromotionServiceImpl implements PromotionService {
    Scanner scanner = new Scanner(System.in);
    BookingServiceImpl bookingService = new BookingServiceImpl();
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    private static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
    static Stack<Booking> bookingStack = new Stack<>();

    @Override
    public void display() {
    }

    @Override
    public void displayCustomerByYear() {
        bookingSet = bookingService.getBookingSet();
        System.out.println("Enter year you want to display: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("List customer use service in " + year + ": ");
        for (Booking booking : bookingSet) {
            if (Integer.parseInt(booking.getStartDate().substring(6)) == year) {
                getCustomerInfo(booking.getCustomerId());
            }
        }
    }

    @Override
    public void displayCustomerVoucher() {
        Set<Booking> bookingSet1 = new BookingServiceImpl().getBookingSet();
        try {
            System.out.println("number of vouchers 10%: ");
            int voucher10 = Integer.parseInt(scanner.nextLine());
            System.out.println("number of vouchers 20%: ");
            int voucher20 = Integer.parseInt(scanner.nextLine());
            System.out.println("number of vouchers 50%: ");
            int voucher50 = Integer.parseInt(scanner.nextLine());
            int totalVoucher = voucher10 + voucher20 + voucher50;
            int count = 0;

            Iterator<Booking> iterator = bookingSet1.iterator();
            while (iterator.hasNext() && count < totalVoucher) {
                bookingStack.push(iterator.next());
                count += 1;
            }


            System.out.println("list of booking receiving voucher 10%");
            for (int i = 0; i < voucher10; i++) {
                if (!bookingStack.isEmpty()) {
                    System.out.println(bookingStack.pop());
                }
            }

            System.out.println("list of booking receiving voucher 20%");
            for (int i = 0; i < voucher20; i++) {
                if (!bookingStack.isEmpty()) {
                    System.out.println(bookingStack.pop());
                }
            }

            System.out.println("list of booking receiving voucher 50%");
            for (int i = 0; i < voucher50; i++) {
                if (!bookingStack.isEmpty()) {
                    System.out.println(bookingStack.pop());
                }
            }

        } catch (NumberFormatException ex) {
            System.err.println("You entered wrong format!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNew() {

    }

    @Override
    public void update() {

    }

    public void getCustomerInfo(String customerId) {
        List<Customer> customerList = new LinkedList<>();
        customerList = customerService.getCustomerList();
        for (Customer customer : customerList) {
            if (customer.getCustomerId().equals(customerId)) {
                System.out.println(customer.toString());
            }
        }
    }
}
