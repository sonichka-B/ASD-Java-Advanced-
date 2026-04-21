package topic15.practice;

public class CashPaymentService implements PaymentService{

    public CashPaymentService(){}


    @Override
    public void pay(double amount) {
        System.out.println("payed by cash: "+ amount);
    }
}
