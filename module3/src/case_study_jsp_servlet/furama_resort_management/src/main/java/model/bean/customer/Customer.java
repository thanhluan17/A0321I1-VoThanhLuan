package model.bean.customer;

public class Customer {
    private int id;
    private int typeId;
    private String typeName;
    private String name;
    private String birthday;
    private boolean gender;
    private String cardID;
    private String phone;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(int id, int typeId, String name, String birthday, boolean gender, String cardID, String phone, String email, String address) {
        this.id = id;
        this.typeId = typeId;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.cardID = cardID;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Customer(int id, int typeId, String typeName, String name, String birthday, boolean gender, String cardID, String phone, String email, String address) {
        this.id = id;
        this.typeId = typeId;
        this.typeName = typeName;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.cardID = cardID;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Customer(int typeId, String name, String birthday, boolean gender, String cardID, String phone, String email, String address) {
        this.typeId = typeId;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.cardID = cardID;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender=" + gender +
                ", cardID='" + cardID + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
