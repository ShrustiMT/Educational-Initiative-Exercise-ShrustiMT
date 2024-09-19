// Creational Design Patterns = Singleton Pattern: Logger
// Singleton Pattern: Logger
class Logger {
    // Single instance of Logger (private and static)
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {}

    // Public method to provide access to the single instance (Singleton)
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("Logging: " + message);
    }
}

// Main class to demonstrate the Singleton Pattern
public class Logger1 {
    public static void main(String[] args) {
        // Get the single instance of Logger
        Logger logger1 = Logger.getInstance();
        logger1.log("Hello, world!");  // Output: Logging: Hello, world!

        // Get the same instance of Logger again
        Logger logger2 = Logger.getInstance();
        logger2.log("This is another message");  // Output: Logging: This is another message

        // Verify that both references are the same instance
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        }
    }
}
