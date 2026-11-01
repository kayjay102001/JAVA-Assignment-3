import java.util.Scanner;

class MinimumAmountException extends Exception {
    MinimumAmountException(String message) {
        super(message);
    }
}

class OnlineShopping {
    void placeOrder(int amount) throws MinimumAmountException {
        if (amount < 500) {
            throw new MinimumAmountException(
                "Minimum cart value must be ₹500"
            );
        } else {
            System.out.println("Order placed successfully");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cart amount: ");
        int amount = sc.nextInt();

        OnlineShopping shop = new OnlineShopping();

        try {
            shop.placeOrder(amount);
        } catch (MinimumAmountException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}