package topic15.practice;

public class CardPaymentService implements PaymentService{
    public CardPaymentService(){}

    @Override
    public void pay(double amount) {
            System.out.println("payed by card: "+ amount);

    }


}
