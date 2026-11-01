import java.util.Scanner;

class UniversityLogin {
    void login(String username) {
        if (username == null) {
            throw new NullPointerException("Username cannot be null");
        } else {
            System.out.println("Login Successful");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        // Convert the text "null" into a null reference
        if (username.equals("null")) {
            username = null;
        }

        UniversityLogin ul = new UniversityLogin();

        try {
            ul.login(username);
        } catch (NullPointerException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}