package DesignPatterns.SingletonPattern;

public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Testing first log call.");
        logger2.log("Testing second log call.");

        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both logger1 and logger2 point to the exact same instance.");
        } else {
            System.out.println("FAILURE: Different instances exist!");
        }
    }
}