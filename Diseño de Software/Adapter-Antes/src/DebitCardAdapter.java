public class DebitCardAdapter implements Payment{
    private DebitCard debitCard;

    public DebitCardAdapter() {
        debitCard = new DebitCard();
    }

    @Override
    public void pay(double amount) {
        debitCard.payment(amount);
    }

}
