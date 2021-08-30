package case_study.models;

import java.io.Serializable;

public abstract class Facility implements Serializable {
    private String serviceId;
    private String serviceName;
    private double usableArea;
    private float rentCost;
    private int maxCustomer;
    private String rentType;

    public Facility() {
    }

    public Facility(String serviceId, String serviceName, double usableArea, float rentCost, int maxCustomer, String rentType) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentCost = rentCost;
        this.maxCustomer = maxCustomer;
        this.rentType = rentType;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
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

    @Override
    public String toString() {
        return "serviceId='" + serviceId + ", serviceName='" + serviceName + ", usableArea=" + usableArea + ", rentCost=" + rentCost + ", maxCustomer="
                + maxCustomer + ", rentType='" + rentType + ", ";
    }
}
