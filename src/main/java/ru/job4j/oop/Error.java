package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Error is " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error outOfMemoryError = new Error(true, 1, "OutOfMemoryError");
        outOfMemoryError.printInfo();
        Error stackOverflowError = new Error(true, 2, "StackOverflowError");
        stackOverflowError.printInfo();
        Error iOError = new Error(true, 3, "IOError");
        iOError.printInfo();
    }
}
