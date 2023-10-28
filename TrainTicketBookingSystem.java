import java.util.Scanner;

class Ticket {
    private String passengerName;
    private int seatNumber;
    private boolean isBooked;
    /*hgbhjbhjknnnjknkjnjk */
    public Ticket() {

        this.passengerName = null;
        this.seatNumber = 0;
        this.isBooked = false;
    }

    public void book(String passengerName, int seatNumber) {
        this.passengerName = passengerName;
        this.seatNumber = seatNumber;
        this.isBooked = true;
    }

    public void cancel() {
        this.passengerName = null;
        this.seatNumber = 0;
        this.isBooked = false;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}

class Train {
    private Ticket[] tickets;

    public Train(int numSeats) {
        tickets = new Ticket[numSeats];
        for (int i = 0; i < numSeats; i++) {
            tickets[i] = new Ticket();
        }
    }

    public boolean bookTicket(String passengerName, int seatNumber) {
        if (seatNumber >= 1 && seatNumber <= tickets.length) {
            Ticket ticket = tickets[seatNumber - 1];
            if (!ticket.isBooked()) {
                ticket.book(passengerName, seatNumber);
                return true;
            } else {
                System.out.println("Seat " + seatNumber + " is already booked by " + ticket.getPassengerName());
            }
        } else {
            System.out.println("Invalid seat number. Seat number must be between 1 and " + tickets.length);
        }
        return false;
    }

    public boolean cancelTicket(int seatNumber) {
        if (seatNumber >= 1 && seatNumber <= tickets.length) {
            Ticket ticket = tickets[seatNumber - 1];
            if (ticket.isBooked()) {
                ticket.cancel();
                return true;
            } else {
                System.out.println("Seat " + seatNumber + " is not booked.");
            }
        } else {
            System.out.println("Invalid seat number. Seat number must be between 1 and " + tickets.length);
        }
        return false;
    }

    public void displayAvailableSeats() {
        System.out.println("Available Seats:");
        for (int i = 0; i < tickets.length; i++) {
            if (!tickets[i].isBooked()) {
                System.out.println("Seat " + (i + 1));
            }
        }
    }

    public void displayBookedSeats() {
        System.out.println("Booked Seats:");
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i].isBooked()) {
                System.out.println("Seat " + (i + 1) + " - " + tickets[i].getPassengerName());
            }
        }
    }
}

public class TrainTicketBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of seats in the train: ");
        int numSeats = scanner.nextInt();
        Train train = new Train(numSeats);

        while (true) {
            System.out.println("\nTrain Ticket Booking System Menu:");
            System.out.println("1. Book a Ticket");
            System.out.println("2. Cancel a Ticket");
            System.out.println("3. Display Available Seats");
            System.out.println("4. Display Booked Seats");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter passenger name: ");
                    String passengerName = scanner.next();
                    System.out.print("Enter seat number: ");
                    int seatNumber = scanner.nextInt();
                    train.bookTicket(passengerName, seatNumber);
                    break;
                case 2:
                    System.out.print("Enter seat number to cancel: ");
                    int cancelSeatNumber = scanner.nextInt();
                    train.cancelTicket(cancelSeatNumber);
                    break;
                case 3:
                    train.displayAvailableSeats();
                    break;
                case 4:
                    train.displayBookedSeats();
                    break;
                case 5:
                    System.out.println("Thank you for using the Train Ticket Booking System!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
