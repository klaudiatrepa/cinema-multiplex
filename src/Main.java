import java.time.LocalDateTime;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Cinema cinema1 = new Cinema("Super Tarasy", "ul. Akademicka 5");

    CinemaHall hall1 = new CinemaHall("Sala 1", 8, 10, false); // 8 rzędów, 10 miejsc w rzędzie
    CinemaHall hall2 = new CinemaHall("Sala 2 VIP", 5, 8, true); // Sala VIP
    CinemaHall hall3 = new CinemaHall("Sala 3", 10, 12, false);

    cinema1.addCinemaHall(hall1);
    cinema1.addCinemaHall(hall2);
    cinema1.addCinemaHall(hall3);

    Movie movie1 = new Movie("James Bond: No Time to Die", 163, "Akcja", false);
    Movie movie2 = new Movie("Avatar: The Way of Water", 192, "Sci-Fi", true);
    Movie movie3 = new Movie("Oppenheimer", 180, "Dramat", false);
    Movie movie4 = new Movie("Barbie", 114, "Komedia", false);

    LocalDateTime now = LocalDateTime.now();

    Screening screening1 = new Screening(movie1, hall1, now.plusDays(1).withHour(18).withMinute(0));
    Screening screening2 = new Screening(
      movie2,
      hall2,
      now.plusDays(1).withHour(20).withMinute(30)
    );
    Screening screening3 = new Screening(movie3, hall3, now.plusDays(2).withHour(19).withMinute(0));
    Screening screening4 = new Screening(
      movie1,
      hall1,
      now.plusDays(2).withHour(21).withMinute(15)
    );
    Screening screening5 = new Screening(
      movie4,
      hall3,
      now.plusDays(3).withHour(17).withMinute(30)
    );

    cinema1.addScreening(screening1);
    cinema1.addScreening(screening2);
    cinema1.addScreening(screening3);
    cinema1.addScreening(screening4);
    cinema1.addScreening(screening5);

    Cinema cinema2 = new Cinema("Galeria Morska", "ul. Hryniewickiego 10");

    CinemaHall hall4 = new CinemaHall("Sala A", 6, 8, false);
    CinemaHall hall5 = new CinemaHall("Sala B VIP", 4, 6, true);

    cinema2.addCinemaHall(hall4);
    cinema2.addCinemaHall(hall5);

    Screening screening6 = new Screening(movie2, hall4, now.plusDays(1).withHour(19).withMinute(0));
    Screening screening7 = new Screening(
      movie4,
      hall5,
      now.plusDays(2).withHour(18).withMinute(30)
    );

    cinema2.addScreening(screening6);
    cinema2.addScreening(screening7);

    System.out.println("Repertuar: \n");
    cinema1.printProgramme();

    Screening screening = cinema1.getScreenings()[0];

    screening.reservePlaces("A1", "A2", "A3");

    System.out.println();

    Seat seat1 = hall1.findSeat("B5");
    Seat seat2 = hall1.findSeat("B6");
    Seat seat3 = hall1.findSeat("B7");
    screening.reservePlaces(seat1, seat2, seat3);

    System.out.println();

    Customer customer1 = new Customer("Jan Kowalski", "jan.kowalski@email.com");

    screening.reservePlaces(customer1, "C1", "C2", "C3");

    System.out.println("\nZakup biletów (z kontem)\n");

    Customer customer2 = new Customer("Anna Nowak", "anna.nowak@email.com");
    screening2.buyTickets(customer2, "A1", "A2");

    System.out.println("\nZakup biletó∑(bez konta)\n");

    List<Ticket> guestTickets = screening3.buyTickets("D5", "D6", "D7");
    System.out.println("Zakupiono " + guestTickets.size() + " biletów jako gość");

    System.out.println("\nsprawdzanie biletów klienta\n");

    customer2.printTickets();

    System.out.println("\nwyszukiwanie seansów: \n");

    List<Screening> bondScreenings = cinema1.findScreenings(movie1);
    System.out.println("Seanse filmu '" + movie1.getTitle() + "':");
    for (Screening s : bondScreenings) {
      System.out.println("  " + s);
    }
  }
}
