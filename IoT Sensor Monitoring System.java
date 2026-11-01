import java.util.Random;
import java.util.Scanner;

class SquareCalculator extends Thread {
    int number;

    SquareCalculator(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Square: " + (number * number));
    }
}

class CubeCalculator extends Thread {
    int number;

    CubeCalculator(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Cube: " + (number * number * number));
    }
}

class RandomNumberGenerator extends Thread {
    public void run() {
        Random random = new Random();

        try {
            // Generate 3 random numbers
            for (int i = 0; i < 3; i++) {
                int number = random.nextInt(10) + 1;

                System.out.println("Generated: " + number);

                if (number % 2 == 0) {
                    SquareCalculator square =
                        new SquareCalculator(number);
                    square.start();
                    square.join();
                } else {
                    CubeCalculator cube =
                        new CubeCalculator(number);
                    cube.start();
                    cube.join();
                }

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Simulation interrupted");
            Thread.currentThread().interrupt();
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Start Simulation");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    RandomNumberGenerator generator =
                        new RandomNumberGenerator();
                    generator.start();
                    generator.join();
                    break;

                case 2:
                    System.out.println("Exiting Program");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}