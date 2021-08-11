package b15_exception_and_debug.bai_tap.illegal_triangle;

public class IllegalTriangleException extends Exception{
    //gan message luc tao
    public IllegalTriangleException(String message) {
        super(message);
    }

    //truyen message luc nem
    public IllegalTriangleException() {
        super("Invalid");
    }
}
