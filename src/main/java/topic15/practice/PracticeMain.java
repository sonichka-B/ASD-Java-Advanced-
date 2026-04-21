package topic15.practice;

import java.util.Set;

public class PracticeMain {
    public static void main(String[] args) {
        System.out.println("Task1");
        Book book = new Book("the fourth wing", "Rebecca Yarros", 550);
        ClassInfoPrinter printer = new ClassInfoPrinter();
        printer.print(book.getClass());

        System.out.println("Task2");
        ServiceFactory factory = new ServiceFactory();
        PaymentService card = factory.create("topic15.practice.CardPaymentService");
        PaymentService cash = factory.create("topic15.practice.CashPaymentService");
        card.pay(3452.235);
        cash.pay(4574.07765);

        System.out.println("Task3");
        SetupFlow flow  = new SetupFlow();
        StepRunner runner = new StepRunner();
        try {
            runner.run(flow);
        }catch (StepException e){
            throw new StepException("problem: "+e.getMessage());
        }

    }
}
