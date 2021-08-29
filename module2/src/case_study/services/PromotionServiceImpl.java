package case_study.services;

import case_study.models.Booking;
import case_study.models.Customer;

import java.util.*;

public class PromotionServiceImpl implements PromotionService {
    Scanner scanner = new Scanner(System.in);
    BookingServiceImpl bookingService = new BookingServiceImpl();
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    private static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    @Override
    public void display() {
        bookingSet = bookingService.getBookingSet();
        System.out.println("Enter year you want to display: ");
        int year = scanner.nextInt();
        System.out.println("List customer use service in " + year + ": ");
        for (Booking booking : bookingSet) {
            if (Integer.parseInt(booking.getStartDate().substring(6)) == year) {
                getCustomerInfo(booking.getCustomerId());
            }
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
