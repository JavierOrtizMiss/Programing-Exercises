public class CreditCardAdapter implements Payment {
    private CreditCard creditCard;

    public CreditCardAdapter() {
        creditCard = new CreditCard();
    }

    @Override
    public void pay(double amount) {
        creditCard.executePay(amount);
    }

}
