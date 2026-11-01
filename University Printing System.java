class PrinterJob implements Runnable {
    int jobNumber;
    String studentName;

    PrinterJob(int jobNumber, String studentName) {
        this.jobNumber = jobNumber;
        this.studentName = studentName;
    }

    public void run() {
        try {
            System.out.println("Printing job " + jobNumber + " by " + studentName);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Printing interrupted");
            Thread.currentThread().interrupt();
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numberOfJobs = 3;

        System.out.println("Number of print jobs: " + numberOfJobs);

        Thread t1 = new Thread(new PrinterJob(1, "Student A"));
        Thread t2 = new Thread(new PrinterJob(2, "Student B"));
        Thread t3 = new Thread(new PrinterJob(3, "Student C"));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}