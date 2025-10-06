class NumberPrinter {
    private int number = 1;   // start with 1
    private final int MAX = 20;

    // method for odd thread
    public synchronized void printOdd() {
        while (number <= MAX) {
            if (number % 2 == 0) {   // if even, odd thread waits
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number <= MAX) {
                System.out.println("Odd Thread: " + number);
                number++;
                notify();  // wake up even thread
            }
        }
    }

    // method for even thread
    public synchronized void printEven() {
        while (number <= MAX) {
            if (number % 2 == 1) {   // if odd, even thread waits
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number <= MAX) {
                System.out.println("Even Thread: " + number);
                number++;
                notify();  // wake up odd thread
            }
        }
    }
}

public class MultiThreaded {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();

        // Thread for odd numbers
        Thread oddThread = new Thread(() -> printer.printOdd());

        // Thread for even numbers
        Thread evenThread = new Thread(() -> printer.printEven());

        oddThread.start();
        evenThread.start();
    }
}
