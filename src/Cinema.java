import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cinema {

  private String name;
  private String address;
  private List<CinemaHall> halls;
  private List<Screening> screenings;
  private List<Movie> movies;

  public Cinema(String name, String adress) {
    this.name = name;
    this.address = adress;
    this.halls = new ArrayList<>();
    this.screenings = new ArrayList<>();
    this.movies = new ArrayList<>();
  }

  public Screening[] getScreenings() {
        return screenings.toArray(new Screening[0]);
    }

  public void addCinemaHall(CinemaHall cinemaHall) {
    if (!halls.contains(cinemaHall)) {
      halls.add(cinemaHall);
    }
  }

  public void addScreening(Screening screening) {
    screenings.add(screening);
    addMovie(screening.getMovie());
  }

  public void addMovie(Movie movie) {
    if (!movies.contains(movie)) {
      movies.add(movie);
    }
  }

  public List<Screening> findScreenings(Movie movie) {
    List<Screening> result = new ArrayList<>();
    for (Screening screening : screenings) {
      if (screening.getMovie().equals(movie)) {
        result.add(screening);
      }
    }
    return result;
  }

  public void printProgramme() {
    System.out.println("===================================");
    System.out.println("REPERTUAR: " + name);
    System.out.println("Adres: " + address);
    System.out.println("===================================");

    LocalDateTime now = LocalDateTime.now();
    LocalDateTime weekLater = now.plusWeeks(1);

    List<Screening> upcomingScreenings = new ArrayList<>();
    for (Screening screening : screenings) {
      if (screening.getStartTime().isAfter(now) && screening.getStartTime().isBefore(weekLater)) {
        upcomingScreenings.add(screening);
      }
    }

    if (upcomingScreenings.isEmpty()) {
      System.out.println("Brak seansów w najbliższym tygodniu");
      return;
    }

    for (Screening screening : upcomingScreenings) {
      System.out.println(screening);
    }

    System.out.println("===================================");
  }
}
