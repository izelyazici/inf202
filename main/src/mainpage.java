import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.EnumMap;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;

public class mainpage extends JFrame {
    private JPanel ekran;
    private JTextField adTextField;
    private JTextField SOYADTextField;
    private JTextField emailadressTextField;
    private JTextField LEVELTextField;
    private JTextField idTextField;
    private JTextField sertifikadateTextField;
    private JButton EKLEButton;
    private JTextField çalışanIdTextField;
    private JButton SİLButton;
    private JButton GÜNCELLEButton;
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet resultSet = null;
    private static PreparedStatement psmt = null;


    public mainpage() {


        EKLEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                String ad = adTextField.getText();
                String SOYAD = SOYADTextField.getText();
                String emailadress = emailadressTextField.getText();
                String LEVEL = LEVELTextField.getText();
                String id = idTextField.getText();
                String sertifikadate = sertifikadateTextField.getText();


                try {
                    stmt.executeUpdate("INSERT INTO Mitarbeiter(AD, SOYAD,emailadres, LEVEL , id, Sertifikadate) VALUES ('" + ad + "', '" + SOYAD + "' , '" + emailadress + "', '" + LEVEL + "' , '" + id + "' , '" + sertifikadate + "')");


                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        });


        SİLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String çalışanid = çalışanIdTextField.getText();
                try {
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate("DELETE FROM Mitarbeiter WHERE id=" + çalışanid + "");
                    con.commit();

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());


                }
            }
        });
        GÜNCELLEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ad = adTextField.getText();
                String SOYAD = SOYADTextField.getText();
                String emailadress = emailadressTextField.getText();
                String LEVEL = LEVELTextField.getText();
                String id = idTextField.getText();
                String sertifikadate = sertifikadateTextField.getText();

                try {
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate("UPDATE Mitarbeiter SET  AD = '" + ad + "', SOYAD = '" + SOYAD + "', Emailadres = '" + emailadress + "' , LEVEL = '" + LEVEL + "' , Sertifikadate = '" + sertifikadate + "'  WHERE id = id ") ;
                    con.commit();
                } catch (SQLException a) {
                    a.printStackTrace();
                }
            }
        });
    }



                /*String çalışanid = çalışanIdTextField.getText();
        String id = idTextField.getText();
        try{
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = stmt.executeQuery("DELETE FROM Mitarbeiter WHERE  id = '" +çalışanid +"'");

        }
        catch (
                SQLException a) {
            a.printStackTrace();
        } */


        public static void main (String[]args){
            JFrame frame = new JFrame("mainpage");
            frame.setContentPane(new mainpage().ekran);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);


            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;database=inf202;integratedSecurity=true;";

                con = DriverManager.getConnection(url, "izel", "123456");
                System.out.println("Database connected!");
                stmt = con.createStatement();
                resultSet = stmt.executeQuery("SELECT* FROM Mitarbeiter");


            } catch (ClassNotFoundException e) {
                System.out.println("Database connection error:" + e);
            } catch (SQLException e) {
                System.out.println("Database connection error:" + e);
            }
        }


    }




























































































































































































































