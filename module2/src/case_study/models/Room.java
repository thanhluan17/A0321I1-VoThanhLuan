package case_study.models;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String serviceId, String serviceName, double usableArea, float rentCost, int maxCustomer, String rentType, String freeService) {
        super(serviceId, serviceName, usableArea, rentCost, maxCustomer, rentType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return super.toString() + "freeService='" + freeService;
    }
}
