package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
   public  Connection getConnection() throws SQLException {
       return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
               "postgres",
               "postgres");
   }
}
