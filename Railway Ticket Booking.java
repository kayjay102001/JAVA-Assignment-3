class TicketBooking {
    int availableSeats;

    TicketBooking(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    synchronized void bookSeat(int seats) {
        String userName = Thread.currentThread().getName();

        if (availableSeats >= seats) {
            availableSeats -= seats;
            System.out.println(userName + " booked " + seats + " seat(s) successfully");
        } else {
            System.out.println(userName + " booking failed. Not enough seats");
        }
    }
}

class User1 extends Thread {
    TicketBooking booking;
    int seats;

    User1(TicketBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
    }

    public void run() {
        booking.bookSeat(seats);
    }
}

class User2 extends Thread {
    TicketBooking booking;
    int seats;

    User2(TicketBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
    }

    public void run() {
        booking.bookSeat(seats);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TicketBooking booking = new TicketBooking(2);

        User1 user1 = new User1(booking, 1);
        User2 user2 = new User2(booking, 2);

        user1.setName("User1");
        user2.setName("User2");

        user1.start();
        user1.join();

        user2.start();
        user2.join();
    }
}