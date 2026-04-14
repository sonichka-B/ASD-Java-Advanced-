package topic13.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Task1");
        List<Order> orders = List.of(new Order(1,1),new Order(2,2),new Order(3,3));
        Runnable sum = ()  -> {
            int total = orders.stream().mapToInt(Order::totalCents).sum();
            System.out.println("Total Cents: " + total);
        };
        Runnable max = () -> {
            int total = orders.stream().mapToInt(Order::totalCents).max().getAsInt();
            System.out.println("max Cents: " + total);
        };
        TaskRunner taskRunner = new TaskRunner();
        taskRunner.runAndWait(List.of(sum, max));

        System.out.println("Task2");
        Inventory unsafe = new UnsafeInventory(100);
        Thread thread = new Thread(() -> unsafe.reserve(60));
        Thread thread2 = new Thread(() -> unsafe.reserve(60));
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println("unsafe inventory left (must be 40), in real: "+ unsafe.available());

        Inventory safe = new SynchronizedInventory(100);
        Thread thr1 = new Thread(() -> safe.reserve(60));
        Thread thr2 = new Thread(() -> safe.reserve(60));
        thr1.start();
        thr2.start();
        thr1.join();
        thr2.join();
        System.out.println("safe inventory left (must be 40), in real: "+ safe.available());

        if(unsafe.available()> safe.available())
        System.out.println("unsafe more");
        else{
            System.out.println("safe more");
        }

        int fails =0;
        for (int i = 0; i < 200; i++) {
            Inventory unsafeTest = new UnsafeInventory(100);
            Thread thread1 = new Thread(() -> unsafeTest.reserve(60));
            Thread thread3 = new Thread(() -> unsafeTest.reserve(60));
            thread1.start();
            thread3.start();
            thread1.join();
            thread3.join();

            if(unsafeTest.available() <0) fails++;
        }
        System.out.println("fails: " + fails);

        System.out.println("Task3");
        TransferService transferService = new TransferService();
        Account one = new Account(1,100);
        Account two = new Account(2, 200);
        transferService.transfer(one, two, 50);
        System.out.println("balance one:"+one.getBalance() + ",  balance two:"+two.getBalance());

        System.out.println("Task4");
        BlockingQueue<SupportTicket> queue = new LinkedBlockingQueue<>(10);
        SupportTicket POISON_PILL = new SupportTicket(1, "c1", "t1");
        ConcurrentHashMap<String, Integer> forCountAdvert = new ConcurrentHashMap<>();

        Runnable producer = () ->{
            try {
                String[] topics = {"TOPIC1", "TOPIC2", "TOPIC3", "TOPIC4", "TOPIC5"};
                for (int i = 0; i < topics.length; i++) {
                    queue.put(new SupportTicket(i, "c" + i, topics[i]));
                }
                for (int i = 0; i < 3; i++) {
                    queue.put(POISON_PILL);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };

        Runnable consumer = () -> {
            try {
                while (true){
                    SupportTicket ticket = queue.take();
                    if (ticket == POISON_PILL){
                        System.out.println("recive poison pill");
                        break;
                    }
                    forCountAdvert.merge(ticket.topic(),  1, Integer::sum);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread pt = new Thread(producer);
        Thread ct1 = new Thread(consumer);
        Thread ct2 = new Thread(consumer);
        Thread ct3 = new Thread(consumer);

        pt.start();
        ct1.start();
        ct2.start();
        ct3.start();
        pt.join();
        ct1.join();
        ct2.join();
        ct3.join();

        System.out.println("Statistic:" + forCountAdvert);

    }
}
