import javax.swing.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;

public class databaseconnection {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = null;
        Statement stmt = null;
        try {
            System.out.println("Connecting database...");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;database=inf202;integratedSecurity=true;";

            con = DriverManager.getConnection(url, "izel", "123456");
            System.out.println("Database connected!");
            stmt = con.createStatement();


            String A = "CREATE TABLE Mitarbeiter " +
                    "(ad VARCHAR(50) not NULL, " +
                    "SOYAD VARCHAR(50) not NULL , " +
                    " Emailadres VARCHAR(50) not NULL," +
                    "LEVEL INTEGER not NULL, " +
                    "Şifre INT not NULL," +
                    " Sertifikadate DATE not NULL, )";

            stmt.executeUpdate(A);
            System.out.println("Created table in given database");
        } catch (ClassNotFoundException e) {
            System.out.println("Database connection error:" + e);
        } catch (SQLException e) {
            System.out.println("Database connection error:" + e);

        }
    }
}


