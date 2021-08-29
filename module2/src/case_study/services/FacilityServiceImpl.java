package case_study.services;

import case_study.models.Facility;
import case_study.models.House;
import case_study.models.Room;
import case_study.models.Villa;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    Scanner scanner = new Scanner(System.in);
    private static Map<Facility, Integer> facilityIntegerMap;

    static {
        facilityIntegerMap = new LinkedHashMap<>();
        facilityIntegerMap.put(new Villa("001", "VillaA", 100, 1000, 5, "Day",
                "5 star", 20, 2), 5);
        facilityIntegerMap.put(new House("002", "HouseA", 150, 700, 10, "Month", "4 star", 3), 0);
        facilityIntegerMap.put(new Room("003", "RoomA", 50, 300, 3, "Day",
                "Free food"), 0);
    }

    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> facility : facilityIntegerMap.entrySet()) {
            System.out.println("Service: " + facility.getKey() + " - Rented count: " + facility.getValue());
        }
    }

    @Override
    public void addNew() {
        int choice;
        do {
            System.out.println("1. Add new Villa");
            System.out.println("2. Add new House");
            System.out.println("3. Add new Room");
            System.out.println("4. Back to menu");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.skip("\\R");
            switch (choice) {
                case 1:
                    addVilla();
                    break;
                case 2:
                    addHouse();
                    break;
                case 3:
                    addRoom();
                    break;
                case 4:
                    return;
            }
        } while (true);

    }

    @Override
    public void update() {

    }

    @Override
    public void displayMaintain() {
        for (Map.Entry<Facility, Integer> facility : facilityIntegerMap.entrySet()) {
            if (facility.getValue() >= 5) {
                System.out.println("Service: " + facility.getKey() + " - Rented count: " + facility.getValue());
            }
        }
    }

    @Override
    public void addVilla() {
        String villaId;
        do {
            System.out.println("Enter Villa service id: ");
            villaId = scanner.nextLine();
            if (checkExist(villaId) != null) {
                System.out.println("Id service existed!");
            }
        } while (checkExist(villaId) != null);
        System.out.println("Enter Villa name: ");
        String name = scanner.nextLine();
        System.out.println("Enter usable area: ");
        double usableArea = scanner.nextDouble();
        System.out.println("Enter rent cost: ");
        float rentCost = scanner.nextFloat();
        System.out.println("Enter max customer: ");
        int maxCustomer = scanner.nextInt();
        scanner.skip("\\R");
        System.out.println("Enter rent type: ");
        String rentType = scanner.nextLine();
        System.out.println("Enter standard: ");
        String standard = scanner.nextLine();
        System.out.println("Enter pool area: ");
        double poolArea = scanner.nextDouble();
        System.out.println("Enter floor number: ");
        int floorNumber = scanner.nextInt();
        facilityIntegerMap.put(new Villa(villaId, name, usableArea, rentCost, maxCustomer, rentType, standard, poolArea, floorNumber), 0);
        System.out.println("Add success!");
    }

    @Override
    public void addHouse() {
        String houseId;
        do {
            System.out.println("Enter House service id: ");
            houseId = scanner.nextLine();
            if (checkExist(houseId) != null) {
                System.out.println("Id service existed!");
            }
        } while (checkExist(houseId) != null);
        System.out.println("Enter House name: ");
        String name = scanner.nextLine();
        System.out.println("Enter usable area: ");
        double usableArea = scanner.nextDouble();
        System.out.println("Enter rent cost: ");
        float rentCost = scanner.nextFloat();
        System.out.println("Enter max customer: ");
        int maxCustomer = scanner.nextInt();
        scanner.skip("\\R");
        System.out.println("Enter rent type: ");
        String rentType = scanner.nextLine();
        System.out.println("Enter standard: ");
        String standard = scanner.nextLine();
        System.out.println("Enter floor number: ");
        int floorNumber = scanner.nextInt();
        facilityIntegerMap.put(new House(houseId, name, usableArea, rentCost, maxCustomer, rentType, standard, floorNumber), 0);
        System.out.println("Add success!");
    }

    @Override
    public void addRoom() {
        String roomId;
        do {
            System.out.println("Enter Room service id: ");
            roomId = scanner.nextLine();
            if (checkExist(roomId) != null) {
                System.out.println("Id service existed!");
            }
        } while (checkExist(roomId) != null);
        System.out.println("Enter Room name: ");
        String name = scanner.nextLine();
        System.out.println("Enter usable area: ");
        double usableArea = scanner.nextDouble();
        System.out.println("Enter rent cost: ");
        float rentCost = scanner.nextFloat();
        System.out.println("Enter max customer: ");
        int maxCustomer = scanner.nextInt();
        scanner.skip("\\R");
        System.out.println("Enter rent type: ");
        String rentType = scanner.nextLine();
        System.out.println("Enter free service: ");
        String freeService = scanner.nextLine();
        facilityIntegerMap.put(new Room(roomId, name, usableArea, rentCost, maxCustomer, rentType, freeService), 0);
        System.out.println("Add success!");
    }

    public Facility checkExist(String id) {
        for (Map.Entry<Facility, Integer> facility : facilityIntegerMap.entrySet()) {
            if (id.equals(facility.getKey().getServiceId())) {
                return facility.getKey();
            }
        }
        return null;
    }

    public void updateRentedValue(String idService) {
        for (Map.Entry<Facility, Integer> facility : facilityIntegerMap.entrySet()) {
            if (idService.equals(facility.getKey().getServiceId())) {
                facility.setValue(facility.getValue() + 1);
            }
        }
    }
}
