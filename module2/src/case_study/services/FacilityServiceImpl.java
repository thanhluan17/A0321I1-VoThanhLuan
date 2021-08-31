package case_study.services;

import case_study.data.ReadAndWrite;
import case_study.models.Facility;
import case_study.models.House;
import case_study.models.Room;
import case_study.models.Villa;
import case_study.util.Validation;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    public static final String REGEX_STR = "[A-Z][a-z]+";
    public static final String REGEX_VILLA_ID = "(SVVL)[-][0-9]{4}";
    public static final String REGEX_HOUSE_ID = "(SVHO)[-][0-9]{4}";
    public static final String REGEX_ROOM_ID = "(SVRO)[-][0-9]{4}";
    public static final String REGEX_AREA = "^([3-9]\\d|[1-9]\\d{2,})";
    public static final String REGEX_MAX_CUSTOMER = "^[1-9]|([1][0-9])|(20)$";
    public static final String REGEX_INT = "^([1-9])[0-9]*";
    //^([1-9])[0-9]*$
    Scanner scanner = new Scanner(System.in);
    private static Map<Facility, Integer> facilityIntegerMap;

    static {
        facilityIntegerMap = new LinkedHashMap<>();
        facilityIntegerMap.put(new Villa("SVVL-0001", "VillaA", 100, 1000, 5, "Day",
                "5 star", 50, 2), 5);
        facilityIntegerMap.put(new House("SVHO-0001", "HouseA", 150, 700, 10, "Month", "4 star", 3), 0);
        facilityIntegerMap.put(new Room("SVRO_0001", "RoomA", 50, 300, 3, "Day",
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
            villaId = inputVillaId();
            if (checkExist(villaId) != null) {
                System.out.println("Id service existed!");
            }
        } while (checkExist(villaId) != null);
        System.out.println("Enter Villa name: ");
        String name = inputServiceName();
        System.out.println("Enter usable area: ");
        double usableArea = Double.parseDouble(inputArea());
        System.out.println("Enter rent cost: ");
        float rentCost = Float.parseFloat(inputInt());
        System.out.println("Enter max customer: ");
        int maxCustomer = Integer.parseInt(inputMaxCustomer());
        System.out.println("Enter rent type: ");
        String rentType = scanner.nextLine();
        System.out.println("Enter standard: ");
        String standard = scanner.nextLine();
        System.out.println("Enter pool area: ");
        double poolArea = Double.parseDouble(inputArea());
        System.out.println("Enter floor number: ");
        int floorNumber = Integer.parseInt(inputInt());
        facilityIntegerMap.put(new Villa(villaId, name, usableArea, rentCost, maxCustomer, rentType, standard, poolArea, floorNumber), 0);
        writeFacility("SVVL", "src\\case_study\\data\\villa.csv");
        System.out.println("Add success!");
    }

    @Override
    public void addHouse() {
        String houseId;
        do {
            System.out.println("Enter House service id: ");
            houseId = inputHouseId();
            if (checkExist(houseId) != null) {
                System.out.println("Id service existed!");
            }
        } while (checkExist(houseId) != null);
        System.out.println("Enter House name: ");
        String name = inputServiceName();
        System.out.println("Enter usable area: ");
        double usableArea = Double.parseDouble(inputArea());
        System.out.println("Enter rent cost: ");
        float rentCost = Float.parseFloat(inputInt());
        System.out.println("Enter max customer: ");
        int maxCustomer = Integer.parseInt(inputMaxCustomer());
        System.out.println("Enter rent type: ");
        String rentType = scanner.nextLine();
        System.out.println("Enter standard: ");
        String standard = scanner.nextLine();
        System.out.println("Enter floor number: ");
        int floorNumber = Integer.parseInt(inputInt());
        facilityIntegerMap.put(new House(houseId, name, usableArea, rentCost, maxCustomer, rentType, standard, floorNumber), 0);
        System.out.println("Add success!");
    }

    @Override
    public void addRoom() {
        String roomId;
        do {
            System.out.println("Enter Room service id: ");
            roomId = inputRoomId();
            if (checkExist(roomId) != null) {
                System.out.println("Id service existed!");
            }
        } while (checkExist(roomId) != null);
        System.out.println("Enter Room name: ");
        String name = inputServiceName();
        System.out.println("Enter usable area: ");
        double usableArea = Double.parseDouble(inputArea());
        System.out.println("Enter rent cost: ");
        float rentCost = Float.parseFloat(inputInt());
        System.out.println("Enter max customer: ");
        int maxCustomer = Integer.parseInt(inputMaxCustomer());
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

    private String inputVillaId() {
        return Validation.checkInput(scanner.nextLine(), REGEX_VILLA_ID, "Invalid format, id must be: SVVL-XXXX!");
    }

    private String inputHouseId() {
        return Validation.checkInput(scanner.nextLine(), REGEX_HOUSE_ID, "Invalid format, id must be: SVHO-XXXX!");
    }

    private String inputRoomId() {
        return Validation.checkInput(scanner.nextLine(), REGEX_ROOM_ID, "Invalid format, id must be: SVRO-XXXX!");
    }

    private String inputServiceName() {
        return Validation.checkInput(scanner.nextLine(), REGEX_STR, "Invalid format, service name must be a String with uppercase character!");
    }

    private String inputArea() {
        return Validation.checkInput(scanner.nextLine(), REGEX_AREA, "Invalid format, area must be greater than 30!");
    }

    private String inputInt() {
        return Validation.checkInput(scanner.nextLine(), REGEX_INT, "Invalid format, cost must be a number greater than 0!");
    }

    private String inputMaxCustomer() {
        return Validation.checkInput(scanner.nextLine(), REGEX_MAX_CUSTOMER, "Invalid format, id must be greater than 0 and less than 20!");
    }

    private void writeFacility(String type, String path) {
        List<Facility> facilityList = new ArrayList<>();
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
            if (type.equals(facilityIntegerEntry.getKey().getServiceId().substring(0, 4))) {
                facilityList.add(facilityIntegerEntry.getKey());
            }
        }
        ReadAndWrite.writeFile(facilityList, path);
    }
}
