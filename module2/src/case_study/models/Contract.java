package case_study.models;

public class Contract {
    private String contractId;
    private String bookingId;
    private float deposit;
    private float total;
    private String customerId;

    public Contract() {
    }

    public Contract(String contractId, String bookingId, float deposit, float total, String customerId) {
        this.contractId = contractId;
        this.bookingId = bookingId;
        this.deposit = deposit;
        this.total = total;
        this.customerId = customerId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Contract{" + "contractId='" + contractId + '\'' + ", bookingId='" + bookingId + '\''
                + ", deposit=" + deposit + ", total=" + total + ", customerId='" + customerId + '\'' + '}';
    }
}
