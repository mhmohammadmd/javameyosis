import java.awt.*;
import java.awt.event.*;
import java.net.*;

class DNS {
    public static void main(String[] args) {
        Frame f = new Frame("DNS Domain name server");

        Label urlLabel = new Label("Enter URL:");
        urlLabel.setBounds(50, 50, 100, 20);

        TextField urlTextField = new TextField();
        urlTextField.setBounds(170, 50, 150, 20);

        Button lookupButton = new Button("Find IP");
        lookupButton.setBounds(150, 100, 100, 30);

        Label resultLabel = new Label("IP Address:");
        resultLabel.setBounds(50, 150, 100, 20);

        TextField resultTextField = new TextField();
        resultTextField.setBounds(170, 150, 150, 20);
        resultTextField.setEditable(false);

        lookupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String url = urlTextField.getText();
                try {
                    InetAddress address = InetAddress.getByName(url);
                    String ipAddress = address.getHostAddress();
                    resultTextField.setText(ipAddress);
                } catch (UnknownHostException ex) {
                    resultTextField.setText("Invalid URL");
                }
            }
        });

        f.add(urlLabel);
        f.add(urlTextField);
        f.add(lookupButton);
        f.add(resultLabel);
        f.add(resultTextField);
        f.setSize(400, 250);
        f.setLayout(null);
        f.setVisible(true);

    }
}
