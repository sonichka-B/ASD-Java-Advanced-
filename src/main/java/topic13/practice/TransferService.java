package topic13.practice;

public class TransferService {
    public void transfer(Account from, Account to, int amount){
        Account lockOne = from.getId()< to.getId() ? from : to;
        Account lockTwo = from.getId()<to.getId() ? to:from;
        synchronized (lockOne){
         try{
             Thread.sleep(10);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
         synchronized (lockTwo){
             if(from.getBalance()>=amount){
                 from.setBalance(from.getBalance() - amount);
                 to.setBalance( to.getBalance() + amount);
                 System.out.println("Transfer from "+from+" to "+to);
             }
         }

        }

    }
}
