package topic13.practice;

import java.util.ArrayList;
import java.util.List;

public class TaskRunner {
    public void runAndWait(List<Runnable> tasks){
        List<Thread> threads = new ArrayList<>();
        for (Runnable task : tasks) {
            Thread thread = new Thread(task);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
