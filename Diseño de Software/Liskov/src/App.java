// Base class
public abstract class PaymentMethod {
}

// Online payment methods
public abstract class OnlinePaymentMethod extends PaymentMethod {
    public abstract void pay(double amount);
}

// Subclass 1
public class CreditCardPayment extends OnlinePaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

// Subclass 2
public class PayPalPayment extends OnlinePaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

// No online payment methods
public abstract class NoOnlinePaymentMethod extends PaymentMethod {
    public abstract void payInPerson(double amount);
}

// Subclass 3
public class CashPayment extends NoOnlinePaymentMethod {
    @Override
    public void payInPerson(double amount) {
        System.out.println("Paid $" + amount + " in cash.");
    }
}

// Client Code
public class PaymentProcessor {
    public void processOnlinePayment(OnlinePaymentMethod method, double amount) {
        method.pay(amount);
    }

    public void processNoOnlinePayment(NoOnlinePaymentMethod method, double amount) {
        method.payInPerson(amount);
    }

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        OnlinePaymentMethod creditCard = new CreditCardPayment();
        OnlinePaymentMethod paypal = new PayPalPayment();
        NoOnlinePaymentMethod cash = new CashPayment();
        processor.processOnlinePayment(creditCard, 100.0); // OK
        processor.processOnlinePayment(paypal, 150.0); // OK
        processor.processNoOnlinePayment(cash, 200.0); // OK
    }
}