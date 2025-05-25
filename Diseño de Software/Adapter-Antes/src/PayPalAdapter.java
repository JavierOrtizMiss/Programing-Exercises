public class PayPalAdapter implements Payment{
    private PayPal paypal;

    public PayPalAdapter() {
        paypal = new PayPal();
    }

    @Override
    public void pay(double amount) {
        paypal.sendPayment(amount);
    }

}
