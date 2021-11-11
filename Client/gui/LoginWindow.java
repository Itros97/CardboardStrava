package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class LoginWindow extends JFrame {
    private JTextField txtInsertUser;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginWindow frame = new LoginWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public LoginWindow() {
        setTitle("Login Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 385);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("User e-mail");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 30));
        lblNewLabel.setBounds(70, 50, 150, 30);
        getContentPane().add(lblNewLabel);

        txtInsertUser = new JTextField();
        txtInsertUser.setToolTipText("insert user");
        txtInsertUser.setFont(new Font("Arial", Font.PLAIN, 15));
        txtInsertUser.setBounds(40, 100, 400, 25);
        getContentPane().add(txtInsertUser);
        txtInsertUser.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("User e-mail password");
        lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 30));
        lblNewLabel_1.setBounds(70, 170, 300, 30);
        getContentPane().add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.setBounds(190, 290, 88, 25);
        getContentPane().add(btnNewButton);

        passwordField = new JPasswordField();
        passwordField.setToolTipText("insert password");
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setBounds(40, 220, 400, 25);
        getContentPane().add(passwordField);
    }
}