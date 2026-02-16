import java.util.ArrayList;
import java.util.List;

public class CinemaHall {

  private String name;
  private List<Seat> seats;
  private boolean isVIPHall;

  public CinemaHall(String name, int rows, int seatsPerRow, boolean isVIPHall) {
    this.name = name;
    this.isVIPHall = isVIPHall;
    this.seats = new ArrayList<>();

    for (int row = 0; row < rows; row++) {
      char rowLetter = (char) ('A' + row);
      for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
        String seatNumber = rowLetter + String.valueOf(seatNum);
        seats.add(new Seat(seatNumber, isVIPHall));
      }
    }
  }

  public String getName() {
    return name;
  }

  public boolean isVIPHall() {
    return isVIPHall;
  }

  public Seat findSeat(String seatNumber) {
    for (Seat seat : seats) {
      if (seat.getSeatNumber().equals(seatNumber)) {
        return seat;
      }
    }
    return null;
  }

  public int getAvailableSeats() {
    int count = 0;
    for (Seat seat : seats) {
      if (seat.isAvailable()) {
        count++;
      }
    }
    return count;
  }

  public int getTotalSeats() {
    return seats.size();
  }
}
