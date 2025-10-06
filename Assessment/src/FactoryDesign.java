
interface Notification {
    void notifyUser();
}

class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an Email Notification");
    }
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS Notification");
    }
}

class PushNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending a Push Notification");
    }
}

class NotificationFactory {
    public Notification createNotification(String type) {
        if (type == null) return null;
        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        } else if (type.equalsIgnoreCase("PUSH")) {
            return new PushNotification();
        }
        return null;
    }
}

public class FactoryDesign {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        Notification n1 = factory.createNotification("EMAIL");
        n1.notifyUser();

        Notification n2 = factory.createNotification("SMS");
        n2.notifyUser();

        Notification n3 = factory.createNotification("PUSH");
        n3.notifyUser();
    }
}

