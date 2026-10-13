import java.util.Comparator;
import java.util.PriorityQueue;

public class vart {
    record Ticket(String name, int urgency, long seq) {}

    public static void main(String[] args) {
        PriorityQueue<Ticket> queue = new PriorityQueue<>(
            Comparator.comparingInt(Ticket::urgency)
                      .thenComparingLong(Ticket::seq));

        long counter = 0;
        queue.offer(new Ticket("Printer", 3, counter++));
        queue.offer(new Ticket("Network", 1, counter++));
        queue.offer(new Ticket("Login",   2, counter++));
        queue.offer(new Ticket("VPN",     2, counter++)); // tie with Login, to test the tie-breaker

        // Step 4: poll() until empty
        while (!queue.isEmpty()) {
            Ticket t = queue.poll();
            System.out.println(t.name() + " (urgency " + t.urgency() + ")");
        }
    }
}