package case_study.models;

public class Villa extends Facility {
    private String standard;
    private double poolArea;
    private int floorNumber;

    public Villa() {
    }

    public Villa(String standard, double poolArea, int floorNumber) {
        this.standard = standard;
        this.poolArea = poolArea;
        this.floorNumber = floorNumber;
    }

    public Villa(String serviceId, String serviceName, double usableArea, float rentCost, int maxCustomer, String rentType, String standard, double poolArea, int floorNumber) {
        super(serviceId, serviceName, usableArea, rentCost, maxCustomer, rentType);
        this.standard = standard;
        this.poolArea = poolArea;
        this.floorNumber = floorNumber;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return super.toString() + standard + '\'' + ", poolArea=" + poolArea + ", floorNumber=" + floorNumber;
    }
}
