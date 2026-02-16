public class Seat {

  private String seatNumber;
  private Boolean isAvailable;
  private boolean isVIP;

  public Seat(String seatNumber, boolean isVIP) {
    this.seatNumber = seatNumber;
    this.isVIP = isVIP;
    this.isAvailable = true;
  }

  public String getSeatNumber() {
    return seatNumber;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void reserve() {
    this.isAvailable = false;
  }
}
