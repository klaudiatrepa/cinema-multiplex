import java.util.ArrayList;
import java.util.List;

public class Customer {

  private String name;
  private String email;
  private List<Ticket> tickets;

  public Customer(String name, String email) {
    this.name = name;
    this.email = email;
    this.tickets = new ArrayList<>();
  }

  public void addTicket(Ticket ticket) {
    tickets.add(ticket);
  }

  public void printTickets() {
    if (tickets.isEmpty()) {
      System.out.println("Brak biletów dla " + name);
      return;
    }

    System.out.println("Bilety dla " + name + ":");
    for (Ticket ticket : tickets) {
      System.out.println(ticket);
    }
  }
}
