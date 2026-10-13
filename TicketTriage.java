import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TicketTriage {

   
    static class Ticket {
        String name;
        int urgency;
        int arrivalOrder;

        Ticket(String name, int urgency, int arrivalOrder) {
            this.name = name;
            this.urgency = urgency;
            this.arrivalOrder = arrivalOrder;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

       
        PriorityQueue<Ticket> tickets = new PriorityQueue<>(
            Comparator.comparingInt((Ticket t) -> t.urgency)
                      .thenComparingInt(t -> t.arrivalOrder)
        );

        System.out.println("=== HELP-DESK TICKET TRIAGE ===");

        System.out.print("Enter the number of tickets: ");
        int numberOfTickets = input.nextInt();
        input.nextLine(); // Consume the newline

       
        for (int i = 1; i <= numberOfTickets; i++) {

            System.out.println("\nTicket #" + i);

            System.out.print("Enter ticket name: ");
            String name = input.nextLine();

            System.out.print("Enter urgency (1 = highest priority): ");
            int urgency = input.nextInt();
            input.nextLine(); // Consume the newline

           
            tickets.offer(new Ticket(name, urgency, i));
        }

    
        System.out.println("\n=== TICKET PROCESSING ORDER ===");

        while (!tickets.isEmpty()) {
            Ticket ticket = tickets.poll();

            System.out.println(
                "Ticket: " + ticket.name
                + " | Urgency: " + ticket.urgency
            );
        }

        System.out.println("\nAll tickets have been processed.");

        input.close();
    }
}
