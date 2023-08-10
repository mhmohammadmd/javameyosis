import java.awt.*;
import java.awt.event.*;

class GUIDemo {
    public static void main(String[] args) {
        Frame f = new Frame("Registration Form");

        Label nameLabel = new Label("Name:");
        nameLabel.setBounds(50, 50, 100, 20);
        TextField nameTextField = new TextField();
        nameTextField.setBounds(170, 50, 150, 20);

        Label enrollmentLabel = new Label("Enrollment Number:");
        enrollmentLabel.setBounds(50, 75, 120, 20);
        TextField enrollmentTextField = new TextField();
        enrollmentTextField.setBounds(170, 75, 150, 20);

        Label hobbiesLabel = new Label("Hobbies:");
        hobbiesLabel.setBounds(50, 100, 100, 20);
        TextField hobbiesTextField = new TextField();
        hobbiesTextField.setBounds(170, 100, 150, 20);

        Label addressLabel = new Label("Address:");
        addressLabel.setBounds(50, 125, 100, 20);
        TextField addressTextField = new TextField();
        addressTextField.setBounds(170, 125, 150, 20);

        Label genderLabel = new Label("Gender:");
        genderLabel.setBounds(50, 150, 100, 20);

        CheckboxGroup cbg = new CheckboxGroup();
        Checkbox maleCheckbox = new Checkbox("Male", cbg, false);
        maleCheckbox.setBounds(170, 150, 60, 20);
        Checkbox femaleCheckbox = new Checkbox("Female", cbg, false);
        femaleCheckbox.setBounds(240, 150, 70, 20);
        Checkbox otherCheckbox = new Checkbox("Other", cbg, false);
        otherCheckbox.setBounds(320, 150, 70, 20);

        Button resetButton = new Button("Reset");
        resetButton.setBounds(106, 190, 100, 30);

        Button SubmitButton = new Button("Register");
        SubmitButton.setBounds(220, 190, 100, 30);

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameTextField.setText("");
                enrollmentTextField.setText("");
                hobbiesTextField.setText("");
                addressTextField.setText("");
                maleCheckbox.setState(false);
                femaleCheckbox.setState(false);
                otherCheckbox.setState(false);
            }
        });

        //  private void register() {
        // String nameLabel = nameTextField.getText();
        // String enrollmentLabel= enrollmentTextField.getText();
        // String hobbiesLabel = hobbiesTextField.getText();
        // String addressLabel=addressTextField.getText();
        // String maleCheckbox = maleCheckbox.getState();
        //new String(passwordField.getPassword());

        // Validate and process the registration details
        // if (nameLabel.isEmpty() || enrollmentLabel.isEmpty() || hobbiesLabel.isEmpty() || addressLabel.isEmpty()) {
        //     JOptionPane.showMessageDialog(this, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        // } else {
        //     // Registration successful, show a success message
        //     JOptionPane.showMessageDialog(this, "Registration Successful! \n\nName: " + firstName + " " + lastName + "\nEmail: " + email, "Success", JOptionPane.INFORMATION_MESSAGE);
        // }

        f.add(SubmitButton);
        f.add(nameLabel);
        f.add(nameTextField);
        f.add(enrollmentLabel);
        f.add(enrollmentTextField);
        f.add(hobbiesLabel);
        f.add(hobbiesTextField);
        f.add(addressLabel);
        f.add(addressTextField);
        f.add(genderLabel);
        f.add(maleCheckbox);
        f.add(femaleCheckbox);
        f.add(otherCheckbox);
        f.add(resetButton);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
}
}

