import java.util.Scanner;

class HallTicket {
    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class ExamHallTicketReferenceManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String studentName = sc.nextLine();
        int initialSeat = sc.nextInt();
        int updatedSeat = sc.nextInt();

        HallTicket priya = new HallTicket(studentName, initialSeat);

        HallTicket copy = priya;

        copy.seatNumber = updatedSeat;

        HallTicket separate = new HallTicket(studentName, updatedSeat);

        System.out.println(studentName + "'s seatNumber (via first variable):");
        System.out.println(priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}