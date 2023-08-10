

// abstract class Bank {
//     Bank(){

//     }
//      abstract void getBalance();

// }
// class A extends Bank{
//     A(){

//     }
//     void getBalance(){
//         System.out.println("A balance is"+100);
//     }
// }
// class B extends Bank{
//     B()
//     {

//     }
//      void getBalance(){
//         System.out.println("B balance is "+150);
//     }
// }
// class C extends Bank{
//     C(){

//     }
//     void getBalance(){
//         System.out.println("C Balance "+200);
//     }
// }
//  class getBalance{

//     public static void main(String[] args)
//     {
//     //  throw new Exception();
//       Bank a=new A();
//       a.getBalance();
//       Bank b=new B();
//       b.getBalance();
//       Bank c=new C();
//       c.getBalance();
//     }
// }
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegistrationGUI {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    private JFrame frame;
    private JTextField nameField;
    private JTextField emailField;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RegistrationGUI registrationGUI = new RegistrationGUI();
                registrationGUI.createAndShowGUI();
            }
        });
    }

    public void createAndShowGUI() {
        frame = new JFrame("Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();

                // Save the registration data to the database
                saveRegistrationData(name, email);
            }
        });

        JButton readButton = new JButton("Read Data");
        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Read data from the database and display it
                readDataFromDatabase();
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(submitButton);
        panel.add(readButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void saveRegistrationData(String name, String email) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement statement = conn.prepareStatement("INSERT INTO users (name, email) VALUES (?, ?)");
            statement.setString(1, name);
            statement.setString(2, email);
            statement.executeUpdate();
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(frame, "Registration data saved to the database.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void readDataFromDatabase() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            StringBuilder data = new StringBuilder();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                data.append("Name: ").append(name).append(", Email: ").append(email).append("\n");
            }

            resultSet.close();
            statement.close();
            conn.close();

            JOptionPane.showMessageDialog(frame, data.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


