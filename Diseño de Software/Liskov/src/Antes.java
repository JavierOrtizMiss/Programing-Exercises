// Base class
public abstract class PaymentMethod {
    public abstract void pay(double amount);
}

// Subclass 1
public class CreditCardPayment extends PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

// Subclass 2
public class PayPalPayment extends PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

public class CashPayment extends PaymentMethod {
    @Override
    public void pay(double amount) {
        throw new UnsupportedOperationException("Cash payment cannot be processed online!");
    }
}

// Client Code
public class PaymentProcessor {
    public void processPayment(PaymentMethod method, double amount) {
        method.pay(amount);
    }

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        PaymentMethod creditCard = new CreditCardPayment();
        PaymentMethod paypal = new PayPalPayment();
        PaymentMethod cash = new CashPayment();
        processor.processPayment(creditCard, 100.0); 
        processor.processPayment(paypal, 150.0); 
        processor.processPayment(cash, 200.0); 
    }
}