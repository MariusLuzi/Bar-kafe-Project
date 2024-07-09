import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginDialog extends JDialog {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private boolean succeeded;

    public LoginDialog(JFrame parent) {
        super(parent, "Login", true);

        // Setup the panel and layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;

        // Username Label
        JLabel lbUsername = new JLabel("Username:");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);

        // Username Field
        usernameField = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(usernameField, cs);

        // Password Label
        JLabel lbPassword = new JLabel("Password:");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);

        // Password Field
        passwordField = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(passwordField, cs);

        // Error Label (optional)
        JLabel errorLabel = new JLabel("      ");
        errorLabel.setForeground(Color.RED);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(errorLabel, cs);

        // Login Button
        loginButton = new JButton("Login");
        JPanel bp = new JPanel();
        bp.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (authenticate(getUsername(), getPassword())) {
                    succeeded = true;
                    dispose();
                } else {
                    succeeded = false;
                    errorLabel.setText("Invalid username or password");
                }
            }
        });

        // Final setup
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    private boolean authenticate(String username, String password) {
        // Example authentication logic, replace with your own
        return "admin".equals(username) && "12345".equals(password);
    }

    public String getUsername() {
        return usernameField.getText().trim();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public boolean isSucceeded() {
        return succeeded;
    }
}



