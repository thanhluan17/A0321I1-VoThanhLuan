package case_study.models;

public abstract class Facility {
    private String serviceName;
    private double usableArea;
    private float rentCost;
    private int maxCustomer;
    private String rentType;

    public Facility() {
    }

    public Facility(String serviceName, double usableArea, float rentCost, int maxCustomer, String rentType) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentCost = rentCost;
        this.maxCustomer = maxCustomer;
        this.rentType = rentType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public float getRentCost() {
        return rentCost;
    }

    public void setRentCost(float rentCost) {
        this.rentCost = rentCost;
    }

    public int getMaxCustomer() {
        return maxCustomer;
    }

    public void setMaxCustomer(int maxCustomer) {
        this.maxCustomer = maxCustomer;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }
}
