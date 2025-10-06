class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
        System.out.println("Singleton object created!");
    }

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
