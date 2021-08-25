package b_18_string_and_regex.thuc_hanh.validate_email;

public class EmailExampleTest {
    private static EmailExample emailExample;
    public static String[] validEmail = new String[]{"a@gmail.com", "ab@yahoo.com", "abc@hotmail.com"};
    public static String[] invalidEmail = new String[]{"@gmail.com", "ab@gmail.", "@#abc@gmail.com"};

    public static void main(String[] args) {
        emailExample = new EmailExample();
        for (String email : validEmail) {
            boolean isvalid = emailExample.validate(email);
            System.out.println("Email: " + email + " is valid: " + isvalid);
        }

        for (String email : invalidEmail) {
            boolean isvalid = emailExample.validate(email);
            System.out.println("Email: " + email + " is valid: " + isvalid);
        }
    }
}
