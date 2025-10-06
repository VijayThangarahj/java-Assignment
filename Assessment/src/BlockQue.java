import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                System.out.println("Produced: " + i);
                queue.put(i);  // add item to queue (waits if full)
                Thread.sleep(100); // simulate time to produce
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                int num = queue.take(); // remove item from queue (waits if empty)
                System.out.println("Consumed: " + num);
                Thread.sleep(150); // simulate time to consume
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class BlockQue {
    public static void main(String[] args) {
       BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

      Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();
    }
}
