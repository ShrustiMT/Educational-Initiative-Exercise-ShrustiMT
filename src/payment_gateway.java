// Behavioral Design Patterns = Strategy Pattern: Payment Gateway

// Strategy Interface
interface PaymentStrategy {
    void pay(float amount);
}

// Concrete Strategy: Credit Card
class CreditCardStrategy implements PaymentStrategy {
    @Override
    public void pay(float amount) {
        System.out.println("Paying $" + amount + " using credit card.");
    }
}

// Concrete Strategy: PayPal
class PayPalStrategy implements PaymentStrategy {
    @Override
    public void pay(float amount) {
        System.out.println("Paying $" + amount + " using PayPal.");
    }
}

// Context: Payment Gateway
class PaymentGateway {
    private PaymentStrategy paymentStrategy;

    // Constructor injection of strategy
    public PaymentGateway(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Setter to change strategy dynamically
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Method to execute payment
    public void pay(float amount) {
        paymentStrategy.pay(amount);
    }
}

// Main Class
public class payment_gateway {
    public static void main(String[] args) {
        // Using Credit Card payment strategy
        PaymentGateway paymentGateway = new PaymentGateway(new CreditCardStrategy());
        paymentGateway.pay(100.0f);

        // Switching to PayPal payment strategy
        paymentGateway.setPaymentStrategy(new PayPalStrategy());
        paymentGateway.pay(150.0f);
    }
}
