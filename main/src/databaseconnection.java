import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;

public class databaseconnection {
    public static void main(String[] args) throws SQLException,ClassNotFoundException {
         Connection con= null;
         Statement stmt = null;
        try {
            System.out.println("Connecting database...");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433";

            con = DriverManager.getConnection(url, "izel", "123456");
            System.out.println("Database connected!");
            System.out.println("Creating database...");
            stmt = con.createStatement();

            //String sql = "CREATE DATABASE proje";
           // stmt.executeUpdate(sql);
           // System.out.println("Database created successfully...");
            System.out.println("Creating table in given database proje");
            stmt = con.createStatement();

            String A = "CREATE TABLE MITARBEITER " +
                    "(id INTEGER not NULL, " +
                    " NAME VARCHAR(50), " +
                    " NACHNAME VARCHAR(50), " +
                    " LEVEL INTEGER, " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(A);
            System.out.println("Created table in given database proje");
        } catch (ClassNotFoundException e) {
            System.out.println("Database connection error:" + e);
        } catch (SQLException e) {
            System.out.println("Database connection error:" + e);

        }
    }
}
