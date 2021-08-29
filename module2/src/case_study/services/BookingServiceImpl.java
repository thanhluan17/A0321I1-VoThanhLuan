package case_study.services;

import case_study.models.Booking;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingServiceImpl implements BookingService {
    Scanner scanner = new Scanner(System.in);
    private static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
    FacilityServiceImpl facilityService = new FacilityServiceImpl();

    static {
        bookingSet.add(new Booking("001", "17/08/2020", "20/08/2021",
                "001", "001"));
        bookingSet.add(new Booking("002", "07/11/2020", "10/11/2020",
                "002", "003"));
    }

    @Override
    public void display() {
        for (Booking booking : bookingSet) {
            System.out.println(booking.toString());
        }
    }

    @Override
    public void addNew() {
        System.out.println("Enter booking id: ");
        String bookingId = scanner.nextLine();
        System.out.println("Enter start date: ");
        String startDate = scanner.nextLine();
        System.out.println("Enter end date: ");
        String endDate = scanner.nextLine();
        System.out.println("Choose id customer: ");
        String customerId = chooseCustomer();
        System.out.println("Choose id service: ");
        String serviceId = chooseFacility();
        bookingSet.add(new Booking(bookingId, startDate, endDate, customerId, serviceId));
        facilityService.updateRentedValue(serviceId);
        System.out.println("Book success!");
    }

    @Override
    public void update() {

    }

    public String chooseCustomer() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        System.out.println("List customer: ");
        customerService.display();
        String id;
        do {
            System.out.println("Enter customer id: ");
            id = scanner.nextLine();
            if (customerService.checkExist(id) == null) {
                System.out.println("Customer id not exist! Enter again: ");
            }
        } while (customerService.checkExist(id) == null);
        return id;
    }

    public String chooseFacility() {
        System.out.println("List Facility: ");
        facilityService.display();
        String id;
        do {
            System.out.println("Enter facility id: ");
            id = scanner.nextLine();
            if (facilityService.checkExist(id) == null) {
                System.out.println("Facility id not exist! Enter again: ");
            }
        } while (facilityService.checkExist(id) == null);
        return id;
    }

    public Set<Booking> getBookingSet() {
        return bookingSet;
    }
}
