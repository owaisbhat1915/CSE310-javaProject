import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class LoginFrame extends JFrame implements ActionListener {
    
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private Map<String, String> users;
    
    public LoginFrame() {
        setTitle("Login");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(36, 47, 65));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Add a welcome message
        JLabel welcomeLabel = new JLabel("Welcome to the OCTA PUZZLE");
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeLabel.setForeground(new Color(240, 240, 240));
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(welcomeLabel, gbc);
        
        // Add some padding
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weighty = 0.2;
        panel.add(Box.createRigidArea(new Dimension(0, 20)), gbc);
        
        // Add the username field
        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(new Color(240, 240, 240));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(userLabel, gbc);
        
        gbc.gridx = 1;
        userField = new JTextField(20);
        panel.add(userField, gbc);
        
        // Add the password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(new Color(240, 240, 240));
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(passwordLabel, gbc);
        
        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        panel.add(passwordField, gbc);
        
        // Add the login button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setForeground(new Color(240, 240, 240));
        loginButton.setBackground(new Color(41, 128, 185));
        loginButton.setBorderPainted(false);
        loginButton.setFocusPainted(false);
        loginButton.setPreferredSize(new Dimension(100, 30));
        buttonPanel.setBackground(new Color(36, 47, 65)); // Set background color
        buttonPanel.add(loginButton);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(buttonPanel, gbc);
        
        add(panel);
        setVisible(true);
        
        // read users and passwords from file
        users = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("verification.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                users.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String password = new String(passwordField.getPassword());
        if (users.containsKey(username) && users.get(username).equals(password)) {
            // JOptionPane.showMessageDialog(this, "Login successful!");
            new Puzzle();
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(this, "Invalid username or password");
        }
    }
    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
    }

}