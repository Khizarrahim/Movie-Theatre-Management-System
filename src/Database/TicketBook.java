package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TicketBook {

    Connection cn;

    public Connection getConnection(){
        String dbName = "ticketbook";
        String userName="root";
        String password="";
        String URL = "jdbc:mysql://localhost:3306/movies?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn= DriverManager.getConnection(URL,userName,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cn; }
}


