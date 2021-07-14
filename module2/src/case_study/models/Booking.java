package case_study.models;

public class Booking {
    private String bookingId;
    private String startDate;
    private String endDate;
    private String customerId;
    private String serviceName;
    private String serviceType;

    public Booking() {
    }

    public Booking(String bookingId, String startDate, String endDate, String customerId, String serviceName, String serviceType) {
        this.bookingId = bookingId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingId='" + bookingId + '\'' + ", startDate='" + startDate + '\''
                + ", endDate='" + endDate + '\'' + ", customerId='" + customerId + '\''
                + ", serviceName='" + serviceName + '\'' + ", serviceType='" + serviceType + '\'' + '}';
    }
}
