public class Movie {

  private String title;
  private int durationMinutes;
  private String genre;
  private boolean is3D;

  public Movie(String title, int durationMinutes, String genre, boolean is3D) {
    this.title = title;
    this.durationMinutes = durationMinutes;
    this.genre = genre;
    this.is3D = is3D;
  }

  public String getTitle() {
    return title;
  }

  public int getDurationMinutes() {
    return durationMinutes;
  }

  public String getGenre() {
    return genre;
  }

  public boolean is3D() {
    return is3D;
  }

  @Override
  public String toString() {
    String format = is3D ? " [3D]" : "";
    return title + format + " (" + durationMinutes + " min, " + genre + ")";
  }
}
