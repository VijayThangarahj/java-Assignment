class Singleton {
    // Step 1: create a private static instance (volatile for thread-safety)
    private static volatile Singleton instance;

    // Step 2: private constructor (so no one can create object directly)
    private Singleton() {
        System.out.println("Singleton object created!");
    }

    // Step 3: public method to get the instance
    public static Singleton getInstance() {
        if (instance == null) { // first check (no lock)
            synchronized (Singleton.class) {
                if (instance == null) { // second check (with lock)
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello, I am a Singleton!");
    }
}

public class ThreadSafe {
    public static void main(String[] args) {
        // Multiple threads trying to get Singleton
        Thread t1 = new Thread(() -> {
            Singleton obj1 = Singleton.getInstance();
            obj1.showMessage();
        });

        Thread t2 = new Thread(() -> {
            Singleton obj2 = Singleton.getInstance();
            obj2.showMessage();
        });

        t1.start();
        t2.start();
    }
}
