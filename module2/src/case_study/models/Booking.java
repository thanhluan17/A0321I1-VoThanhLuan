package case_study.models;

public class Booking {
    private String bookingId;
    private String startDate;
    private String endDate;
    private String customerId;
    private String serviceId;

    public Booking() {
    }

    public Booking(String bookingId, String startDate, String endDate, String customerId, String serviceId) {
        this.bookingId = bookingId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.serviceId = serviceId;
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

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingId='" + bookingId + '\'' + ", startDate='" + startDate + '\'' + ", endDate='"
                + endDate + '\'' + ", customerId='" + customerId + '\'' + ", serviceId='" + serviceId + '\'' + '}';
    }
}
