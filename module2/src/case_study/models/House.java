package case_study.models;

public class House extends Facility {
    public String standard;
    public int floorNumber;

    public House() {
    }

    public House(String standard, int floorNumber) {
        this.standard = standard;
        this.floorNumber = floorNumber;
    }

    public House(String serviceName, double usableArea, float rentCost, int maxCustomer, String rentType, String standard, int floorNumber) {
        super(serviceName, usableArea, rentCost, maxCustomer, rentType);
        this.standard = standard;
        this.floorNumber = floorNumber;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "House{" + "standard='" + standard + '\'' + ", floorNumber=" + floorNumber + '}';
    }
}
