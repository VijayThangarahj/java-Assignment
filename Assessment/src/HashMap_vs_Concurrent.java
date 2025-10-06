import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMap_vs_Concurrent {

    public static void main(String[] args) throws InterruptedException {
        Map<Integer, String> hashMap = new HashMap<>();

        Map<Integer, String> concurrentMap = new ConcurrentHashMap<>();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                hashMap.put(i, "Value " + i);
                concurrentMap.put(i, "Value " + i);
                System.out.println("Thread 1 added: " + i);
                try { Thread.sleep(50); } catch (Exception e) {}
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2 reads HashMap: " + hashMap);
                System.out.println("Thread 2 reads ConcurrentMap: " + concurrentMap);
                try { Thread.sleep(50); } catch (Exception e) {}
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("\nFinal HashMap: " + hashMap);
        System.out.println("Final ConcurrentHashMap: " + concurrentMap);
    }
}

