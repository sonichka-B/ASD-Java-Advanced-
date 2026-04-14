package topic13.practice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class Task4  {
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

}
