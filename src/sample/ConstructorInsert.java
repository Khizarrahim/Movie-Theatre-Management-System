package sample;

public class ConstructorInsert {
    String Date;
    String Time;
    String Movies;
    String Seats;
    String Screen;
    String SeatClass;

  public ConstructorInsert(String Movies, String Date, String Time, String Seats, String Screen,String SeatClass){
      this.Movies = Movies;
      this.Date = Date;
      this.Time = Time;
      this.Seats = Seats;
      this.Screen = Screen;
      this.SeatClass = SeatClass;

  }

    public String getMovies() {
        return Movies;
    }

    public String getDate() {
        return Date;
    }

    public String getTime() {
        return Time;
    }

    public String getSeats() {
        return Seats;
    }

    public String getScreen() {
        return Screen;
    }

    public String getSeatClass() {
        return SeatClass;
    }
}

