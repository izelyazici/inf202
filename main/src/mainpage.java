import javax.swing.*;

public class mainpage extends JFrame {
    private JPanel ekran;
    private JButton LOGİNButton;
    private JTextField USERTextField;
    private JPasswordField PASSWORTPasswordField;
    private JButton SİGNUPButton;
    private JLabel user;

    public static void main(String args[]){
        JFrame frame = new JFrame("mainpage");
        frame.setContentPane ( new mainpage().ekran);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}

