import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Screening {

  private Movie movie;
  private CinemaHall cinemaHall;
  private LocalDateTime startTime;

  public Screening(Movie movie, CinemaHall hall, LocalDateTime startTime) {
        this.movie = movie;
        this.cinemaHall = hall;
        this.startTime = startTime;
    }

  public Movie getMovie() {
    return movie;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public CinemaHall getCinemaHall() {
    return cinemaHall;
  }

  public void setCinemaHall(CinemaHall cinemaHall) {
    this.cinemaHall = cinemaHall;
  }

  public void reservePlaces(String... seatNumbers) {
    for (String seatNumber : seatNumbers) {
      Seat seat = cinemaHall.findSeat(seatNumber);
      if (seat == null) {
        System.out.println("  Błąd: Miejsce " + seatNumber + " nie istnieje");
        continue;
      }
      if (!seat.isAvailable()) {
        System.out.println("  Błąd: Miejsce " + seatNumber + " jest zajęte");
        continue;
      }

      seat.reserve();
      System.out.println("  Zarezerwowano miejsce: " + seatNumber);
    }
  }

  public void reservePlaces(Seat... seats) {
    for (Seat seat : seats) {
      if (!seat.isAvailable()) {
        System.out.println("  Błąd: Miejsce " + seat.getSeatNumber() + " jest zajęte");
        continue;
      }

      seat.reserve();
      System.out.println("  Zarezerwowano miejsce: " + seat.getSeatNumber());
    }
  }

  public void reservePlaces(Customer customer, String... seatNumbers) {
    for (String seatNumber : seatNumbers) {
      Seat seat = cinemaHall.findSeat(seatNumber);
      if (seat == null) {
        System.out.println("  Błąd: Miejsce " + seatNumber + " nie istnieje");
        continue;
      }
      if (!seat.isAvailable()) {
        System.out.println("  Błąd: Miejsce " + seatNumber + " jest zajęte");
        continue;
      }

      seat.reserve();
      System.out.println("  Zarezerwowano miejsce: " + seatNumber);
    }
  }

  public List<Ticket> buyTickets(Customer customer, String... seatNumbers) {
    List<Ticket> tickets = new ArrayList<>();

    for (String seatNumber : seatNumbers) {
      Seat seat = cinemaHall.findSeat(seatNumber);
      if (seat == null) {
        System.out.println("  Błąd: Miejsce " + seatNumber + " nie istnieje");
        continue;
      }
      if (!seat.isAvailable()) {
        System.out.println("  Błąd: Miejsce " + seatNumber + " jest zajęte");
        continue;
      }

      seat.reserve();

      Ticket ticket = new Ticket(customer, this, seat);
      tickets.add(ticket);

      if (customer != null) {
        customer.addTicket(ticket);
      }

      System.out.println("  Kupiono bilet: " + seatNumber);
    }

    return tickets;
  }

  public List<Ticket> buyTickets(String... seatNumbers) {
    return buyTickets(null, seatNumbers);
  }

  public int getAvailableSeats() {
        return cinemaHall.getAvailableSeats();
    }

  @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String hallType = cinemaHall.isVIPHall() ? " [VIP]" : "";
        return startTime.format(formatter) + " - " + movie.toString() + 
               " | Sala: " + cinemaHall.getName() + hallType + 
               " | Dostępne miejsca: " + getAvailableSeats() + "/" + cinemaHall.getTotalSeats();
    }
}
