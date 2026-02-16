import java.time.format.DateTimeFormatter;

public class Ticket {

  private Screening screening;
  private Customer customer;
  private Seat seat;

  public Ticket(Customer customer, Screening screening, Seat seat) {
    this.screening = screening;
    this.customer = customer;
    this.seat = seat;
  }

  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    return (
      " | Film: " +
      screening.getMovie().getTitle() +
      " | Data: " +
      screening.getStartTime().format(formatter) +
      " | Miejsce: " +
      seat.getSeatNumber()
    );
  }
}
