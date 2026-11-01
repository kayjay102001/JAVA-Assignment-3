class BankTransaction extends Thread {
    int amount;

    BankTransaction(String name, int amount) {
        super(name);
        this.amount = amount;
    }

    public void run() {
        if (amount >= 50000) {
            System.out.println("High-value transaction processed first");
        } else {
            System.out.println("Low-value transaction processed later");
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankTransaction t1 = new BankTransaction("Transaction1", 5000);
        BankTransaction t2 = new BankTransaction("Transaction2", 50000);

        // Set thread priorities
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        // Start high-priority transaction first
        t2.start();
        t2.join();

        t1.start();
        t1.join();
    }
}