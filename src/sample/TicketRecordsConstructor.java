package sample;

public class TicketRecordsConstructor {
    String FullName;
    String Email;
    String Movies;
    String Screen;
    String Ticketsbooked;
    String SeatClass;
    public TicketRecordsConstructor(String FullName, String Email, String Movies, String Screen, String Ticketsbooked, String SeatClass){
    this.FullName = FullName;
    this.Email = Email;
    this.Movies =  Movies;
    this.Screen = Screen;
    this.Ticketsbooked = Ticketsbooked;
    this.SeatClass = SeatClass;

    }

    public String getFullName() {
        return FullName;
    }

    public String getEmail() {
        return Email;
    }

    public String getMovies() {
        return Movies;
    }

    public String getScreen() {
        return Screen;
    }

    public String getTicketsbooked() {
        return Ticketsbooked;
    }

    public String getSeatClass() {
        return SeatClass;
    }
}
