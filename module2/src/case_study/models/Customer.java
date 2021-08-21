package case_study.models;

public class Customer extends Person {
    private String customerId;
    private String cusType;
    private String address;

    public Customer() {
    }

    public Customer(String customerId, String cusType, String address) {
        this.customerId = customerId;
        this.cusType = cusType;
        this.address = address;
    }

    public Customer(String name, String dob, boolean gender, String identityNumber, String phoneNumber, String email,
                    String customerId, String cusType, String address) {
        super(name, dob, gender, identityNumber, phoneNumber, email);
        this.customerId = customerId;
        this.cusType = cusType;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCusType() {
        return cusType;
    }

    public void setCusType(String cusType) {
        this.cusType = cusType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() + ", customerId='" + customerId + '\'' + ", cusType='" + cusType + '\''
                + ", address='" + address;
    }
}
