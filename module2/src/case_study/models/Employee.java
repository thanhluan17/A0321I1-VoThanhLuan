package case_study.models;

public class Employee extends Person {
    private String employeeId;
    private String education;
    private String position;
    private float salary;

    public Employee() {
    }

    public Employee(String employeeId, String education, String position, float salary) {
        this.employeeId = employeeId;
        this.education = education;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String name, String dob, boolean gender, String identityNumber, String phoneNumber,
                    String email, String employeeId, String education, String position, float salary) {
        super(name, dob, gender, identityNumber, phoneNumber, email);
        this.employeeId = employeeId;
        this.education = education;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        /*return "Employee{" + "employeeId='" + employeeId + '\'' + ", education='" + education + '\''
                + ", position='" + position + '\'' + ", salary=" + salary + '}';*/
        return super.toString() + ", employeeId='" + employeeId + '\'' + ", education='" + education + '\''
                + ", position='" + position + '\'' + ", salary=" + salary;
    }
}
