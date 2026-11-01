import java.util.Scanner;

class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}

class Student {
    void registerStudent(int age) throws InvalidAgeException {
        if (age < 17) {
            throw new InvalidAgeException(
                "Age must be above 17 for registration"
            );
        } else {
            System.out.println("Student Registration Successful");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        Student s = new Student();

        try {
            s.registerStudent(age);
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}