package case_study.services;

import case_study.data.ReadAndWrite;
import case_study.models.Booking;
import case_study.models.Contract;

import java.util.*;

public class ContractServiceImpl implements ContactService {
    Scanner scanner = new Scanner(System.in);
    private static List<Contract> contractList = new ArrayList<>();
    BookingServiceImpl bookingService = new BookingServiceImpl();

    @Override
    public void display() {
        contractList = (List<Contract>) ReadAndWrite.readFile("src\\case_study\\data\\contract.csv");
        for (Contract contract : contractList) {
            System.out.println(contract.toString());
        }
    }

    @Override
    public void addNew() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = bookingService.getBookingSet();
        for (Booking booking : bookingSet) {
            bookingQueue.add(booking);
        }

        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            String customerId = booking.getCustomerId();
            String bookingId = booking.getBookingId();
            System.out.println("Create contract for customer id: " + customerId + ", booking id: " + bookingId);
            System.out.println("Enter contract id: ");
            String contractId = scanner.nextLine();
            System.out.println("Enter deposit money: ");
            double deposit = scanner.nextDouble();
            System.out.println("Enter total money: ");
            double total = scanner.nextDouble();
            scanner.skip("\\R");
            contractList.add(new Contract(contractId, bookingId, deposit, total, customerId));
            System.out.println("Add contract success!");
        }
        ReadAndWrite.writeFile(contractList, "src\\case_study\\data\\contract.csv");
    }

    @Override
    public void update() {
        String id;
        do {
            System.out.println("Enter contract id to update: ");
            id = scanner.nextLine();
            if (checkExist(id) == null) {
                System.out.println("Contract not exist! Enter again: ");
            }
        } while (checkExist(id) == null);
        Contract contract = checkExist(id);
        System.out.println("Enter new deposit: ");
        double deposit = scanner.nextDouble();
        System.out.println("Enter new total money: ");
        double total = scanner.nextDouble();
        contract.setDeposit(deposit);
        contract.setTotal(total);
        System.out.println("Update success!");
    }

    public Contract checkExist(String id) {
        for (Contract contract : contractList) {
            if (contract.getContractId().equals(id)) {
                return contract;
            }
        }
        return null;
    }
}
